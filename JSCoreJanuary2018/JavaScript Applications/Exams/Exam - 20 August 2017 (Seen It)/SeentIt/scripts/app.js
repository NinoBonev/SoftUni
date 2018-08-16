$(() => {
    const baseUrl = "https://baas.kinvey.com/appdata/";
    const userUrl = "https://baas.kinvey.com/user/";
    const appKey = "kid_B1IKTaCSX";
    const appSecret = "d89108b8daa24c17ae311b82a3341396";
    const authorization = {"Authorization": "Basic " + btoa(appKey + ":" + appSecret)};

//VARIABLES
    let authToken;
    let registerForm = $("#registerForm");
    let loginForm = $("#loginForm");
    let profile = $("#profile");
    let viewWelcome = $("#viewWelcome");
    let menu = $("#menu");
    let submitForm = $("#submitForm");
    let editForm = $("#editPostForm");
    let viewComments = $('#viewComments');
    let commentForm = $('#commentForm')

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
    registerForm.on('submit', registerUser);
    loginForm.on('submit', loginUser);
    submitForm.on('submit', createPost);
    editForm.on('submit', editPost);
    commentForm.on('submit', createComment)
    profile.find("a").on('click', logoutUser);
    menu.find("a:eq(0)").on('click', navigationBar);
    menu.find("a:eq(1)").on('click', showSubmitView);
    menu.find("a:eq(2)").on('click', loadMyPosts);

    //VIEWS
    function showView(viewName) {
        $("section").hide();
        $('#' + viewName).show();
    }

    function showCatalogView() {
        showView("viewCatalog")
    }

    function showSubmitView() {
        showView("viewSubmit");
    }

    function showEditView() {
        showView("viewEdit");
    }

    function showMyPostsView() {
        showView("viewMyPosts");
    }

    function showCommentsView() {
        showView("viewComments");
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
        authToken = localStorage.getItem("userId");

        $('#container').show();

        if (authToken === null){
            $('section').hide();
            menu.hide();
            profile.hide();
            viewWelcome.show();
        } else {
            $('section').hide();
            viewWelcome.hide();
            menu.show();
            loadPosts();
            profile.show();
            profile.find("span").text(localStorage.getItem("username"))
        }
    }

    //CRUD
    async function loadPosts() {
        try {
            let response = await requester.get(baseUrl, "/posts");
            let posts = $('#viewCatalog').find('.posts');

            if (response.length > 0){
                createPostView(response, posts, $('#viewCatalog'))
            } else {
                posts.text("No posts in database")
            }
            showCatalogView();
        } catch (e) {
            handleError(e)
        }
    }

    async function loadMyPosts() {
        let username = localStorage.getItem("username");
        let end = `/posts?query={\"author\":\"${username}\"}&sort={\"_kmd.ect\": -1}\n`;

        try {
            let response = await requester.get(baseUrl, end);
            let posts = $("#viewMyPosts").find('.posts');

            if (response.length > 0){
                createPostView(response, posts, $("#viewMyPosts"))
            } else {
                posts.text("No posts in database")
            }
            showMyPostsView();
        } catch (e) {
            handleError(e)
        }
    }

    async function createPost(e) {
        e.preventDefault();

        let linkUrl = submitForm.find(`input[name="url"]`).val();
        let linkTitle = submitForm.find(`input[name="title"]`).val();
        let linkImage = submitForm.find(`input[name="image"]`).val();
        let comments = submitForm.find(`textarea[name="comment"]`).val();
        let author = localStorage.getItem("username")

        if (!linkUrl || !linkTitle){
            showError("The fields can not be empty");
            return;
        }

        if (linkUrl.substring(0, 4) !== 'http') {
            showError("Link should start with \'http\'");
            return;
        }

        let data = {
            author: author,
            title: linkTitle,
            url: linkUrl,
            imageUrl: linkImage,
            description: comments
        };

        try {
            let response = await requester.post(baseUrl, data, "/posts");
            submitForm.trigger("reset");
            $("#errorBox").hide();
            showInfo("Post created.");
            navigationBar();
        } catch (e) {
            handleError(e)
        }
    }

    async function editPost(e) {
        e.preventDefault();

        let linkUrl = editForm.find(`input[name="url"]`).val();
        let linkTitle = editForm.find(`input[name="title"]`).val();
        let linkImage = editForm.find(`input[name="image"]`).val();
        let comments = editForm.find(`textarea[name="comment"]`).val();
        let author = localStorage.getItem("username")
        let id = editForm.attr("postId");

        if (!linkUrl || !linkTitle){
            showError("The fields can not be empty");
            return;
        }

        if (linkUrl.substring(0, 4) !== 'http') {
            showError("Link should start with \'http\'");
            return;
        }

        let data = {
            author: author,
            title: linkTitle,
            url: linkUrl,
            imageUrl: linkImage,
            description: comments
        };

        try {
            let res = await requester.put(baseUrl, data, "/posts/" + id);
            showInfo("Post Updated.");
            editForm.trigger("reset");
            navigationBar();
            $("#errorBox").hide();
        } catch (e) {
            handleError(e)
        }
    }

    async function loadComments(res) {
        let form = $('#viewComments');
        let post = form.find('.clear').parent();
        localStorage.setItem("postId", res._id);

        createDetailsPostView(res, post, $('#viewComments'))

        let end = `/comments?query={"postId":"${res._id}"}&sort={"_kmd.ect": -1}`;
        let commentsForm = form.find('article');

        try {
            let response = await requester.get(baseUrl, end)
            displayComments(response, commentsForm, $('#viewComments'))
            showCommentsView();
        } catch (e) {
            handleError(e)
        }

    }

    async function createComment(e) {
        e.preventDefault();

        let form = $('#viewComments');
        let id = localStorage.getItem("postId");
        let comment = commentForm.find(`textarea[name="content"]`).val();
        let end = `/comments?query={"postId":"${id}"}&sort={"_kmd.ect": -1}`;

        data = {
            postId: id,
            content: comment,
            author: localStorage.getItem("username")
        };

        try {
            let response = await requester.post(baseUrl, data, "/comments");
            commentForm.find(`textarea[name="content"]`).val('');

            let commentsForm = form.find('article');
            let responseReload = await requester.get(baseUrl, end)
            displayComments(responseReload, commentsForm, $('#viewComments'))
            showCommentsView();
        } catch (e) {
            handleError(e)
        }
    }

    function displayComments(res, element, form) {

        let table = element.parent()
        element.remove();

        if (res.length > 0){
            for (let i = 0; i < res.length; i++) {
                let time = calcTime(res[i]._kmd.ect);
                let username = res[i].author;


                let article = $('<article>').addClass("post post-content")
                    .append($(`<p>${res[i].content}</p>`));
                let appendA = $('<a href="#">delete</a>')
                    .addClass("deleteLink")
                    .on('click', () => deleteComment(res[i]));
                if (username === localStorage.getItem("username")){
                    article.append($(`<div>submitted ${time} ago by ${username} | </div>`).addClass("info")
                        .append($('<a href="#">delete</a>')
                            .addClass("deleteLink")
                            .on('click', () => deleteComment(res[i]))));
                } else {
                    article.append($(`<div>submitted ${time} ago by ${username}</div>`).addClass("info"));
                }
                table.append(article);
            }
        } else {
            let article = $('<article>').addClass("post post-content")
                .append($(`<p>No comments yet</p>`));
            table.append(article);
        }


    }

    function createPostView(res, elementDiv, form) {
        elementDiv.empty();

        for (let i = 0; i < res.length; i++) {
            let time = calcTime(res[i]._kmd.ect);
            let username = res[i].author;
            let creatorId = res[i]._acl.creator;

            elementDiv.append($("<article>").addClass("post")
                .append($("<div>")
                    .addClass("col rank")
                    .append(`<span>${i + 1}</span>`))
                .append($("<div>")
                    .addClass("col thumbnail")
                    .append($(`<a href='${res[i].url}'>`)
                        .append($(`<img src='${res[i].imageUrl}'>`))))
                .append($("<div>")
                    .addClass("post-content")
                    .append($("<div>")
                        .addClass("title")
                        .append(`<a href='${res[i].url}'>${res[i].title}</a>`))
                    .append($("<div>").addClass("details")
                        .append($("<div>").addClass("info").text(`Submitte ${time} ago by ${username}`))
                        .append($("<div>").addClass("controls")
                            .append($("<ul>"))))));

            let list = $(form.find("ul").slice(-1));

            list.append($("<li>")
                .addClass("action")
                .append($("<a href='#' class='commentsLink'>comments</a>")
                    .on('click', () => loadComments(res[i]))));

            if (creatorId === localStorage.getItem("userId")) {

                list.append($("<li>")
                    .addClass("action")
                    .append($("<a href='#' class='editLink'>edit</a>")
                        .on("click", () => preparePostForEdit(res[i]))));
                list.append($("<li>")
                    .addClass("action")
                    .append($("<a href='#' class='deleteLink'>delete</a>")
                        .on("click", () => deletePost(res[i]))))
            }
        }
    }

    function createDetailsPostView(res, post, form) {
        post.empty();

        let time = calcTime(res._kmd.ect);
        let username = res.author;
        let creatorId = res._acl.creator;
        let description = res.description !== "" ? res.description : "No description";

        post.append($("<div>")
            .addClass("col thumbnail")
            .append($(`<a href='${res.url}'>`)
                .append($(`<img src='${res.imageUrl}'>`))))
            .append($("<div>")
                .addClass("post-content")
                .append($("<div>")
                    .addClass("title")
                    .append(`<a href='${res.url}'>${res.title}</a>`))
                .append($("<div>")
                    .addClass("details")
                    .append($(`<p>${description}</p>`))
                    .append($("<div>").addClass("info").text(`Submitte ${time} ago by ${username}`))
                    .append($("<div>").addClass("controls")
                        .append($("<ul>")))))
            .append($('<div>').addClass("clear"));

        let list = $(form.find("ul").slice(-1));

        if (creatorId === localStorage.getItem("userId")) {

            list.append($("<li>")
                .addClass("action")
                .append($("<a href='#' class='editLink'>edit</a>")
                    .on("click", () => preparePostForEdit(res))));
            list.append($("<li>")
                .addClass("action")
                .append($("<a href='#' class='deleteLink'>delete</a>")
                    .on("click", () => deletePost(res))))
        }
    }

    function preparePostForEdit(res) {
        showEditView();
        editForm.find(`input[name="url"]`).val(res.url);
        editForm.find(`input[name="title"]`).val(res.title);
        editForm.find(`input[name="image"]`).val(res.imageUrl);
        editForm.find(`textarea[name="comment"]`).val(res.description);
        editForm.attr("postId", res._id);
    }

    async function deletePost(res) {
        let id = res._id;

        try {
            let response = await requester.remove(baseUrl, "/posts/" + id)
            showInfo("Post deleted.")
           navigationBar()
        } catch (e) {
            handleError(e)
        }
    }

    async function deleteComment(res) {
        let form = $('#viewComments');
        let id = res._id;
        let end = `/comments/${id}`;
        let postId = localStorage.getItem("postId")
        let endReload = `/comments?query={"postId":"${postId}"}&sort={"_kmd.ect": -1}`;

        try {
            let response = await requester.remove(baseUrl, end)
            showInfo("Comment deleted.");

            let commentsForm = form.find('article');
            let responseReload = await requester.get(baseUrl, endReload)
            displayComments(responseReload, commentsForm, $('#viewComments'))
            showCommentsView();
        } catch (e) {
            handleError(e)
        }
    }

    function calcTime(dateIsoFormat) {
        let diff = new Date - (new Date(dateIsoFormat));
        diff = Math.floor(diff / 60000);
        if (diff < 1) return 'less than a minute';
        if (diff < 60) return diff + ' minute' + pluralize(diff);
        diff = Math.floor(diff / 60);
        if (diff < 24) return diff + ' hour' + pluralize(diff);
        diff = Math.floor(diff / 24);
        if (diff < 30) return diff + ' day' + pluralize(diff);
        diff = Math.floor(diff / 30);
        if (diff < 12) return diff + ' month' + pluralize(diff);
        diff = Math.floor(diff / 12);
        return diff + ' year' + pluralize(diff);
        function pluralize(value) {
            if (value !== 1) return 's';
            else return '';
        }
    }


    // USERS
    async function registerUser(e) {
        e.preventDefault();
        let form = $('#registerForm');
        let username = form.find(`input[name="username"]`).val();
        let password = form.find(`input[name="password"]`).val();
        let passwordCheck = form.find(`input[name="repeatPass"]`).val();

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
            form.trigger("reset");
            saveLocalStorageSession(response);
            $("#errorBox").hide();
            showInfo("User registration successful.");
            $("#registerForm").trigger("reset");
            navigationBar(handleError);
        } catch (e) {
            handleError(e)
        }
    }

    async function loginUser(e) {
        e.preventDefault();
        let form = $('#loginForm');
        let username = form.find(`input[name="username"]`).val();
        let password = form.find(`input[name="password"]`).val();

        if (!password || !username) {
            showError("The fields can not be empty");
            return;
        }

        let data = {username: username, password: password};

        try {
            let response = await requester.post(userUrl, data, "/login");
            form.trigger("reset");
            $("#errorBox").hide();
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
            $("#errorBox").hide();
            navigationBar();
            $("#registerForm").hide();
            $("#viewWelcome").find(".about").hide();
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