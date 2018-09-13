function solve(arr) {
    let organism = new Map();

    const regex = /^([a-zA-Z!@#$?]+)=([0-9]+)--([0-9]+)<<([a-zA-Z]+)$/gm;
    let result;

    for (let line of arr) {
        if (line === 'Stop'){
            break;
        }
        while ((result = regex.exec(line)) !== null){
            if (result.index === regex.lastIndex) {
                regex.lastIndex++;
            }

            if (result[1].replace(/[!@#$?]/g, '').length === Number(result[2])){
                if (!organism.has(result[4])){
                    organism.set(result[4], 0);
                }
                let currentCount = organism.get(result[4]);
                organism.set(result[4], currentCount + Number(result[3]))
            }
        }
    }

    let sortedOrganism = [...organism.entries()].sort(sortOrganism);

    for (let org of sortedOrganism) {
        console.log(`${org[0]} has genome size of ${org[1]}`);
    }

    function sortOrganism(a, b){
        return b[1] - a[1];
    }


}

// solve(['!@ab?si?di!a@=7--152<<human',
//     'b!etu?la@=6--321<<dog',
//     '!curtob@acter##ium$=14--230<<dog',
//     '!some@thin@g##=9<<human,',
//     'Stop!',
//     '!some@thin@g##=9<<human,'
// ]);

solve(['=12<<cat',
    '!vi@rus?=2--142',
        '?!cur##viba@cter!!=11--800<<cat',
    '!fre?esia#=7--450<<mouse',
    '@pa!rcuba@cteria$=13--351<<mouse',
    '!richel#ia??=8--900<<human',
        'Stop!'
])