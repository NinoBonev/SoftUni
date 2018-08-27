function solve(arr) {
    let data = new Map();

    for (let obj of arr) {
        let [system, candidate, votes] = [obj.system, obj.candidate, obj.votes];
        if (!data.has(system)){
            data.set(system, new Map());
        }
        let candidateMap = data.get(system);
        if (!candidateMap.has(candidate)){
            candidateMap.set(candidate, 0)
        }
        let currentVotes = candidateMap.get(candidate);
        data.get(system).set(candidate, currentVotes + votes);
    }

    let totalVotes = new Map();
    let systemWinners = new Map();
    let totalVotesValue = 0;

    for (let [system, value] of data) {
        let winningCandidate = '';
        let votesMax = 0;
        let votesTotal = 0;
        for (let [candidate, votes] of value) {
            if (!totalVotes.has(candidate)){
                totalVotes.set(candidate, 0)
            }
            if (votes > votesMax){
                votesMax = votes;
                winningCandidate = candidate;
            }
            votesTotal += votes;
            totalVotesValue += votes;
        }
        let current = totalVotes.get(winningCandidate);
        totalVotes.set(winningCandidate, current + votesTotal);
        if (!systemWinners.has(winningCandidate)){
            systemWinners.set(winningCandidate, [])
        }
        systemWinners.get(winningCandidate).push({system: system, votes: votesTotal});
    }

    let sortedVotes = [...totalVotes.entries()].sort(sortVotes);

    if (sortedVotes[0][1] > totalVotesValue / 2) {
        let winner = sortedVotes.shift();
        if (winner[1] === totalVotesValue){
            console.log(`${winner[0]} wins with ${winner[1]} votes`);
            console.log(`${winner[0]} wins unopposed!`);
        } else {
            let second = sortedVotes.shift();
            console.log(`${winner[0]} wins with ${winner[1]} votes`);
            console.log(`Runner up: ${second[0]}`);
            for (let [systemWinner, system] of systemWinners) {
                if (systemWinner === second[0]){
                    let sorted = system.sort((a, b) => b.votes- a.votes)
                    for (let sortedElement of sorted) {
                        console.log(`${sortedElement.system}: ${sortedElement.votes}`)
                    }
                }
            }
        }
    } else {
        let winner = sortedVotes.shift();
        let second = sortedVotes.shift();
        console.log(`Runoff between ${winner[0]} with ${Math.trunc((winner[1] / totalVotesValue)* 100) }% and ${second[0]} with ${Math.trunc((second[1] / totalVotesValue) * 100)}%`)
    }

    function sortVotes(a, b) {
        let aVotes = a[1];
        let bVotes = b[1];
        return bVotes - aVotes;
    }
}

solve([ { system: 'Theta', candidate: 'Flying Shrimp', votes: 10 },
    { system: 'Sigma', candidate: 'Space Cow',     votes: 200 },
    { system: 'Sigma', candidate: 'Flying Shrimp', votes: 120 },
    { system: 'Tau',   candidate: 'Space Cow',     votes: 15 },
    { system: 'Sigma', candidate: 'Space Cow',     votes: 60 },
    { system: 'Tau',   candidate: 'Flying Shrimp', votes: 150 } ]
)