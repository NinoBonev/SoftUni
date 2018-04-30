function ProductOfThreeNumbers([arr]) {

    arr = arr.split(' ').map(z => Number(z));
    let negativeNums = arr.filter(x => x < 0);
    let zeroNum = arr.filter(x => x == 0);

    let numbersSize = negativeNums.length % 2;

    if (zeroNum.length > 0)
    {
        console.log("Positive")
    }
    else if (numbersSize == 0)
    {
        console.log("Positive")
    }
    else
    {
        console.log("Negative")
    }
}

ProductOfThreeNumbers(["-2 -3 -1"]);