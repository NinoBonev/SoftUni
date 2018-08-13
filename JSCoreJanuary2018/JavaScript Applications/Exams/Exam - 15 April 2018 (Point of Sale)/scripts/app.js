$(() => {
    const baseUrl = "https://baas.kinvey.com/appdata/";
    const userUrl = "https://baas.kinvey.com/user/";
    const appKey = "kid_r1UPrA9rm";
    const appSecret = "ca7134f6087241b7a434c1c9a96383ca";
    const authorization = {"Authorization": "Basic " + btoa(appKey + ":" + appSecret)};

//VARIABLES
    let authToken;
    let profile = $("#profile");
    let navBar = $('#nav')
    let inputId = $('input[name="receiptId"]');
    let inputCount = $('input[name="productCount"]');
    let inputTotal = $('input[name="total"]');
    let allReceiptView = $('#all-receipt-view');
    let receiptDetailsView = $('#receipt-details-view');


    navigationBar();

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
//EVENTS
    $('#loginBtn').on('click', loginUser);
    $('#registerBtn').on('click', registerUser);
    $('.logout').on('click', logoutUser);
    $('#addItemBtn').on('click', addItem);
    $('#checkoutBtn').on('click', checkOut);

    navBar.find("li:eq(1)").on('click', overview)
    navBar.find("li:first-child").on("click", editor);

//Set the default and other visibility of the Navigation Bar
    function navigationBar() {
        authToken = localStorage.getItem("authToken");

        if (authToken === null){
            $('#container').show();
            $('section').hide();
            profile.hide();
            $('#welcome-section').show();
        } else {
            $('#container').show();
            $('section').hide();
            profile.show();
            $("#cashier").find("a").text(localStorage.getItem("username"))
        }
    }

//CRUD
    async function editor() {
        let id = localStorage.getItem("userId");
        let end = `/receipts/?query={"_acl.creator":"${id}","active":true}`;

        try {
            let response = await requester.get(baseUrl, end);
            navigationBar();
            if (response.length === 0){
                let data = {
                    active: true,
                    productCount: 0,
                    total: 0
                };
                response = await requester.post(baseUrl, data, "/receipts")
                localStorage.setItem("receiptId", response._id)
            } else {
                localStorage.setItem("receiptId", response[0]._id)
            }
            renderItems();
        } catch (e) {
            handleError(e)
        }
        
    }
    
    async function addItem(e) {
        e.preventDefault();

        let receiptId = localStorage.getItem("receiptId");

        let product = $('input[name="type"]').val();
        let qty = +$('input[name="qty"]').val();
        let price = +$('input[name="price"]').val();

        if (!product){
            showError("The input fields can not be empty");
            return;
        }
        if (typeof qty !== 'number' || !qty){
            showError("Quantity must be a valid number");
            return;
        } 
        if (typeof price !== 'number' || !price){
            showError("Price must be a valid number");
        }

        let data = {
            type: product,
            qty: qty,
            price: price,
            receiptId: receiptId
        };

        try {
          let response = await requester.post(baseUrl, data, "/entries");
            $("#create-entry-form").trigger("reset");
            showInfo("Entry added");
            renderItems();
        } catch (e) {
            handleError(e)
        }

    }

    async function deleteElement(id) {
        try {
            let response = await requester.remove(baseUrl, "/entries/" + id);
            showInfo("Entry removed");
            renderItems();
        } catch (e) {
            handleError(e);
        }
    }

    async function checkOut() {
        let receiptId = inputId[0].id;
        let end = `/receipts/${receiptId}`;

        let total = Number(inputTotal[0].id);
        let productCount = Number(inputCount[0].id);

        if (productCount < 1){
            showError("You should have at least one item in your receipt!");
            return;
        }

        let data = {
            active: false,
            productCount: productCount,	// Sum of all products
            total: total,		// Total cost of all products
            // Other receipt properties
        };

        try {
          await requester.put(baseUrl, data, end);
          showInfo("Receipt checked out");
          editor();
        } catch (e) {
            handleError(e)
        }
    }

    async function overview() {
        let userId = localStorage.getItem("userId");
        let end = `/receipts/?query={"_acl.creator":"${userId}","active":false}`;
        let table = allReceiptView.find(".table");
        let rows = allReceiptView.find(".table > div").slice(1);
        rows.remove();

        try {
            let response = await requester.get(baseUrl, end);
            navigationBar()

            let total = 0;
            for (let obj of response) {
                let date = obj._kmd.ect.split("T");
                let hours = date[1].split(".");

                table.append($('<div>').addClass("row")
                    .append($(`<div>${date[0] + " " + (hours[0]).substring(0, 5)}</div>`).addClass("col wide"))
                    .append($(`<div>${Number(obj.productCount)}</div>`).addClass("col wide"))
                    .append($(`<div>${(Number(obj.total)).toFixed(2)}</div>`).addClass("col"))
                    .append($('<div>').addClass("col")
                        .append($(`<a href="#">Details</a>`)
                            .on('click', () => details(obj._id)))));
                total += Number(obj.total);
            }
            let div = ($('<div>').addClass("table-foot")
                .append($("<form id='create-receipt-form2'>")
                    .append($('<div>').addClass("col wide"))
                    .append($('<div>Total:</div>').addClass("col wide right"))
                    .append($(`<div>${total.toFixed(2)}</div>`).addClass("col"))
                    .append($('<div>').addClass("col"))));
            table.append(div)
            allReceiptView.show();
        } catch (e) {
            handleError(e)
        }
    }

    async function details(id) {
        let end = `/entries/?query={"receiptId":"${id}"}`;
        let table = receiptDetailsView.find(".table");
        let rows = receiptDetailsView.find(".table > div").slice(1);
        rows.remove();

        try {
            let response = await requester.get(baseUrl, end);

            for (let obj of response) {
                table.append($('<div>').addClass("row")
                    .append($(`<div>${obj.type}</div>`).addClass("col wide"))
                    .append($(`<div>${obj.qty}</div>`).addClass("col wide"))
                    .append($(`<div>${obj.price.toFixed(2)}</div>`).addClass("col wide"))
                    .append($(`<div>${(obj.price * obj.qty).toFixed(2)}</div>`).addClass("col")));
            }
            navigationBar();
            receiptDetailsView.show()
        } catch (e) {
            handleError(e)
        }
    }

    async function renderItems() {
        let receiptId = localStorage.getItem("receiptId");
        let end = `/entries/?query={"receiptId":"${receiptId}"}`;

        try {
            let response = await requester.get(baseUrl, end)
            $('#create-receipt-view').show();
            let div = $('#active-entries');
            div.empty();
            let total = 0;
            let quantity = 0;
            for (let obj of response) {
                div.append($('<div>').addClass("row")
                    .append($(`<div>${obj.type}</div>`).addClass("col wide"))
                    .append($(`<div>${obj.qty}</div>`).addClass("col wide"))
                    .append($(`<div>${obj.price.toFixed(2)}</div>`).addClass("col wide"))
                    .append($(`<div>${(obj.price * obj.qty).toFixed(2)}</div>`).addClass("col"))
                    .append($('<div></div>').addClass("col right")
                        .append($('<a href="#">&#10006;</a>')
                            .on('click', () => deleteElement(obj._id)))));
                total += obj.qty * obj.price;
                quantity += obj.qty;
            }
            $("#create-receipt-form1").find("div:eq(3)").text(total.toFixed(2));

            inputId.attr("id", receiptId);
            inputCount.attr("id", quantity);
            inputTotal.attr("id", total)
        }catch (e) {
            handleError(e)
        }
    }


// USERS
    async function registerUser(e) {
        e.preventDefault();
        let form = $('#register-form');
        let username = $('#username-register').val();
        let password = $('#password-register').val();
        let passwordCheck = $('#password-register-check').val();

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
            form.trigger("reset");
            saveLocalStorageSession(response);
            showInfo("User registration successful.");
            navigationBar(handleError);
        } catch (e) {
            handleError(e)
        }
    }

    async function loginUser(e) {
        e.preventDefault();
        let form = $('#login-form');
        let username = $('#username-login').val();
        let password = $('#password-login').val();

        if (!password || !username) {
            showError("The fields can not be empty");
            return;
        }

        if (username.length < 5) {
            showError("Invalid username! It must be at least 5 characters long.");
            return
        }

        let data = {username: username, password: password};

        try {
            let response = await requester.post(userUrl, data, "/login");
            form.trigger("reset");
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
            $(".welcome-text").hide();
            $(".welcome-rigister-form").hide();
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