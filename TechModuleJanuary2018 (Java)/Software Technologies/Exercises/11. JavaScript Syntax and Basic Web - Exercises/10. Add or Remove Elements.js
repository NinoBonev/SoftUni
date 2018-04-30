function AddOrRemoveElemnts(arr) {

    let array = new Array();
    for (let line of arr) {
        let tokens = line.split(" ");
        let command = tokens[0];
        let number = Number(tokens[1]);

        if (command == "add")
        {
            array.push(number);
        }
        else if (command == "remove")
        {
            array.splice(number,  1);
        }
    }

    for (let num of array) {
        console.log(num);
    }
}