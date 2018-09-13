function solve(arr) {
    let shelf = new Map();

    for (let obj of arr) {
        let author = obj.author;
        let genre = obj.bookInfo.genre;
        let name = obj.bookInfo.name;
        let pages = obj.bookInfo.pages;

        if (!(author === undefined || genre === undefined ||
            name === undefined || pages === undefined)
            && pages === Math.round(pages) && typeof pages === 'number') {
            if (!shelf.has(genre)) {
                shelf.set(genre, new Map())
            }

            let authorMap = shelf.get(genre)
            if (!authorMap.has(author)) {
                authorMap.set(author, new Map())
            }
            authorMap.get(author).set(name, pages)
        }
    }


    for (let [genre, authors] of shelf) {
        if (authors.size > 0) {
            let pagesTotal = 0;
            let sortedAuthor = [...authors.entries()].sort();
            console.log(`${genre}:`);
            for (let [author, info] of sortedAuthor) {
                console.log(`> ${author}`);
                let sortedInfo = [...info.entries()].sort().reverse();
                for (let [name, pages] of sortedInfo) {
                    console.log(`>>> Book name: "${name}", pages: ${pages}`);
                    pagesTotal += pages
                }

            }
            console.log(`*Total pages from genre ${genre} to be read: ${pagesTotal}`);
            console.log("-------------")
        }

    }

}

solve([{"author": "Ivan Vazov", "bookInfo": {"genre": "Patepis", "name": "Vitosha", "pages": 20}},
    {"author": "Ivan Vazov", "bookInfo": {"genre": "Poeziq", "name": "Epopeq na zabravenite"}},
    {"author": "Aleko Konstantinov", "bookInfo": {"genre": "Patepis", "name": "Do chikago i nazad", "pages": 200}},
    {"author": "Aleko Konstantinov", "bookInfo": {"genre": "Feyleton", "name": "Bay Ganyo", "pages": 250}},
    {"author": "Ivan Vazov", "bookInfo": {"genre": "Roman", "name": "Pod Igoto", "pages": 300}}]
)