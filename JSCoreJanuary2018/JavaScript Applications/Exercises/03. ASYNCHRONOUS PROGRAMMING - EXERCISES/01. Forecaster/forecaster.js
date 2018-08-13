function attachEvents() {
    const locationURL = 'https://judgetests.firebaseio.com/locations.json'
    const forecastURL = 'https://judgetests.firebaseio.com/forecast/'
    const searchedLocation = $("#location");
    const todayForecast = $("#current");
    const upcomingForecast = $("#upcoming");
    let forecast = $("#forecast");
    let code;

    $('#submit').on('click', getForecast)

    function getForecast() {
        requestGET(locationURL)
            .then(getLocationCode)
            .catch(handleError)
    }
    
    function requestGET(url) {
        return $.ajax({
            method: "GET",
            url: url
        })
    }

    function getLocationCode(result) {
        for (const option of result) {
            if (option.name === searchedLocation.val()){
                code = option.code;
                let todayForecast = requestGET(forecastURL + "today/" + code + ".json")
                let nextThreeDays =  requestGET(forecastURL + "upcoming/" + code + ".json");

                Promise.all([todayForecast, nextThreeDays])
                    .then(showWeather)
                    .catch(handleError)
            }
        }
        if (!code){
            handleError();
        }
    }

    function showWeather([todayWeather, upcomingWeather]) {
        getForecast();
        getUpcomingForecast();

        function getForecast() {
            forecast.show();
            todayForecast.empty();
            let div = $("<div class='label'>Current Conditions</div>");
            let symbol = $(`<span>${conditionSymbol(todayWeather.forecast.condition)}</span>`).addClass("condition symbol");
            let span = $("<span class='condition'>");
            span.append($("<span class='forecast-data'>").text(`${todayWeather.name}`));

            generateSpans(span, todayWeather.forecast.low, todayWeather.forecast.high, todayWeather.forecast.condition);
            todayForecast.append(div).append(symbol).append(span);
        }

        function getUpcomingForecast() {
            upcomingForecast.empty();
            upcomingForecast.append($("<div>").addClass("label").text("Three-day forecast"));

            for (let day of upcomingWeather.forecast) {
                let span = $("<span class='upcoming'>");
                span.append($("<span>").addClass("symbol").html(`${conditionSymbol(day.condition)}`));
                generateSpans(span, day.low, day.high, day.condition);
                upcomingForecast.append(span)
            }
        }
    }

    function generateSpans(span, low, high, condition) {
        span.append($("<span>").addClass("forecast-data").html(`${low}&#176/${high}&#176`))
            .append($("<span class='forecast-data'>").text(`${condition}`));
    }

    function conditionSymbol(condition) {
        switch (condition) {
            case "Rain":return "&#x2614";
            case "Sunny":return "&#x2600";
            case "Partly sunny":return "&#x26C5";
            case "Overcast":return "&#x2601";
        }
    }

    function handleError() {
        forecast.text("Error");
        forecast.css("display", "block");
    }
}