function solve(arr) {
    let capacity = Number(arr.shift());
    let budget = Number(arr.shift());
    let books = new Map();

    for (let book of arr) {
        for (let bookInfo of book) {
            let name = bookInfo[0];
            let author = bookInfo[1];
            let price = Number(bookInfo[2]);

            books.set(name, {price: price, author: author});
        }
    }

    let sortedBooks = ([...books.entries()].sort(sortNum));

    let money = 0;
    let bought = new Map();
    if (sortedBooks.length > capacity) {
        for (let [name, bookInfo] of sortedBooks) {
            if (bought.size === capacity || money + bookInfo.price > budget){
                break;
            }
            money += bookInfo.price;
            bought.set(name, {author: bookInfo.author, price: bookInfo.price})
        }

    } else {
        for (let [name, bookInfo] of sortedBooks) {
            if (money + bookInfo.price > budget){
                break;
            }
            money += bookInfo.price;
            bought.set(name, {author: bookInfo.author, price: bookInfo.price})
        }
    }

    if (bought.size >= 5) {
        let price = 99999999999999999999999999999999;
        let bookName = '';
        for (let [book, info] of bought) {
            if (info.price < price) {
                price = info.price;
                bookName = book;
            }
        }
        bought.get(bookName).price = price / 2;
        money = Math.floor((money - (50 * price) / 100) * 100) / 100;
    }

    let sortedBought = [...bought.entries()].sort();
    console.log("Books purchased:");
    for (let book of sortedBought) {
        console.log(`-> Book: "${book[0]}"; Author: ${book[1].author}; Price: ${book[1].price.toFixed(2)}`);
    }
    console.log(`Final sum: ${money.toFixed(2)} lv.`);


    function sortNum(a, b) {
        let a1 = a[1].price;
        let b1 = b[1].price;
        return a1 - b1;
    }


}