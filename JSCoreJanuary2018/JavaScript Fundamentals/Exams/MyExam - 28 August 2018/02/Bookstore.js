function solve(arr) {
    let capacity = Number(arr.shift());
    let budget = Number(arr.shift());
    let books = new Map();

    for (let book of arr) {
        for (let bookInfo of book) {
            let name = bookInfo[0];
            let author = bookInfo[1];
            let price = Number(bookInfo[2]);

            books.set(price, {name: name, author: author});
        }
    }

    let sortedBooks = ([...books.entries()].sort(sortNum));

    let money = 0;
    let bought = new Map()
    if (sortedBooks.length > capacity) {
        for (let [price, bookInfo] of sortedBooks) {
            if (bought.size === capacity || money + price > budget){
                break;
            }
            money += price;
            bought.set(bookInfo.name, {author: bookInfo.author, price: price})
        }
    } else {
        for (let [price, bookInfo] of sortedBooks) {
            if (money + price > budget){
                break;
            }
            money += price;
            bought.set(bookInfo.name, {author: bookInfo.author, price: price})
        }
    }

    if (bought.size >= 5) {
        let price = 9999999999999999999;
        let bookName = ''
        for (let [book, info] of bought) {
            if (info.price < price) {
                price = info.price
                bookName = book;
            }
        }
        bought.get(bookName).price = price / 2;
        money = Math.floor((money - (50 * price) / 100) * 100) / 100;
    }

    let sortedBought = [...bought.entries()].sort()
    console.log("Books purchased:");
    for (let book of sortedBought) {
        console.log(`-> Book: "${book[0]}"; Author: ${book[1].author}; Price: ${book[1].price.toFixed(2)}`);
    }
    console.log(`Final sum: ${money.toFixed(2)} lv.`);


    function sortNum(a, b) {
        let a1 = a[0];
        let b1 = b[0];
        return a1 - b1;
    }


}

solve([2, 40,
        [['Little Women', 'Louisa May Alcott', '24.50'],
            ['The Cloud Atlas', 'David Mitchell', '18.20'],
            ['Jane Eyre', 'Charlotte Bronte', '13.65'],
            ['The Pilgrim\'s Progress', 'John Bunyan', '16.70'],
            ['The Scarlet Letter', 'Nathaniel Hawthorne', '14.25']]
    ]

)