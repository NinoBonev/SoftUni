function solve(arr) {
    let month = arr.shift();
    let totalPrice = 0;
    let bookCount = 0;
    let booksByGenre = {};
    let otherBooks = {};

    for (let book of arr) {
        let data = book.split(" - ");
        let name;
        let price;
        let genre;
        if (data.length === 3) {
            bookCount++;
            name = data[0];
            genre = data[1];
            price = Number(data[2]);
            if (booksByGenre[genre] === undefined) {
                booksByGenre[genre] = {count: 0, total: 0};
            }
            booksByGenre[genre].count++;
        } else if (data.length === 2) {
            bookCount++;
            name = data[0];
            price = Number(data[1]);
            if (otherBooks[name] === undefined){
                otherBooks[name] = {count: 0, total: 0};
            }
            otherBooks[name].count++;
            otherBooks[name].total += price;
        }

        if (month === "January" && data.length === 3) {
            if (genre === "Fantasy") {
                booksByGenre[genre].total += 0.7 * price;
            } else {
                booksByGenre[genre].total += price;
            }
        } else if (month === "February" && data.length === 3) {
            if (genre === "Fantasy") {
                booksByGenre[genre].total += 0.7 * price;
            } else if (genre === "Children") {
                booksByGenre[genre].total += 0.8 * price;
            } else {
                booksByGenre[genre].total += price;
            }
        } else if (month === "March" && data.length === 3) {
            if (genre === "Children") {
                booksByGenre[genre].total += 0.8 * price;
            } else {
                booksByGenre[genre].total += price;
            }
        } else if (month === "November"  && data.length === 3) {
            if (genre === "Mystery") {
                booksByGenre[genre].total += 1.2 * price;
                if (booksByGenre[genre].count % 2 === 0 ) {
                    booksByGenre[genre].total -= (2.2 * price) / 100;
                }
            } else {
                booksByGenre[genre].total += price;
            }
        } else if (data.length === 3) {
            booksByGenre[genre].total += price;
        }
    }

    for (let book in otherBooks) {
        totalPrice += otherBooks[book].total;
    }
    for (let genre in booksByGenre) {
        if (month === "February") {
            if (genre === "Fantasy") {
                booksByGenre[genre].total = 0.97 * booksByGenre[genre].total;
            }
        } else if (month === "March") {
            if (genre === "Fantasy") {
                booksByGenre[genre].total = 0.97 * booksByGenre[genre].total;
            }
        }

        if (booksByGenre[genre].count > 5) {
            totalPrice += (0.9 * booksByGenre[genre].total);
        }

        if (bookCount >= 10) {
            totalPrice += 0.8 * booksByGenre[genre].total;
        }

        totalPrice += booksByGenre[genre].total;

    }

    console.log(`Mariyka owe ${totalPrice.toFixed(2)} money for ${bookCount} books.`);
}

solve(["February", "Harry Potter and the Sorcerer's Stone - Fantasy - 50",
    "Harry Potter and the Sorcerer's Stone - Children - 50",
    "A Killer's Mind - Mystery - 20",
    "Where's Spot? - 60.5", "Harry Potter and the Sorcerer's Stone - Fantasy - 50",
    "A Killer's Mind - Mystery - 20",
    "Spot? - 60.5"]);