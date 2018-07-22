function solve(arr) {
    let destinations = new Map();
    for (let string of arr) {
        let destinationData = string.split(" > ");
        let country = destinationData[0];
        let town = capitalizeFirstLetter(destinationData[1]);
        let cost = Number(destinationData[2]);

        if (!destinations.has(country)){
            destinations.set(country, new Map());
        }
        if (!destinations.get(country).has(town)){
            destinations.get(country).set(town, Number.MAX_VALUE)
        }
        if (destinations.get(country).get(town) > cost){
            destinations.get(country).set(town, cost)
        }
    }

    let sorted = [...destinations].sort();
    let newSort = [...sorted];

    console.log(newSort);

    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }

    function townSort(a, b){
        let a1 = [...a][1];
        let b1 = [...b][1];
        let firstCriteria = b1 - a1;
        return firstCriteria;
    }
}

solve(
    ["Bulgaria > Sofia > 500",
        "Bulgaria > Sopot > 800",
        "France > Paris > 2000",
        "Albania > Tirana > 1000",
        "Bulgaria > sofia > 200" ]
);