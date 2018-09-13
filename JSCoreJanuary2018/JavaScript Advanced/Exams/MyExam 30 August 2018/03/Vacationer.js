class Vacationer {

    constructor(arr1, arr2) {
        this.setName(arr1);
        this.idNumber = this.generateIDNumber();
        this.creditCard = {
            cardNumber: 1111,
            expirationDate: '',
            securityNumber: 111
        };
        if (arr2 !== undefined) {
            this.addCreditCardInfo(arr2)
        }
        this.wishList = [];

    }

    setName(arr){
        if (arr.length !== 3) {
            throw new Error('Name must include first name, middle name and last name\n')
        }

        if (!(/^[A-Z]{1}[a-z]+$/.test(arr[0]))) {
            throw new Error('Invalid full name\n');
        }
        if (!(/^[A-Z]{1}[a-z]+$/.test(arr[1]))) {
            throw new Error('Invalid full name\n');
        }
        if (!(/^[A-Z]{1}[a-z]+$/.test(arr[2]))) {
            throw new Error('Invalid full name\n');
        }

        this.fullName = {
            firstName: arr[0],
            middleName: arr[1],
            lastName: arr[2]
        }
    }

    addCreditCardInfo(arr){
        if (arr.length !== 3){
            throw new Error("Missing credit card information\n")
        }

        if (typeof arr[0] !== "number" || typeof arr[2] !== "number"){
            throw new Error("Invalid credit card details\n")
        }

        this.creditCard.cardNumber = arr[0];
        this.creditCard.expirationDate = arr[1];
        this.creditCard.securityNumber = arr[2];
    }

    generateIDNumber(){
        let vowel = ["a", "e", "o", "i", "u"];
        let sum = this.fullName.firstName.charCodeAt(0) * 231 + 139 * this.fullName.middleName.length;
        if (vowel.includes(this.fullName.lastName.charAt(this.fullName.lastName.length - 1))){
            sum = sum * 10 + 8;
        } else {
            sum = sum * 10 + 7;
        }
        return sum.toString();
    }

    addDestinationToWishList(destination){
        if (this.wishList.includes(destination)){
            throw new Error("Destination already exists in wishlist\n")
        }

        this.wishList.push(destination);
        this.wishList.sort(sortList);

        function sortList(a, b) {
            let a1 = a.length;
            let b1 = b.length;
            return a1 - b1;
        }
    }

    getVacationerInfo(){
        let result = '';
        result += `Name: ${this.fullName.firstName} ${this.fullName.middleName} ${this.fullName.lastName}\n`;
        result += `ID Number: ${this.idNumber}\n`;
        result += "Wishlist:\n";
        result += this.wishList.length === 0 ? 'empty' : this.wishList.join(", ");
        result += "\n";
        result += "Credit Card:\n";
        result += `Card Number: ${this.creditCard.cardNumber}\n`;
        result += `Expiration Date: ${this.creditCard.expirationDate}\n`;
        result += `Security Number: ${this.creditCard.securityNumber}\n`;

        return result;
    }


}

// Initialize vacationers with 2 and 3 parameters
let vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]);
let vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],
    [123456789, "10/01/2018", 777]);

// Should throw an error (Invalid full name)
try {
    let vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]);
} catch (err) {
    console.log("Error: " + err.message);
}

// Should throw an error (Missing credit card information)
try {
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]);
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]);
} catch (err) {
    console.log("Error: " + err.message);
}

vacationer1.addDestinationToWishList('Spain');
vacationer1.addDestinationToWishList('Germany');
vacationer1.addDestinationToWishList('Bali');

// Return information about the vacationers
console.log(vacationer1.getVacationerInfo());
console.log(vacationer2.getVacationerInfo());


