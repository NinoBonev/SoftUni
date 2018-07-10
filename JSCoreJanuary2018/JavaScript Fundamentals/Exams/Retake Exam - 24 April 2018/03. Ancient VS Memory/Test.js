function test(arr) {
    const regex = /([A-Z][a-z]+)\s([A-Z][a-z]+)/gm;
    let result;

    while ((result = regex.exec(arr)) !== null){
        if (result.index === regex.lastIndex) {
            regex.lastIndex++;
        }
        result.forEach((match, groupIndex) => {
            if (groupIndex !== 0) {
                console.log("First name: ", match + " Group index: ", groupIndex);
            }
        });

        console.log(result[1]);
        console.log(result[2]);
    }
}
test('Ivan Ivanov is a Computer engineer. He is good, but Asen Petrov is better. Both of them are students in Asen Zlatarov school.')