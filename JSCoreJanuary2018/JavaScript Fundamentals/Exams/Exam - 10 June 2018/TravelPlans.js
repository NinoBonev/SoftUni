function solve(arr) {
    const specialized = ["Programming", "Hardware maintenance", "Cooking", "Translating", "Designing"];
    const average = ["Driving", "Managing", "Fishing", "Gardening"];
    const clumsy = ["Singing", "Accounting", "Teaching", "Exam-Making", "Acting", "Writing", "Lecturing", "Modeling", "Nursing"];

    let specializedCount = 0;
    let clumsyCount = 0;
    let moneySum = 0;

    for (const string of arr) {
        let profession = string.split(' : ')[0];
        let gold = Number(string.split(' : ')[1]);
        if (specialized.includes(profession)){
            if (gold >= 200) {
                specializedCount++;
                if (specializedCount % 2 === 0) {
                    moneySum += 200;
                }
                moneySum += 0.8 * gold;
            }
        } else if (average.includes(profession)){
            moneySum += gold;
        } else if (clumsy.includes(profession)){
            clumsyCount++;
            if (clumsyCount % 2 === 0){
                moneySum += 0.95 * gold;
            } else if (clumsyCount % 3 === 0){
                moneySum += 0.9 * gold;
            } else {
                moneySum += gold;
            }
        }
    }

    console.log(`Final sum: ${moneySum.toFixed(2)}`);
    if (moneySum >= 1000){
        console.log(`Mariyka earned ${(moneySum - 1000).toFixed(2)} gold more.`);
    } else {
        console.log(`Mariyka need to earn ${(1000 - moneySum).toFixed(2)} gold more to continue in the next task.`);
    }
}

solve(["Programming : 500",
    "Driving : 243.55",
    "Acting : 200",
    "Singing : 100",
    "Cooking : 199",
    "Hardware maintenance : 800",
    "Gardening : 700",
    "Programming : 500"]);

solve(["Programming : 500", "Driving : 243", "Singing : 100", "Cooking : 199"])