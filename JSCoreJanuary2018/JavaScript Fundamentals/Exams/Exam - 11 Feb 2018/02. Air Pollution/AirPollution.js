function solve(matrix, forces) {
    let mapOfSofiaMatrix = [];

    for (let i = 0; i < 5; i++) {
        mapOfSofiaMatrix[i] = [];
        let rowNums = matrix[i].split(' ');
        for (let j = 0; j < 5; j++) {
            mapOfSofiaMatrix[i][j] = Number(rowNums[j]);
        }
    }
    for (let string of forces){
        let command = string.split(' ')[0];
        let index = Number(string.split(' ')[1]);
        switch (command){
            case 'breeze' :
                for (let i = 0; i < 5; i++) {
                    mapOfSofiaMatrix[index][i] = mapOfSofiaMatrix[index][i] - 15 >= 0 ? mapOfSofiaMatrix[index][i] - 15 : 0;
                }
                break;
            case 'gale' :
                for (let i = 0; i < 5; i++) {
                    mapOfSofiaMatrix[i][index] = mapOfSofiaMatrix[i][index] - 20 >= 0 ? mapOfSofiaMatrix[i][index] - 20 : 0;
                }
                break;
            case 'smog' :
                for (let i = 0; i < 5; i++) {
                    for (let j = 0; j < 5; j++) {
                        mapOfSofiaMatrix[i][j] += index;
                    }
                }
                break;
        }
    }

    let pollutedAreas = [];

    for (let i = 0; i < 5; i++) {
        for (let j = 0; j < 5; j++) {
            if (mapOfSofiaMatrix[i][j] >= 50){
                pollutedAreas.push(`[${i}-${j}]`)
            }
        }
    }

    if (pollutedAreas.length > 0){
        let joinedAreas = pollutedAreas.join(', ');
        console.log(`Polluted areas: ${joinedAreas}`);
    } else {
        console.log('No polluted areas');
    }
}

solve(
    [
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]
);