function solve(input) {
    let surveyCheck = /<svg>((.|\n)*?)<\/svg>/g;


    if (surveyCheck.test(input)) {
        let stringRegex = /<cat><text>.*\[(.*)].*<\/text><\/cat>\s*<cat>.*<\/cat>/g;
        let valuesRegex = /\s*<g><val>([0-9]+)<\/val>([0-9]+)<\/g>/g;

        let stringMatch = stringRegex.exec(input);
        if (stringMatch) {
            let ratingSum = 0;
            let ratingCount = 0;
            let surveyLabel = stringMatch[1];

            let valuesMatch;
            while ((valuesMatch = valuesRegex.exec(input)) !== null) {
                if (Number(valuesMatch[1]) > 0 && Number(valuesMatch[1]) <= 10) {
                    if (valuesMatch[1] = Number(valuesMatch[1])) {
                        ratingSum += Number(valuesMatch[1]) * Number(valuesMatch[2]);
                    }
                    if (valuesMatch[2] = Number(valuesMatch[2])) {
                        ratingCount += Number(valuesMatch[2]);
                    }
                }
            }

            let averageRating = parseFloat((ratingSum / ratingCount).toFixed(2));
            if (ratingCount === 0){
                averageRating = 0;
            }
            console.log(`${surveyLabel}: ${averageRating}`);
        } else {
            console.log('Invalid format');
        }

    } else {
        console.log('No survey found');
    }
}

solve(
'<p>Some random text</p><svg><cat><text>How do you rate our food? [Food - General]</text></cat><cat><g><val>1</val>0</g><g><val>2</val>1</g><g><val>3</val>3</g><g><val>4</val>10</g><g><val>5</val>7</g></cat></svg><p>Some more random text</p>'
);