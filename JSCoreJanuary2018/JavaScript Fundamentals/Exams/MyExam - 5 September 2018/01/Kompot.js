function solve(arr) {
    let fruits = {
        peach: 0,
        plum: 0,
        cherry: 0,
        other: 0
    };

    for (let fruit of arr) {
        let name = fruit.split(' ');
        let weight = Number(name.pop());

        if (name[0] === 'peach') {
            fruits.peach += weight;
        } else if (name[0] === 'plum') {
            fruits.plum += weight;
        } else if (name[0] === 'cherry') {
            fruits.cherry += weight;
        } else {
            fruits.other += weight;
        }
    }

    console.log(`Cherry kompots: ${Math.floor((fruits.cherry / 0.009) / 25)}`);
    console.log(`Peach kompots: ${Math.floor((fruits.peach / 0.14) / 2.5)}`);
    console.log(`Plum kompots: ${Math.floor((fruits.plum / 0.02) / 10)}`);
    console.log(`Rakiya liters: ${(fruits.other / 5).toFixed(2)}`);
}

solve(['cherry 1.2',
    'peach 2.2',
    'plum 5.2',
    'peach 0.1',
    'cherry 0.2',
    'cherry 5.0',
    'plum 10',
    'cherry 20.0',
    'papaya 20']);

solve(['apple 6',
    'peach 25.158',
    'strawberry 0.200',
    'peach 0.1',
    'banana 1.55',
    'cherry 20.5',
    'banana 16.8',
    'grapes 205.65'
    , 'watermelon 20.54'
]);