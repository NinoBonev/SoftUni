function WorkingWithKeyValuePairs(arr) {

    let result = {};
    for (let line of arr) {
        let tokens = line.split(' ');

        if (tokens.length > 1) {
            let key = tokens[0];
            let value = tokens[1];

            result[key] = value;
        }
        else {
            let print = tokens[0];
            if (result.hasOwnProperty(print)) {
                console.log(result[print])
            }
            else {
                console.log("None")
            }
        }
    }
}