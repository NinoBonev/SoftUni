function solve(base, increment) {
    let stone = 0;
    let marble = 0;
    let lapisLazuli = 0;
    let gold = 0;
  //  let length = base % increment * 2 === 0 ? base % increment * 2 : base % increment * 2 + 1;
    let steps = base % 2 === 0 ? base / 2 : Math.floor(base / 2) + 1;
    let length = Math.floor(steps * increment);

    for (let i = 1; i <= steps; i++) {
        if (i === steps){
            gold += (base * base) * increment
        } else {
            if (i % 5 === 0){
                lapisLazuli += ((2 * base) + (2 * (base - 2))) * increment;
                stone += ((base - 2) * (base - 2)) * increment;
                base -= 2;
            } else {
                marble += ((2 * base) + (2 * (base - 2))) * increment;
                stone += ((base - 2) * (base - 2)) * increment;
                base -= 2;
            }
        }
    }

    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapisLazuli)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(length)}`);

}

solve(12, 3)