function test(arr) {
    const regex = /^<message (.+)>(.+)\n?(.+)?\n?(.+)?\n?(.+)?\n?(.+)?<\/message>$/gm;
    let isMatch = false;
    let result;

    while ((result = regex.exec(arr)) !== null){
        isMatch = true;
        let from = '';
        let to = '';
        let message = [];
        for (let i = 2; i < result.length; i++) {
            message.push(result[i]);
        }

        let elements = result[1].split("\" ");
        const toInnerRegex = /^to="([a-zA-Z\s]+)"?$/;
        const fromInnerRegex = /^from="([a-zA-Z\s]+)"?$/;
        const attributesInnerRegex = /^[a-z]+="[a-zA-Z0-9.\s]+"?$/;
        let matchCount = 0;
        let matchToCount = 0;
        let matchFromCount = 0;

        for (let element of elements) {
            let match = attributesInnerRegex.exec(element);
            let matchTo = toInnerRegex.exec(element);
            let matchFrom = fromInnerRegex.exec(element);
            if (match){
                matchCount++;
            }
            if (matchTo){
                to = matchTo[1];
                matchToCount++;
            }
            if (matchFrom){
                from = matchFrom[1];
                matchFromCount++;
            }
        }

        if (matchCount !== elements.length) {
            console.log("Invalid message format");
            break;
        }
        if (matchFromCount !== 1 || matchToCount !== 1){
            console.log("Invalid message format");
            break;
        }


        //if (result[1].contains())
        // if (result.index === regex.lastIndex) {
        //     regex.lastIndex++;
        // }
        // result.forEach((match, groupIndex) => {
        //     if (groupIndex !== 0) {
        //         console.log("First name: ", match + " Group index: ", groupIndex);
        //     }
        // });

        console.log(`\<article\>
  <div>From: <span class="sender">${from}</span></div>
  <div>To: <span class="recipient">${to}</span></div>
  <div>`);
        for (let msg of message) {
            if (msg !== undefined) {
                console.log(`    <p>${msg}</p>`)
            }
        }
        console.log('  </div>\n' +
            '</article>')


    }

    if (!isMatch){
        console.log("Invalid message format");
    }

}

test("<message from=\"John Doe\" to=\"Alice\">Not much, just chillin. How about you?</message>")