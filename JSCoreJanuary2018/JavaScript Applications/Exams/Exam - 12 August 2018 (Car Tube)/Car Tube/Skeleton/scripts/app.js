$(() => {
    const baseUrl = "https://baas.kinvey.com/appdata/";
    const userUrl = "https://baas.kinvey.com/user/";
    const appKey = "kid_HJtqjl4L7";
    const appSecret = "200c5f1dc3784e1f92b941790e094396";
    const authorization = {"Authorization": "Basic " + btoa(appKey + ":" + appSecret)};

//VARIABLES
    let authToken;
    let profile = $('#profile');
    let navBar = $('nav');
    let main = $('#main');
    let login = $('#login');
    let register = $('#register');
    let carListings = $('#car-listings');
    let createListing = $("#create-listing");
    let editListing = $('#edit-listing');
    let myListings = $('.my-listings');
    let listingDetails = $('.listing-details');
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

    //EVENTS
    navBar.find('.active').on('click', showMainView);
    navBar.find('a:eq(1)').on('click', loadAllListings);
    navBar.find('a:eq(2)').on('click', loadMyListings);
    navBar.find('a:eq(3)').on('click', showCreateListingView);
    welcomeButtons.find('a:first-child').on('click', showLoginView);
    welcomeButtons.find('a:eq(1)').on('click', showRegisterView);
    register.on('submit', registerUser);
    login.on('submit', loginUser);
    profile.find('a:eq(1)').on('click', logoutUser);
    createListing.on('submit', createNewListing);
    editListing.on('submit', editCar);

    //VIEWS
    function showMainView() {
        main.show();
        login.hide();
        register.hide();
        carListings.hide();
        createListing.hide();
        editListing.hide();
        myListings.hide();
        listingDetails.hide();
    }

    function showLoginView() {
        main.hide();
        login.show();
        register.hide();
        carListings.hide();
        createListing.hide();
        editListing.hide();
        myListings.hide();
        listingDetails.hide();
    }

    function showRegisterView() {
        main.hide();
        login.hide();
        register.show();
        carListings.hide();
        createListing.hide();
        editListing.hide();
        myListings.hide();
        listingDetails.hide();
    }

    function showAllListingsView() {
        main.hide();
        login.hide();
        register.hide();
        carListings.show();
        createListing.hide();
        editListing.hide();
        myListings.hide();
        listingDetails.hide();
    }

    function showCreateListingView() {
        main.hide();
        login.hide();
        register.hide();
        carListings.hide();
        createListing.show();
        editListing.hide();
        myListings.hide();
        listingDetails.hide();
    }

    function showEditView() {
        main.hide();
        login.hide();
        register.hide();
        carListings.hide();
        createListing.hide();
        editListing.show();
        myListings.hide();
        listingDetails.hide();
    }

    function showMyListings() {
        main.hide();
        login.hide();
        register.hide();
        carListings.hide();
        createListing.hide();
        editListing.hide();
        myListings.show();
        listingDetails.hide();
    }

    function showDetails() {
        main.hide();
        login.hide();
        register.hide();
        carListings.hide();
        createListing.hide();
        editListing.hide();
        myListings.hide();
        listingDetails.show();
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
            $('#welcome-container').find("h2").show()
            welcomeButtons.show()
            profile.hide()
        } else {
            $('#welcome-container').find("h2").hide()
            welcomeButtons.hide()
            navBar.find('a').show();
            navBar.find('.active').show();
            loadAllListings()
            profile.show();
            profile.find("a:first-child").text("Welcome " + localStorage.getItem("username"))
        }
    }

    //CRUD
    async function loadAllListings() {
        let end = '/cars?query={}&sort={"_kmd.ect": -1}'
        let form = $('#listings');
        form.empty();

        try {
            let response = await requester.get(baseUrl, end)
            if (response.length > 0) {
                for (let i = 0; i < response.length; i++) {
                    createCarListing(response[i], form)
                }
            } else {
                form.append($('<p>No listings in database</p>'))
            }
        } catch (e) {
            handleError(e)
        }

        showAllListingsView()
    }

    async function loadMyListings() {
        let username = localStorage.getItem("username")
        let end = `/cars?query={"seller":"${username}"}&sort={"_kmd.ect": -1}`
        let form = $('.car-listings')
        form.empty();

        try {
            let response = await requester.get(baseUrl, end);
            if (response.length > 0) {
                for (let i = 0; i < response.length; i++) {
                    createMyCarListing(response[i], form)
                }
            } else {
                form.append($('<p>No listings in database</p>'))
            }
        } catch (e) {
            handleError(e)
        }

        showMyListings();
    }

    function createCarListing(obj, form) {
        let creator = obj.seller;

        form.append($('<div>').addClass("listing")
            .append($(`<p>${obj.title}</p>`))
            .append($(`<img src="${obj.imageUrl}">`))
            .append($(`<h2>Brand: ${obj.brand}</h2>`))
            .append($('<div>').addClass("info")
                .append($('<div id="data-info">')
                    .append($(`<h3>Seller: ${obj.seller}</h3>`))
                    .append($(`<h3>Fuel: ${obj.fuel}</h3>`))
                    .append($(`<h3>Year: ${obj.year}</h3>`))
                    .append($(`<h3>Price: ${obj.price}$</h3>`)))
                .append($('<div id="data-buttons">')
                    .append($('<ul>')))));

        let list = $(form.find("ul").slice(-1));

        list.append($('<li>').addClass("action")
            .append($(`<a href="#">Details</a>`)
                .addClass("button-carDetails")
                .on('click', () => showCarDetails(obj))));

        if (creator === localStorage.getItem("username")) {
            list.append($('<li>').addClass("action")
                .append($(`<a href="#">Edit</a>`)
                    .addClass("button-carDetails")
                    .on('click', () => prepareCarEditDetails(obj))));
            list.append($('<li>').addClass("action")
                .append($(`<a href="#">Delete</a>`)
                    .addClass("button-carDetails")
                    .on('click', () => deleteCar(obj))));
        }
    }

    function createMyCarListing(obj, form) {
        form.append($('<div>').addClass("my-listing")
            .append($(`<p id="listing-title">${obj.title}</p>`))
            .append($(`<img src="${obj.imageUrl}">`))
            .append($('<div>').addClass("listing-props")
                .append($(`<h2>Brand: ${obj.brand}</h2>`))
                .append($(`<h3>Model: ${obj.model}</h3>`))
                .append($(`<h3>Year: ${obj.year}</h3>`))
                .append($(`<h3>Price: ${obj.price}$</h3>`)))
            .append($('<div>')
                .addClass("my-listing-buttons")
                .append($(`<a href="#">Details</a>`)
                    .addClass("my-button-list")
                    .on('click', () => showCarDetails(obj)))
                .append($(`<a href="#">Edit</a>`)
                    .addClass("my-button-list")
                    .on('click', () => prepareCarEditDetails(obj)))
                .append($(`<a href="#">Delete</a>`)
                    .addClass("my-button-list")
                    .on('click', () => deleteCar(obj)))));
    }

    async function createNewListing(e) {
        e.preventDefault();

        let title = createListing.find(`input[name="title"]`).val();
        let description = createListing.find(`input[name="description"]`).val();
        let brand = createListing.find(`input[name="brand"]`).val();
        let model = createListing.find(`input[name="model"]`).val();
        let year = createListing.find(`input[name="year"]`).val();
        let imageUrl = createListing.find(`input[name="imageUrl"]`).val();
        let fuelType = createListing.find(`input[name="fuelType"]`).val();
        let price = createListing.find(`input[name="price"]`).val();


        if (!title || !description || !brand || !model || !year || !imageUrl || !fuelType || !price) {
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

        if (brand.length > 11) {
            showInfo("The brand length is too long!");
            return;
        }

        if (fuelType.length > 11) {
            showInfo("The fuelType length is too long!");
            return;
        }

        if (model.length > 11) {
            showInfo("The model length is too long!");
            return;
        }

        if (model.length < 4) {
            showInfo("The model length is too short!");
            return;
        }

        if (year.length !== 4) {
            showInfo("The year length is incorrect!");
            return;
        }

        if (price > 1000000) {
            showInfo("The maximum price is 1000000!");
            return;
        }

        if (imageUrl.slice(0, 4) !== 'http') {
            showInfo("The imageUrl should start with \'http\'");
        }

        let data = {
            brand: brand,
            description: description,
            fuel: fuelType,
            imageUrl: imageUrl,
            isAuthor: true,
            model: model,
            price: price,
            seller: localStorage.getItem("username"),
            title: title,
            year: Number(year)
        };

        try {
            let response = await requester.post(baseUrl, data, "/cars");
            createListing.find('form').trigger("reset");
            showInfo("listing created.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function editCar(e) {
        e.preventDefault();

        let id = editListing.find(`input[name="carId"]`).attr("value");
        let title = editListing.find(`input[name="title"]`).val();
        let description = editListing.find(`input[name="description"]`).val();
        let brand = editListing.find(`input[name="brand"]`).val();
        let model = editListing.find(`input[name="model"]`).val();
        let year = editListing.find(`input[name="year"]`).val();
        let imageUrl = editListing.find(`input[name="imageUrl"]`).val();
        let fuelType = editListing.find(`input[name="fuelType"]`).val();
        let price = editListing.find(`input[name="price"]`).val();

        if (!title || !description || !brand || !model || !year || !imageUrl || !fuelType || !price) {
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

        if (brand.length > 11) {
            showInfo("The brand length is too long!");
            return;
        }

        if (fuelType.length > 11) {
            showInfo("The fuelType length is too long!");
            return;
        }

        if (model.length > 11) {
            showInfo("The model length is too long!");
            return;
        }

        if (model.length < 4) {
            showInfo("The model length is too short!");
            return;
        }

        if (year.length !== 4) {
            showInfo("The year length is incorrect!");
            return;
        }

        if (price > 1000000) {
            showInfo("The maximum price is 1000000!");
            return;
        }

        if (imageUrl.slice(0, 4) !== 'http') {
            showInfo("The imageUrl should start with \'http\'");
        }

        data = {
            brand: brand,
            description: description,
            fuel: fuelType,
            imageUrl: imageUrl,
            isAuthor: true,
            model: model,
            price: price,
            seller: localStorage.getItem("username"),
            title: title,
            year: Number(year)
        }

        try {
            let response = await requester.put(baseUrl, data, "/cars/" + id);
            editListing.find('form').trigger("reset");
            showInfo(`Listing ${title} updated.`);
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function showCarDetails(obj) {
        let creator = obj.seller;
        let form = $('.listing-details');
        form.empty();

        form.append($('<div>').addClass("my-listing-details")
            .append($(`<p id="auto-title">${obj.title}</p>`))
            .append($(`<img src="${obj.imageUrl}">`))
            .append($('<div>').addClass("listing-props")
                .append($(`<h2>Brand: ${obj.brand}</h2>`))
                .append($(`<h3>Model: ${obj.model}</h3>`))
                .append($(`<h3>Year: ${obj.year}</h3>`))
                .append($(`<h3>Fuel: ${obj.fuel}</h3>`))
                .append($(`<h3>Price: ${obj.price}$</h3>`)))
            .append($('<div>')
                .addClass("listings-buttons"))
            .append($('<p id="description-title">Description:</p>'))
            .append($(`<p id="description-para">${obj.description}</p>`)));

        let list = $(form.find(".listings-buttons").slice(-1));

        if (creator === localStorage.getItem("username")) {
            list.append($(`<a href="#">Edit</a>`)
                    .addClass("button-list")
                    .on('click', () => prepareCarEditDetails(obj)));
            list.append($(`<a href="#">Delete</a>`)
                    .addClass("button-list")
                    .on('click', () => deleteCar(obj)));
        }
        showDetails();
    }

    function prepareCarEditDetails(obj) {
        editListing.find(`input[name="title"]`).val(obj.title);
        editListing.find(`input[name="description"]`).val(obj.description);
        editListing.find(`input[name="brand"]`).val(obj.brand);
        editListing.find(`input[name="model"]`).val(obj.model);
        editListing.find(`input[name="year"]`).val(obj.year);
        editListing.find(`input[name="imageUrl"]`).val(obj.imageUrl);
        editListing.find(`input[name="fuelType"]`).val(obj.fuel);
        editListing.find(`input[name="price"]`).val(obj.price);
        editListing.find(`input[name="carId"]`).attr("value", obj._id);
        showEditView()
    }

    async function deleteCar(obj) {
        let id = obj._id;

        try {
            let response = await requester.remove(baseUrl, "/cars/" + id);
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
        let data = {username: username, password: password};

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

    async function logoutUser() {
        try {
            let response = await requester.post(userUrl, {}, "/_logout");
            localStorage.clear();
            showInfo("Logout successful.");
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