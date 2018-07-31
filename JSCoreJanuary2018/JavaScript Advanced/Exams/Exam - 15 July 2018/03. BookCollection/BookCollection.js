class BookCollection {

    constructor(shelfGenre, room, shelfCapacity) {
        this.setRoom(room);
        this.shelfGenre = shelfGenre;
        this.shelfCapacity = shelfCapacity;
        this.shelf = [];

    }

    getRoom() {
        return this.room
    }

    setRoom(room) {
        if (room !== 'livingRoom' && room !== 'bedRoom' && room !== 'closet') {
            throw new Error(`Cannot have book shelf in ${room}`);
        }
        this.room = room;
    }

    addBook(bookName, bookAuthor, genre) {
        let book = {name: bookName, author: bookAuthor, genre: genre};
        if (this.shelf !== undefined) {
            if (this.shelf.length < this.shelfCapacity) {
                this.shelf.push(book)
            } else {
                this.shelf.shift();
                this.shelf.push(book);
            }
        }
        this.shelf.sort((a, b) => {
            let a1 = a.author;
            let b1 = b.author;
            return a1.localeCompare(b1)
        });
    }

    throwAwayBook(bookName) {
        if (this.shelf !== undefined) {
            for (let i = this.shelf.length - 1; i >= 0; i--) {
                if (this.shelf[i].name === bookName) {
                    this.shelf.splice(i, 1);
                }
            }
        }
    }

    showBooks(genre) {
        if (this.shelf !== undefined) {
            let result = '';
            result += `Results for search "${genre}":\n`;
            for (let i = 0; i < this.shelf.filter(e => e !== null).length; i++) {
                if (this.shelf[i] !== undefined && this.shelf[i].genre === genre) {
                    result += `\uD83D\uDCD6 ${this.shelf[i].author} - "${this.shelf[i].name}"\n`
                }
            }
            return result.trim();
        }
    }

    get shelfCondition() {
        if (this.shelf !== undefined) {
            return this.shelfCapacity - this.shelf.filter(e => e !== null).length;
        }
    }

    toString() {
        if (this.shelf !== undefined) {
            let result = '';
            let count = 0;
            result += `"${this.shelfGenre}" shelf in ${this.room} contains:\n`;
            for (const book of this.shelf) {
                count++;
                result += `\uD83D\uDCD6 "${book.name}" - ${book.author}\n`;
            }
            if (count > 0) {
                return result.trim();
            } else {
                return "It's an empty shelf"
            }
        }
    }
}

let bedRoom = new BookCollection('Mixed', 'bedRoom', 5);
bedRoom.addBook("John Adams", "David McCullough", "history");
// bedRoom.addBook("The Guns of August", "Cuentos para pensar", "history");
// bedRoom.addBook("Atlas of Remote Islands", "Judith Schalansky");
// bedRoom.addBook("Paddle-to-the-Sea", "Holling Clancy Holling");
console.log("Shelf's capacity: " + bedRoom.shelfCondition);
console.log(bedRoom.showBooks("history"));
console.log(bedRoom.toString());






