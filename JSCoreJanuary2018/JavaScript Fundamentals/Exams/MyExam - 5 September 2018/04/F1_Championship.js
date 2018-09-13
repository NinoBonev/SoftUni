function solve(arr) {
    let table = new Map();
    let teamsByPoints = new Map();

    for (let data of arr) {
        let teamName = data.split(' -> ')[0];
        let pilotName = data.split(' -> ')[1];
        let pilotPoints = Number(data.split(' -> ')[2]);

        if (!table.has(teamName)){
            table.set(teamName, new Map());
            teamsByPoints.set(teamName, 0)
        }
        let pilots = table.get(teamName);
        if (!pilots.has(pilotName)){
            pilots.set(pilotName, 0);
        }

        let currentPoints = pilots.get(pilotName);
        let currentTeamPoints = teamsByPoints.get(teamName);
        pilots.set(pilotName, currentPoints + pilotPoints);
        teamsByPoints.set(teamName, currentTeamPoints + pilotPoints);

    }

    let sortedTeams = [...teamsByPoints.entries()].sort(sortTeams);

    let first = sortedTeams.shift();
    let second = sortedTeams.shift();
    let third = sortedTeams.shift();

    let finalPrint = [];
    finalPrint.push(first);
    finalPrint.push(second);
    finalPrint.push(third);

    for (let team of finalPrint) {
        console.log(`${team[0]}: ${team[1]}`);
        let sortedPilots = [...table.get(team[0]).entries()].sort(sortPilots);
        for (let pilot of sortedPilots) {
            console.log(`-- ${pilot[0]} -> ${pilot[1]}`);
        }
    }

    function sortTeams(a, b){
        let a1 = a[1];
        let b1 = b[1];
        return b1 - a1;
    }

    function sortPilots(a, b) {
        let a1 = a[1];
        let b1 = b[1];
        return b1 - a1
    }

}

solve(["Ferrari -> Kimi Raikonnen -> 25",
    "Ferrari -> Sebastian Vettel -> 18",
    "Mercedes -> Lewis Hamilton -> 10",
    "Mercedes -> Valteri Bottas -> 8",
    "Red Bull -> Max Verstapen -> 6",
    "Red Bull -> Daniel Ricciardo -> 4"]
)