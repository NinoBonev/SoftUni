$(() => {
    const baseUrl = "https://baas.kinvey.com/appdata/";
    const userUrl = "https://baas.kinvey.com/user/";
    const appKey = "kid_B1wbRswDm";
    const appSecret = "3d61350186c44ab09fcd8c3429398a24";
    const authorization = {"Authorization": "Basic " + btoa(appKey + ":" + appSecret)};

//VARIABLES
    let authToken;
    let profile = $('#profile');
    let navBar = $('nav');
    let main = $('#main');
    let login = $('#login');
    let register = $('#register');
    let memeFeed = $('#meme-feed');
    let createMeme = $("#create-meme");
    let editMeme = $('#edit-meme');
    let userProfile = $('.user-profile');
    let memeDetails = $('.meme-details');
    let welcomeButtons = $('#button-div');

    let requester = (function () {

        function makeAuthorization() {
            if (localStorage.getItem("authToken") === null) {
                return authorization;
            } else {
                return {"Authorization": "Kinvey " + localStorage.getItem("authToken")};
            }
        }

        function makeRequest(method, url, endPoint) {
            return {
                method: method,
                url: url + appKey + endPoint,
                headers: makeAuthorization(),
                contentType: "application/json",
            };
        }

        function get(url, end) {
            return $.ajax(makeRequest("GET", url, end));
        }

        function post(url, data, end) {
            let request = makeRequest("POST", url, end);
            request.data = JSON.stringify(data);
            return $.ajax(request)
        }

        function put(url, data, end) {
            let request = makeRequest("PUT", url, end);
            request.data = JSON.stringify(data);
            return $.ajax(request);
        }

        function remove(url, end) {
            return $.ajax(makeRequest("DELETE", url, end));
        }

        return {get, post, put, remove}

    })();

    navigationBar();

    //Events
    login.find('a:first-child').on('click', showRegisterView);
    register.find('a:first-child').on('click',showLoginView );
    navBar.find('.active').on('click', showMainView);
    navBar.find('a:eq(1)').on('click', showCreateMemeView);
    //profile.find('a:eq(1)').on('click', loadUserProfile);
    welcomeButtons.find('a:first-child').on('click', showLoginView);
    welcomeButtons.find('a:eq(1)').on('click', showRegisterView);
    register.on('submit', registerUser);
    login.on('submit', loginUser);
    profile.find('a:eq(2)').on('click', logoutUser);
    createMeme.on('submit', createNewMeme);
    editMeme.on('submit', editNewMeme);

    //VIEWS
    function showMainView() {
        if (authToken === null) {
            main.show();
            login.hide();
            register.hide();
            memeFeed.hide();
            createMeme.hide();
            memeDetails.hide();
            editMeme.hide();
            userProfile.hide();
        } else {
            main.hide();
            login.hide();
            register.hide();
            memeFeed.show();
            createMeme.hide();
            memeDetails.hide();
            editMeme.hide();
            userProfile.hide();
        }

    }

    function showLoginView() {
        main.hide();
        login.show();
        register.hide();
        memeFeed.hide();
        createMeme.hide();
        memeDetails.hide();
        editMeme.hide();
        userProfile.hide();
    }

    function showRegisterView() {
        main.hide();
        login.hide();
        register.show();
        memeFeed.hide();
        createMeme.hide();
        memeDetails.hide();
        editMeme.hide();
        userProfile.hide();
    }

    function showAllListingsView() {
        main.hide();
        login.hide();
        register.hide();
        memeFeed.show();
        createMeme.hide();
        memeDetails.hide();
        editMeme.hide();
        userProfile.hide();
    }

    function showCreateMemeView() {
        main.hide();
        login.hide();
        register.hide();
        memeFeed.hide();
        createMeme.show();
        memeDetails.hide();
        editMeme.hide();
        userProfile.hide();
    }

    function showEditView() {
        main.hide();
        login.hide();
        register.hide();
        memeFeed.hide();
        createMeme.hide();
        memeDetails.hide();
        editMeme.show();
        userProfile.hide();
    }

    function showUserProfile() {
        main.hide();
        login.hide();
        register.hide();
        memeFeed.hide();
        createMeme.hide();
        memeDetails.hide();
        editMeme.hide();
        userProfile.show();
    }

    function showDetails() {
        main.hide();
        login.hide();
        register.hide();
        memeFeed.hide();
        createMeme.hide();
        memeDetails.show();
        editMeme.hide();
        userProfile.hide();
    }

    $("#infoBox, #errorBox").on("click", function () {
        $(this).fadeOut();
    });

    $(document).on({
        ajaxStart: function () {
            $("#loadingBox").show();
        },
        ajaxStop: function () {
            $("#loadingBox").hide();
        }
    });

    //Set the default and other visibility of the Navigation Bar
    function navigationBar() {

        authToken = localStorage.getItem("authToken");
        $('#container').show();

        if (authToken === null) {
            navBar.find('a').hide();
            navBar.find('.active').show();
            showMainView();
            welcomeButtons.show();
            profile.hide();
        } else {
            welcomeButtons.hide();
            navBar.find('a').show();
            navBar.find('.active').show();
            loadAllListings();
            profile.show();
            profile.find("a:first-child").text("Welcome " + localStorage.getItem("username"))
        }
    }

    //CRUD
    async function loadAllListings() {
        let end = '/memes?query={}&sort={"_kmd.ect": -1}';
        let memes = $('#memes');
        memes.empty();

        try {
            let response = await requester.get(baseUrl, end)
            if (response.length > 0) {
                for (let i = 0; i < response.length; i++) {
                    createMemeListing(response[i], memes, i)
                }
            } else {
                memes.append($('<p class="no-memes">No memes in database.</p>'))
            }
        } catch (e) {
            handleError(e)
        }

        showAllListingsView()
    }

    async function loadUserProfile(obj) {
        let user = await showUser(obj);

        let username = user.username;
        let email = user.email;
        let imageUrl = user.avatarUrl;

        let end = `/memes?query={"creator":"${username}"}&sort={"_kmd.ect": -1}`
        let form = $('.user-profile');
        form.empty();

        form.append($(`<img id="user-avatar-url" src="${imageUrl}" alt="user-profile">`))
            .append($('<h1>user</h1>'))
            .append($(`<h2>${email}</h2>`))
            .append($('<a id="deleteUserButton" href="#">DELETE USER!</a>')
                .on('click', deleteUser))
            .append($('<p id="user-listings-title">User Memes</p>'))
            .append($('<div class="user-meme-listings">'));


        try {
            let response = await requester.get(baseUrl, end);
            if (response.length > 0) {
                for (let i = 0; i < response.length; i++) {
                    createUserProfile(response[0], form);
                }
            } else {
                $(form.find(".user-meme-listings"))
                    .append($('<p class="no-memes">No memes in database.</p>'))
            }

        } catch (e) {
            handleError(e)
        }

        if (username !== localStorage.getItem("username")) {
            $('#deleteUserButton').hide();
        }
        showUserProfile();
    }

    async function createMemeListing(obj, form, current) {

        let creator = obj.creator;


        form.append($('<div>').addClass("meme")
            .append($(`<a href="#">${obj.title}</a>`)
                .addClass("meme-title")
                .on('click', showDetails(obj)))
            .append($('<br>'))
            .append($('<a href="#">')
                .append($(`<img class="meme-image" src="${obj.imageUrl}">`)))
            .append($('<div>').addClass("info")
                .append($('<div id="data-buttons">'))));

        let list = $(form.find(`div[id="data-buttons"]:eq(${current})`));

        list.append($('<a href="#">Check Out</a>')
            .addClass("custom-button")
            .on('click', () => showMemeDetails(obj)));

        if (creator === localStorage.getItem("username")) {
            list.append($(`<a href="#">Edit</a>`)
                .addClass("custom-button")
                .on('click', () => prepareMemeEditDetails(obj)));
            list.append($(`<a href="#">Delete</a>`)
                .addClass("custom-button")
                .on('click', () => deleteMeme(obj)));
        }

        list.append($(`<a href="#">Creator: ${creator}</a>`)
            .addClass("creator")
            .on('click', () => loadUserProfile(obj)));

    }

    async function showMe() {

        let id = localStorage.getItem("userId");

        try {
            let response = await requester.get(userUrl, `/${id}`);
            return response;
        } catch (e) {
            handleError(e)
        }


    }

    async function showUser(obj) {

        let id = obj._acl.creator;

        try {
            let response = await requester.get(userUrl, `/${id}`);
            return response;
        } catch (e) {
            handleError(e)
        }


    }

    async function createUserProfile(obj, form) {
        console.log(email);
        console.log(obj);

         let list = $(form.find(".user-meme-listi"));

        list.append($('<div class="user-meme">')
            .append($(`<a href="#" class="user-meme-title">${obj.title}</a>`))
            .append($('<a href="#">')
                .append($(`<img class="userProfileImage" src="${obj.imageUrl}">`)))
            .append($('<div class="user-memes-buttons">')))

        if (user === localStorage.getItem("username")){
            $(list.find('.user-memes-buttons'))
                .append($('<a href="#" class="user-meme-btn">Edit</a>')
                    .on('click', editNewMeme(obj)))
                .append($('<a href="#" class="user-meme-btn">Delete</a>')
                    .on('click', deleteMeme(obj)))
        }
    }

    async function createNewMeme(e) {
        e.preventDefault();

        let creator = localStorage.getItem("username")
        let title = createMeme.find('input[name="title"]').val();
        let description = createMeme.find('input[name="description"]').val();
        let imageUrl = createMeme.find('input[name="imageUrl"]').val();

        if (!title || !description || !imageUrl) {
            showInfo("All fields are required!");
            return;
        }

        if (title.length > 33) {
            showInfo("The title length is too long!");
            return;
        }

        if (description.length > 450) {
            showInfo("The description length is too long!");
            return;
        }

        if (description.length < 30) {
            showInfo("The description length is too short!");
            return;
        }

        if (imageUrl.slice(0, 4) !== 'http') {
            showInfo("The imageUrl should start with \'http\'");
        }

        let data = {
            creator: creator,
            title: title,
            description: description,
            imageUrl: imageUrl,

        };

        try {
            let response = await requester.post(baseUrl, data, "/memes");
            createMeme.find('form').trigger("reset");
            showInfo("meme created.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function editNewMeme(e) {
        e.preventDefault();

        let id = editMeme.find(`input[name="title"]`).attr("value");
        let creator = editMeme.find(`input[name="title"]`).attr("creator");
        let title = editMeme.find(`input[name="title"]`).val();
        let description = editMeme.find(`input[name="description"]`).val();
        let imageUrl = editMeme.find(`input[name="imageUrl"]`).val();

        if (!title || !description || !imageUrl) {
            showInfo("All fields are required!");
            return;
        }

        if (title.length > 33) {
            showInfo("The title length is too long!");
            return;
        }

        if (description.length > 450) {
            showInfo("The description length is too long!");
            return;
        }

        if (description.length < 30) {
            showInfo("The description length is too short!");
            return;
        }

        if (imageUrl.slice(0, 4) !== 'http') {
            showInfo("The imageUrl should start with \'http\'");
        }

        let data = {
            creator: creator,
            title: title,
            description: description,
            imageUrl: imageUrl,

        };

        try {
            let response = await requester.put(baseUrl, data, "/memes/" + id);
            editMeme.find('form').trigger("reset");
            showInfo(`Listing ${title} updated.`);
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function showMemeDetails(obj) {

        let creator = obj.creator;
        let form = $('.meme-details');
        form.empty();

        form.append($('<div>').addClass("my-meme-details")
            .append($(`<a href="#" id="meme-title">${obj.title}</a>`))
            .append($(`<img src="${obj.imageUrl}">`))
            .append($('<div>').addClass("meme-props")
                .append($(`<h2>Description</h2>`))
                .append($(`<p>${obj.description}</p>`)))
            .append($('<div>')
                .addClass("meme-details-buttons")));

        let list = $(form.find(".meme-details-buttons").slice(-1));

        list.append($(`<a href="#">Created by ${creator}</a>`)
            .addClass("meme-details-button")
            .on('click', () => loadUserProfile(obj)));

        if (creator === localStorage.getItem("username")) {
            list.append($(`<a href="#">Edit</a>`)
                .addClass("meme-details-button")
                .on('click', () => prepareMemeEditDetails(obj)));
            list.append($(`<a href="#">Delete</a>`)
                .addClass("meme-details-button")
                .on('click', () => deleteMeme(obj)));
        }
        showDetails();
    }

    function prepareMemeEditDetails(obj) {
        editMeme.find(`input[name="title"]`).val(obj.title);
        editMeme.find(`input[name="description"]`).val(obj.description);
        editMeme.find(`input[name="imageUrl"]`).val(obj.imageUrl);
        editMeme.find(`input[name="title"]`).attr("value", obj._id);
        editMeme.find(`input[name="title"]`).attr("creator", obj.creator);

        showEditView()
    }

    async function deleteMeme(obj) {
        let id = obj._id;

        try {
            let response = await requester.remove(baseUrl, "/memes/" + id);
            showInfo("Listing deleted.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    // USERS
    async function registerUser(e) {
        e.preventDefault();

        let username = register.find(`input[name="username"]`).val();
        let password = register.find(`input[name="password"]`).val();
        let passwordCheck = register.find(`input[name="repeatPass"]`).val();
        let email = register.find(`input[name="email"]`).val();
        let avatarUrl = register.find(`input[name="avatarUrl"]`).val();

        if (!password || !passwordCheck || !username) {
            showError("The fields can not be empty");
            return;
        }

        if (!(/^[A-Za-z]{3,}$/.test(username))) {
            showError("Invalid username! It must be at least 5 characters long.");
            return
        }

        if (!(/^[A-Za-z0-9]{6,}$/.test(password))) {
            showError("Password is too weak, it must be at least 6 characters long");
            return;
        }

        if (password !== passwordCheck) {
            showError("Your password and confirm password do not match");
            return;
        }

        console.log(email);
        console.log(avatarUrl);

        let data = {
            username: username,
            email: email,
            avatarUrl: avatarUrl,
            password: password
        }

        try {
            let response = await requester.post(userUrl, data, "");
            register.trigger("reset");
            saveLocalStorageSession(response);
            showInfo("User registration successful.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function loginUser(e) {
        e.preventDefault();

        let username = login.find(`input[name="username"]`).val();
        let password = login.find(`input[name="password"]`).val();

        if (!password || !username) {
            showError("The fields can not be empty");
            return;
        }

        let data = {username: username, password: password};

        try {
            let response = await requester.post(userUrl, data, "/login");
            login.trigger("reset");
            saveLocalStorageSession(response);
            showInfo("Login successful.");
            navigationBar(handleError);
        } catch (e) {
            handleError(e)
        }
    }

    async function logoutUser(e) {
        e.preventDefault();

        try {
            let response = await requester.post(userUrl, {}, "/_logout");
            localStorage.clear();
            showInfo("Logout successful.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function deleteUser(e) {
        e.preventDefault();

        let userId = localStorage.getItem("userId")

        try {
            let response = await requester.remove(userUrl, `/${userId}`);
            localStorage.clear();
            showInfo("User deleted.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    function saveLocalStorageSession(response) {
        localStorage.setItem("authToken", response._kmd.authtoken);
        localStorage.setItem("username", response.username);
        localStorage.setItem("userId", response._id)
    }

    function handleError(err) {
        let errorMsg = err.status + " " + err.statusText;
        if (err.responseJSON && err.responseJSON.error) {
            errorMsg += "! " + err.responseJSON.error;
        }
        showError(errorMsg);
    }

    function showInfo(info) {
        let box = $("#infoBox");
        box.show();
        box.find("span").text(info);

        setTimeout(() => box.hide(), 3000);
    }

    function showError(err) {
        $("#errorBox").show();
        $("#errorBox > span").text(err);
    }
})