function solve(objects, fights) {
    let dataMap = new Map();

    for (let obj of objects){
        let currentKingdom = obj.kingdom;
        let currentGeneral = obj.general;
        let currentArmy = obj.army;
        if (!dataMap.has(currentKingdom)){
            dataMap.set(currentKingdom, new Map());
        }
        let generalMap = dataMap.get(currentKingdom);
        if (!generalMap.has(currentGeneral)){
            generalMap.set(currentGeneral, {});
            generalMap.get(currentGeneral)['army'] = currentArmy;
            generalMap.get(currentGeneral)['loses'] = 0;
            generalMap.get(currentGeneral)['wins'] = 0;
        } else {
            generalMap.get(currentGeneral).army += currentArmy;
        }
    }

    for (let fight of fights){
        let attackingKingdom = fight[0];
        let attackingGeneral = fight[1];
        let defendingKingdom = fight[2];
        let defendingGeneral = fight[3];

        if (attackingKingdom !== defendingKingdom){
            if (dataMap.get(attackingKingdom).get(attackingGeneral).army > dataMap.get(defendingKingdom).get(defendingGeneral).army){
                dataMap.get(attackingKingdom).get(attackingGeneral).wins++;
                dataMap.get(defendingKingdom).get(defendingGeneral).loses++;
                dataMap.get(attackingKingdom).get(attackingGeneral).army = Math.floor(dataMap.get(attackingKingdom).get(attackingGeneral).army * 1.1);
                dataMap.get(defendingKingdom).get(defendingGeneral).army = Math.floor(dataMap.get(defendingKingdom).get(defendingGeneral).army * 0.9);
            } else if (dataMap.get(attackingKingdom).get(attackingGeneral).army < dataMap.get(defendingKingdom).get(defendingGeneral).army) {
                dataMap.get(attackingKingdom).get(attackingGeneral).loses++;
                dataMap.get(defendingKingdom).get(defendingGeneral).wins++;
                dataMap.get(defendingKingdom).get(defendingGeneral).army = Math.floor(dataMap.get(defendingKingdom).get(defendingGeneral).army * 1.1);
                dataMap.get(attackingKingdom).get(attackingGeneral).army = Math.floor(dataMap.get(attackingKingdom).get(attackingGeneral).army * 0.9);
            }
        }
    }


    let sortedMap = [...dataMap.entries()].sort(sortByGeneralWins).shift();
    console.log(`Winner: ${sortedMap[0]}`);
    let sortedGeneralsArmies = [...sortedMap[1].entries()].sort(sortGeneralByArmies)
    for (let general of sortedGeneralsArmies){
        console.log(`/\\general: ${general[0]}`);
        console.log(`---army: ${general[1].army}`);
        console.log(`---wins: ${general[1].wins}`);
        console.log(`---losses: ${general[1].loses}`);
    }

    function sortByGeneralWins(a, b) {
        let aEntry = [...a[1].values()];
        let aWinsCount = 0;
        for (let general of aEntry){
            aWinsCount += general.wins
        }
        let bEntry = [...b[1].values()];
        let bWinsCount = 0;
        for (let general of bEntry){
            bWinsCount += general.wins
        }
        let firstCriteria = bWinsCount - aWinsCount;
        if (firstCriteria !== 0){
            return firstCriteria
        } else {
            let aEntry = [...a[1].values()];
            let aLossesCount = 0;
            for (let general of aEntry){
                aLossesCount += general.loses
            }
            let bEntry = [...b[1].values()];
            let bLossesCount = 0;
            for (let general of bEntry){
                bLossesCount += general.loses
            }
            let secondCriteria = aLossesCount - bLossesCount;
            if (secondCriteria !== 0) {
                return secondCriteria;
            } else {
                let aName = a[0];
                let bName = b[0];

                return aName.localeCompare(bName);
            }
        }
    }

    function sortGeneralByArmies(a, b) {
        let aArmy = a[1].army;
        let bArmy = b[1].army;

        return bArmy - aArmy;
    }
}

solve(
    [ { kingdom: "Maiden Way", general: "Merek", army: 5000 },
        { kingdom: "Stonegate", general: "Ulric", army: 4900 },
        { kingdom: "Stonegate", general: "Doran", army: 70000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 0 },
        { kingdom: "YorkenShire", general: "Quinn", army: 2000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Doran"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"] ]
);