function solve(arr) {
    let meals = arr.shift();
    let eatenCount = 0;
    for (let string of arr){
        if (string === 'End'){
            break;
        } else {
            let command = string.split(' ')[0];
            switch (command){
                case 'Serve' :
                    let portionToServe = meals.pop();
                    console.log(portionToServe + ' served!');
                    break;
                case 'Eat' :
                    let portionToEat = meals.shift();
                    console.log(portionToEat + ' eaten');
                    eatenCount++;
                    break;
                case 'Add' :
                    let addPortion = string.split(' ')[1];
                    meals.unshift(addPortion);
                    break;
                case 'Consume' :
                    let startIndex = Number(string.split(' ')[1]);
                    let endIndex = Number(string.split(' ')[2]);
                    meals.splice(startIndex, endIndex - startIndex + 1);
                    eatenCount += endIndex - startIndex + 1;
                    console.log('Burp!');
                    break;
                case 'Shift' :
                    let firstIndex = Number(string.split(' ')[1]);
                    let secondIndex = Number(string.split(' ')[2]);
                    let firstString = meals[firstIndex];
                    let secondString = meals[secondIndex];
                    meals[firstIndex] = secondString;
                    meals[secondIndex] = firstString;
                    break;

            }
        }
    }

    if (meals.length > 0){
        let result = meals.join(', ');
        console.log(`Meals left: ${result}`);
        console.log(`Meals eaten : ${eatenCount}`)
    } else {
        console.log('The food is gone');
        console.log(`Meals eaten : ${eatenCount}`)
    }
}
let arr = [['chicken', 'steak', 'eggs'],
    'Serve',
        'Eat',
        'End',
        'Consume 0 1'
];

solve(arr);