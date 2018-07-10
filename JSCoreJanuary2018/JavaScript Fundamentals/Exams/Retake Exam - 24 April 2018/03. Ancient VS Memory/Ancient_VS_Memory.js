function stringReading(arr) {
    let string = '';
    for (let str of arr) {
        string += str + ' ';
    }

    let regex = /32656 19759 32763 0 (\d+) 0 ((\d{2,} )+)/g;
    let match = string.match(regex);

    for (let result of match) {
        let name = '';
        let nums = result.split(' ');
        let wordCount = Number(nums[4]);
        if (wordCount > 0) {
            for (let i = 6; i < 6 + Number(nums[4]); i++) {
                name += String.fromCharCode(nums[i]);
            }
        }
        console.log(name);
    }
}

stringReading(['0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 32656 19759 32763 0', '5 0 71 111 115 104 111 0 0 0 0 0 0 0 0 0 32656 19759 32763 0 4 0',
    '75 105 114 111 0 0 0 0 0 0 0 0 0 0 32656 19759 32763 0 8 0 86 101', '114 111 110 105 107 97 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0']);