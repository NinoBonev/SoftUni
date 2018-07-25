function solve(name, age, weight, height) {
    let person = {
        name: name,
        personalInfo: {
            age: Number(age),
            weight: Number(weight),
            height: Number(height)
        },
        BMI: weight / ((height / 100) * (height / 100)),
        status: (function (index) {
            if (index < 18.8){
                return 'underweight'
            }
            if (index < 25 && index >= 18.5){
                return 'normal';
            }
            if (index >= 25 && index < 30){
                return 'overweight'
            }
            if (index >= 30 ){
                return 'obese'
            }
        })(BMI)
    };

    console.log(person);
}

solve('Peter', 29, 75, 182)