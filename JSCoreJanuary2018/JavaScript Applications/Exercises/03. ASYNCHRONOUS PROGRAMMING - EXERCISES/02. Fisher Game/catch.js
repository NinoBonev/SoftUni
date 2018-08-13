function attachEvents() {
    //CONSTS
    const baseUrl = "https://baas.kinvey.com/appdata/kid_rywlBg9HQ";
    const user = "nino";
    const pass = "123";
    const authorization = {"Authorization": "Basic " + btoa(user + ":" + pass)};

    //VARIABLES
    let FORM = $("#addForm")
    let NEW_ANGLER = $('#aside .angler') ;
    let NEW_WEIGHT = $('#aside .weight');
    let NEW_SPECIES = $('#aside .species');
    let NEW_LOCATION = $('#aside .location');
    let NEW_BAIT = $('#aside .bait');
    let NEW_CAPTURE_TIME = $('#aside .captureTime');
    let CATCHES = $('#catches');
    
    $('.load').on('click', loadCatches);
    $('.add').on('click', createCatch);
    $('.delete').on('click', deleteCatch);

    let requester = (function () {
        function makeRequest(method, url, end) {
            return {
                method: method,
                url: url + '/biggestCatches' + end,
                headers: authorization,
                contentType: "application/json",
            };
        }

        function get(url) {
            return $.ajax(makeRequest("GET", url, ''));
        }

        function post(url, data) {
            let request = makeRequest("POST", url, '');
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

    function loadCatches() {
        requester.get(baseUrl)
            .then(showCatches)
            .catch(handleError)
    }

    function showCatches(data) {
        CATCHES.empty()
        for (let catchInfo of data) {
            let form = createForm(catchInfo);
            CATCHES.append(form)
        }
    }

    function jsonInput(selector) {
        let angler = selector.find(".angler");
        let weight = selector.find(".weight");
        let species = selector.find(".species");
        let location = selector.find(".location");
        let bait = selector.find(".bait");
        let captureTime = selector.find(".captureTime");

        return {
            angler: angler.val(),
            weight: Number(weight.val()),
            species: species.val(),
            location: location.val(),
            bait: bait.val(),
            captureTime: Number(captureTime.val())
        };
    }

    function createForm(data) {
        let div = $(`<div class="catch" data-id="${data._id}">`);
        div.append($('<label>Angler</label>'))
            .append($(`<input type="text" class="angler" value="${data.angler}">`))
            .append($('<label>Weight</label>'))
            .append($(`<input type="number" class="weight" value="${Number(data.weight)}">`))
            .append($('<label>Species</label>'))
            .append($(`<input type="text" class="species" value="${data.species}">`))
            .append($('<label>Location</label>'))
            .append($(`<input type="text" class="location" value="${data.location}">`))
            .append($('<label>Bait</label>'))
            .append($(`<input type="text" class="bait" value="${data.bait}">`))
            .append($('<label>Capture Time</label>'))
            .append($(`<input type="number" class="captureTime" value="${Number(data.captureTime)}">`))
            .append($('<button>Update</button>').addClass("update").on("click", updateCatch))
            .append($('<button>Delete</button>').addClass("delete").on("click", deleteCatch))
        return div;
    }

    function updateCatch() {
        let element = $(this).parent();
        let body = jsonInput(element)
        let id = element.attr('data-id')
        let end = '/' + id;

        requester.put(baseUrl, body, end)
            .then(loadCatches)
            .catch(handleError)
    }

    function createCatch() {
        let body = jsonInput(FORM);
        $('#addForm').trigger('reset')
        requester.post(baseUrl, body)
            .then(loadCatches)
            .catch(handleError);


    }

    function deleteCatch() {
        let element = $(this).parent();
        let id = element.attr('data-id')
        let end = '/' + id;
        requester.remove(baseUrl, end)
            .then(loadCatches)
            .catch(handleError)
    }

    function handleError(err) {
        console.log(err);
    }
}