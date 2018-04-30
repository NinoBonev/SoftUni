function MultiplyOrDivide(arr) {

    let num1 = Number(arr[0]);
    let num2 = Number(arr[1]);

    if (num2 >= num1) {
        let result = num1 * num2;
        console.log(result);
    }
    else {
        let result = num1 / num2;
        console.log(result);
    }

}