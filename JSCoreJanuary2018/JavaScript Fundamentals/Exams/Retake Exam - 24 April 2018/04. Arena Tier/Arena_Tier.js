function gladiator(arr) {
    let gladiators = new Map();
    for (let string of arr) {
        if (string === 'Ave Cesar') {
            break;
        } else {
            let data = string.split(' ');
            let name = data[0];
            switch (data[1]) {
                case '->' :
                    let technique = data[2];
                    let skill = Number(data[4]);
                    if (!gladiators.has(name)) {
                        gladiators.set(name, new Map());
                    }
                    let gladiator = gladiators.get(name);
                    if (!gladiator.has(technique)) {
                        gladiator.set(technique, skill);
                    }
                    if (gladiators.get(name).get(technique) < skill) {
                        gladiators.get(name).set(technique, skill);
                    }
                    break;
                case 'vs' :
                    let nameOther = data[2];
                    let firstGl = [];
                    let secondGl = [];
                    if (gladiators.has(name) && gladiators.has(nameOther)) {
                        for (let skill of gladiators.get(name)) {
                            firstGl.push(skill[0]);
                        }
                        for (let skill of gladiators.get(nameOther)) {
                            secondGl.push(skill[0])
                        }
                        let isAlive = true;
                        for (let technique1 of firstGl) {
                            for (let technique2 of secondGl) {
                                if (technique1 === technique2 && isAlive) {
                                    if (gladiators.get(name).get(technique1) > gladiators.get(nameOther).get(technique1)) {
                                        gladiators.delete(nameOther);
                                        isAlive = false;
                                    } else if (gladiators.get(name).get(technique1) < gladiators.get(nameOther).get(technique1)) {
                                        gladiators.delete(name);
                                        isAlive = false;
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }

    let sortedGladiators = [...gladiators.entries()].sort(gladiatorSkillsSumSort);
    for (let [gladiator, skills] of sortedGladiators){
        let sum = [...skills.values()].reduce((x, y) => x + y);
        console.log(`${gladiator}: ${sum} skill`);
        let sortedSkills = [...skills].sort(gladiatorSkillSort);
        for (let skill of sortedSkills){
            console.log(`- ${skill[0]} <!> ${skill[1]}`);
        }
    }

    function gladiatorSkillsSumSort(a, b) {
        let aSum = [...a[1].values()].reduce((x, y) => x + y);
        let bSum = [...b[1].values()].reduce((x, y) => x + y);
        let firstCriteria = bSum - aSum;
        if (firstCriteria !== 0){
            return firstCriteria;
        } else {
            let aName = a[0];
            let bName = b[0];

            return aName.localeCompare(bName);
        }
    }

    function gladiatorSkillSort(a, b) {
        let aSkill = a[1];
        let bSkill = b[1];
        let firstCriteria = bSkill - aSkill;
        if (firstCriteria !== 0){
            return firstCriteria;
        } else {
            let aName = a[0];
            let bName = b[0];
            return aName.localeCompare(bName);
        }
    }

}

gladiator(['Pesho -> Duck -> 400', 'Julius -> Shield -> 150', 'Gladius -> Heal -> 200', 'Gladius -> Support -> 250', 'Gladius -> Shield -> 250'
    , 'Pesho vs Gladius', 'Gladius vs Julius', 'Gladius vs Gosho', 'Ave Cesar']);