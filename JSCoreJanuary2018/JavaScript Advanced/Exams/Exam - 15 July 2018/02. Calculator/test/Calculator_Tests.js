let expect = require('chai').expect;
let Calculator = require('../Calculator');

describe("Test for Calculator class", function () {
    let testCalc;
    beforeEach(function () {
        testCalc = new Calculator();
    });
    describe("Class implementation tests - true", function () {
        it('should create new instance with no prams', function () {
            expect(Calculator.prototype.hasOwnProperty('expenses'));
            expect(Calculator.prototype.hasOwnProperty('add')).to.be.true;
            expect(Calculator.prototype.hasOwnProperty('divideNums')).to.be.true;
            expect(Calculator.prototype.hasOwnProperty('toString')).to.be.true;
            expect(Calculator.prototype.hasOwnProperty('orderBy')).to.be.true;
        });
        it('should crete a new instance', function () {
            let calc = new Calculator();
            expect(calc.expenses.length).to.be.equal(0);
        });
        it('instance proto to be equal to class prototype ', () => {
            let calc = new Calculator();
            expect(calc.__proto__ === Calculator.prototype).to.be.true;
            expect(calc.toString()).to.be.equal('empty array');
            expect(calc.orderBy()).to.be.equal('empty');
        });
    });
    describe("Class implementation tests - false", function () {
        it('should throw error', function () {
            let calc = new Calculator(4);
            expect(calc).to.throw
        });
    });
    describe("Testing class functionality with correct values", function () {
        it('should add values to the expenses', function () {
            testCalc.add("Pesho");
            expect(testCalc.expenses.length).to.be.equal(1);
            testCalc.add(3);
            expect(testCalc.expenses.length).to.be.equal(2);
            testCalc.add([]);
            expect(testCalc.expenses.length).to.be.equal(3);
            testCalc.add(2.4);
            expect(testCalc.expenses.length).to.be.equal(4);
        });
        it('should divide only the nums added', function () {
            testCalc.add("Pesho");
            testCalc.add(10);
            testCalc.add(10);
            testCalc.divideNums();
            expect(testCalc.expenses[0]).to.be.equal(1)
        });
        it('should orderd the arr', function () {
            testCalc.add(2);
            testCalc.add(3);
            testCalc.add(1);
            let result = testCalc.orderBy();
            expect(result).to.be.equal("1, 2, 3")
            testCalc.add("Pesho");
            let result1 = testCalc.orderBy();
            expect(result1).to.be.equal("1, 2, 3, Pesho")
        });
        it('should remove the strings after divide', function () {
            testCalc.add(2);
            testCalc.add(10);
            testCalc.add("Pesho");
            testCalc.add(1);
            testCalc.divideNums();
            let result = testCalc.orderBy();
            expect(result).to.be.equal('0.2')
        });
    });
    describe("It should throw error", function () {
        it('should return \'Cannot divide by zero\' string', function () {
            let newClac = new Calculator()
            newClac.add(10);
            newClac.add(2);
            newClac.add(0);
            expect(newClac.divideNums()).to.be.equal('Cannot divide by zero')
        });
        it('should throw \'There are no numbers in the array!\' error', function () {
            testCalc.add("Pesho")
            testCalc.add("Gosho");
            expect(() => testCalc.divideNums()).to.throw(Error, "There are no numbers in the array!")
        });
    });
    describe("Testing toString", function () {
        it('should return', function () {
            testCalc.add(2);
            testCalc.add(6);
            testCalc.add(1);
            testCalc.add("Add");
            expect(testCalc.toString()).to.be.equal("2 -> 6 -> 1 -> Add");
        });
    })
});