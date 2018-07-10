function solve(arr) {
    let money = 0;
    let numCount = 0;
    let firstDayFound = false;
    let firstDay = 0;
    for (let num of arr) {
        numCount++;
        if (numCount % 3 === 0){
            money += 0.7 * Number(num) * 67.51;
            if (!firstDayFound && money >= 11949.16) {
                firstDay = numCount;
                firstDayFound = true;
            }
        } else {
            money += Number(num) * 67.51;
            if (!firstDayFound && money >= 11949.16) {
                firstDay = numCount;
                firstDayFound = true;
            }
        }
    }

    let bitCoinsBought = Math.floor(money / 11949.16);
    let moneyLeft = money - bitCoinsBought * 11949.16;

    console.log(`Bought bitcoins: ${bitCoinsBought}`);
    if (firstDay > 0) {
        console.log(`Day of the first purchased bitcoin: ${firstDay}`);
    }
    console.log(`Left money: ${moneyLeft.toFixed(2)} lv.`);
}

solve(
    [
        '3124.15', '504.212', '2511.124'
    ]
);