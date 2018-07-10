function solve(keyword, string) {
    let regexCoordinates = /(north|east)(?:.|\n)*?([0-9]{2})(?:.|\n)*?,(?:.|\n)*?([0-9]{6})/ig;
    let match = regexCoordinates.exec(string);

    let latOutput = '';
    let longOutput = '';
    while (match) {
        if (match[1].toLowerCase() === 'north') {
            latOutput = `${match[2]}.${match[3]} N`;
        } else {
            longOutput = `${match[2]}.${match[3]} E`;
        }
        match = regexCoordinates.exec(string);
    }

    let regexMessage = new RegExp(`${keyword}(.*)${keyword}`, 'g');
    let matchMessage = regexMessage.exec(string);

    console.log(latOutput);
    console.log(longOutput);
    console.log('Message: ' + matchMessage[1]);
}

solve('4ds', 'eaSt 19,432567noRt north east 53,123456north 43,3213454dsNot all those who wander are lost.4dsnorth 47,874532'
);