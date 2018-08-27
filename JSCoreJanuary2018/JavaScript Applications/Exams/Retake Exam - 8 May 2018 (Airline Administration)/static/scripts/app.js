$(() => {
    const baseUrl = "https://baas.kinvey.com/appdata/";
    const userUrl = "https://baas.kinvey.com/user/";
    const appKey = "kid_r1f2WUYLm";
    const appSecret = "ce9d61c385da40429b3ff294388188c7";
    const authorization = {"Authorization": "Basic " + btoa(appKey + ":" + appSecret)};

//VARIABLES
    let authToken;
    let profile = $('.right-container');
    let navBar = $('.left-container');
    let login = $('#viewLogin');
    let register = $('#viewRegister');
    let catalog = $('#viewCatalog');
    let addFlight = $("#viewAddFlight");
    let editFlight = $('#viewEditFlight');
    let myFlights = $('#viewMyFlights');
    let flightDetails = $('#viewFlightDetails');

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
    // navBar.find('.active').on('click', showMainView);
    // navBar.find('a:eq(1)').on('click', loadAllListings);
    // navBar.find('a:eq(2)').on('click', loadMyListings);
    // navBar.find('a:eq(3)').on('click', showCreateListingView);
    // welcomeButtons.find('a:first-child').on('click', showLoginView);
    // welcomeButtons.find('a:eq(1)').on('click', showRegisterView);
    register.on('submit', registerUser);
    login.on('submit', loginUser);
    profile.find('a[class="log-out"]').on('click', logoutUser);
    // createListing.on('submit', createNewListing);
    // editListing.on('submit', editCar);

    //VIEWS
    function showView(viewName) {
        $("section").hide();
        $('#' + viewName).show();
    }

    function showCatalogView() {
        showView("viewCatalog")
    }

    function showAddFlightView() {
        showView("viewAddFlight");
    }

    function showEditFlightView() {
        showView("viewEditFlight");
    }

    function showMyFlightsView() {
        showView("viewMyFlights");
    }

    function showFlightDetailsView() {
        showView("viewFlightDetails");
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
            profile.hide();
            navBar.hide()
            $('section').hide();
            login.show();
            register.show()
        } else {
            profile.show();
            navBar.show()
            $('section').hide();
            catalog.show();
        }
    }

    //CRUD


    // USERS
    async function registerUser(e) {
        e.preventDefault();

        let username = register.find(`input[name="username"]`).val();
        let password = register.find(`input[name="pass"]`).val();
        let passwordCheck = register.find(`input[name="checkPass"]`).val();

        if (!password || !passwordCheck || !username) {
            showError("The fields can not be empty");
            return;
        }

        if (username.length < 5) {
            showError("Invalid username! It must be at least 5 characters long.");
            return
        }

        if (password !== passwordCheck) {
            showError("Your password and confirm password do not match");
            return;
        }
        let data = {username: username, password: password};

        try {
            let response = await requester.post(userUrl, data, "");
            $('#formRegister').trigger("reset");
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
        let password = login.find(`input[name="pass"]`).val();

        if (!password || !username) {
            showError("The fields can not be empty");
            return;
        }

        let data = {username: username, password: password};

        try {
            let response = await requester.post(userUrl, data, "/login");
            $('#formLogin').trigger("reset");
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
            navigationBar(handleError);
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