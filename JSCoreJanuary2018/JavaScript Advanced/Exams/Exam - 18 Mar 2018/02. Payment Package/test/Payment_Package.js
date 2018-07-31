let expect = require('chai').expect;
let PaymentPackage = require("../PaymentPackage");

describe("Testing class Payment_Package", function () {
    let testPayment;
    beforeEach(function () {
        testPayment = new PaymentPackage("Test", 200)
    });
    describe("Testing correct initialization ", function () {
        it('Should have all the props', function () {
            expect(PaymentPackage.prototype.hasOwnProperty("name")).to.be.equal(true);
            expect(PaymentPackage.prototype.hasOwnProperty("value")).to.be.equal(true);
            expect(PaymentPackage.prototype.hasOwnProperty("VAT")).to.be.equal(true);
            expect(PaymentPackage.prototype.hasOwnProperty("active")).to.be.equal(true);
            expect(PaymentPackage.prototype.hasOwnProperty("toString")).to.be.equal(true);
        });
        it('Should create a new instance', function () {
            let payment = new PaymentPackage("New Payment", 20);
            expect(payment.name).to.be.equal("New Payment");
            expect(payment.value).to.be.equal(20);
            expect(payment.VAT).to.be.equal(20);
            expect(payment.active).to.be.true
        });
        it('instance proto to be equal to class prototype ', () => {
            let payment = new PaymentPackage("New Payment", 20);
            expect(payment.__proto__ === PaymentPackage.prototype).to.be.true
        });
    });
    describe("Validation value prop tests", function () {
        it('Should throw \'Value must be a non-negative number\' error', function () {
            expect(() => new PaymentPackage("Error 1")).to.throw(Error, "Value must be a non-negative number");
        });
        it('Should throw \'Value must be a non-negative number\' error', function () {
            expect(() => new PaymentPackage("Error", -15)).to.throw(Error, "Value must be a non-negative number");
        });
        it('Should throw \'Value must be a non-negative number\' error', function () {
            expect(() => new PaymentPackage("Error", '15')).to.throw(Error, "Value must be a non-negative number");
        });
        it('Should throw \'Value must be a non-negative number\' error', function () {
            expect(() => new PaymentPackage("empty", {})).to.throw(Error, "Value must be a non-negative number");
        });
    });
    describe("Validation name prop tests", function () {
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage(15)).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage(15, 20)).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage("", 20)).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage("", {})).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage({name: "Name"}, 20)).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage(undefined, 20)).to.throw(Error, "Name must be a non-empty string")
        });
        it('Should throw \'Name must be a non-empty string\' error', function () {
            expect(() => new PaymentPackage({}, 20)).to.throw(Error, "Name must be a non-empty string")
        });
    });
    describe("Validation VAT prop tests", function () {
        it('Should throw \'VAT must be a non-negative number\' error', function () {
            expect(() => testPayment.VAT = -5).to.throw(Error, "VAT must be a non-negative number");
        });
        it('Should throw \'VAT must be a non-negative number\' error', function () {
            expect(() => testPayment.VAT = 'string').to.throw(Error, "VAT must be a non-negative number");
        });
    });
    describe("Validation active prop tests", function () {
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = -5).to.throw(Error, "Active status must be a boolean");
        });
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = 'string').to.throw(Error, "Active status must be a boolean");
        });
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = [true]).to.throw(Error, "Active status must be a boolean");
        });
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = {boolean: true}).to.throw(Error, "Active status must be a boolean");
        });
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = null).to.throw(Error, "Active status must be a boolean");
        });
        it('Should throw \'Active status must be a boolean\' error', function () {
            expect(() => testPayment.active = undefined).to.throw(Error, "Active status must be a boolean");
        });
    });
    describe("Testing class functionality", function () {
        it('Should return the name from the setters', function () {
            testPayment = new PaymentPackage("NewTest", 35);
            expect(testPayment.name).to.be.equal("NewTest");
        });
        it('Should return the value from the setters', function () {
            testPayment = new PaymentPackage("NewTest", 35);
            expect(testPayment.value).to.be.equal(35);
        });
        it('Should return the value from the setters', function () {
            expect(testPayment.active).to.be.true;
        });
        it('Should return the value from the setters', function () {
            testPayment.active = false;
            expect(testPayment.active).to.be.false;
        });
        it('Should return the value from the setters', function () {
            expect(testPayment.VAT).to.be.equal(20);
        });
        it('Should return the value from the setters', function () {
            testPayment.VAT = 35;
            expect(testPayment.VAT).to.be.equal(35);
        });
        it('Should return the value from the setters', function () {
            testPayment.name = "NewName";
            expect(testPayment.name).to.be.equal("NewName")
        });
        it('Should return the value from the setters', function () {
            testPayment.value = 2;
            expect(testPayment.value).to.be.equal(2)
        });
    });
    describe("Testing toString result", function () {
        it('Should return the toString for active: true', function () {
            expect(testPayment.toString()).to.be.equal('Package: Test' + "\n" + '- Value (excl. VAT): 200' + "\n" + '- Value (VAT 20%): 240')
        });
        it('Should return the toString for active: false', function () {
            testPayment.active = false;
            expect(testPayment.toString()).to.be.equal('Package: Test' + " (inactive)" + "\n" + '- Value (excl. VAT): 200' + "\n" + '- Value (VAT 20%): 240')
        });
    })
});