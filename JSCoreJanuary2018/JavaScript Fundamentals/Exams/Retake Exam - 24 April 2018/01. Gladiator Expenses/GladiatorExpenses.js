function repairExpenses(lostFights, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let expenses = 0;
    expenses += Math.floor(Number(lostFights) / 2) * Number(helmetPrice);
    expenses += Math.floor(Number(lostFights) / 3) * Number(swordPrice);
    expenses += Math.floor(Number(lostFights) / 6) * Number(shieldPrice);
    expenses += Math.floor((lostFights) / 12) * Number(armorPrice);
    console.log("Gladiator expenses: " + expenses + ".00 aureus");
}
repairExpenses();