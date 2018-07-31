let expect = require('chai').expect;
let SubscriptionCard = require("../SubscriptionCard");

describe("Test Subscription Card", function () {
    describe("Test class and its instance", () => {
        it('test class prototype', function () {
            expect(SubscriptionCard.prototype.hasOwnProperty("firstName"));
            expect(SubscriptionCard.prototype.hasOwnProperty("lastName"))
            expect(SubscriptionCard.prototype.hasOwnProperty("SSN"));
            expect(SubscriptionCard.prototype.hasOwnProperty("isBlocked"));
            expect(SubscriptionCard.prototype.hasOwnProperty("isValid"));
        });
        it('create an instance without data', function () {
            let card = new SubscriptionCard();
            expect(card.firstName).to.be.undefined;
            expect(card.lastName).to.be.undefined;
            expect(card.SSN).to.be.undefined;
        });
        it('create an instance with correct data ', function () {
            let card = new SubscriptionCard("Nino", "Bonev", 21212121);
            expect(card.firstName).to.be.equal("Nino");
            expect(card.lastName).to.be.equal("Bonev");
            expect(card.SSN).to.be.equal(21212121);
        });
        it('should not make an instance', function () {
            let card = new SubscriptionCard("Nino", "Bonev", "212121")
            expect(card).to.throw
        });
        it('instance proto to be equal to class prototype ', () => {
            let card = new SubscriptionCard("stamat", "stamatov", "1234567");
            expect(card.__proto__ === SubscriptionCard.prototype).to.be.true
        });
    });
    describe("Check class functionality", function () {
        let card;
        beforeEach(function () {
            card = new SubscriptionCard("Nino", "Bonev", 212121)
        });
        it('test privacy of class pros', function () {
            card.firstName = "Pesho";
            card.lastName = "Gosho";
            card.SSN = 121212;
            expect(card.firstName).to.be.equal("Nino");
            expect(card.lastName).to.be.equal("Bonev");
            expect(card.SSN).to.be.equal(212121);
        });
        it('should block the card', function () {
            card.block();
            expect(card.isBlocked).to.be.true
        });
        it('should unblock the card', function () {
            card.block();
            expect(card.isBlocked).to.be.true;
            card.unblock();
            expect(card.isBlocked).to.be.false;
        });
    })
});