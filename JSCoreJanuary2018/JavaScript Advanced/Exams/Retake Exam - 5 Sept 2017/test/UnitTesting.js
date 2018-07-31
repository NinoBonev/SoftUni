let expect = require('chai').expect;
let StringBuilder = require('../StringBuilder');

describe("Testing class instance", function () {
    let testString;
    beforeEach(function () {
        testString = new StringBuilder("NewString");
    });
    describe("Testing class instance with correct data", function () {
        it('Should make new instance with correct props', function () {
            expect(StringBuilder.prototype.hasOwnProperty("stringArray"));
            expect(StringBuilder.prototype.hasOwnProperty("append")).to.be.true;
            expect(StringBuilder.prototype.hasOwnProperty("prepend")).to.be.true;
            expect(StringBuilder.prototype.hasOwnProperty("insertAt")).to.be.true;
            expect(StringBuilder.prototype.hasOwnProperty("remove")).to.be.true;
            expect(StringBuilder.prototype.hasOwnProperty("toString")).to.be.true;
        });
        it('should make new instance with no arguments', function () {
            let string = new StringBuilder();
            expect(string.toString()).to.be.equal('')
        });
        it('should make new instance with arguments', function () {
            let string = new StringBuilder("new");
            expect(string.toString()).to.be.equal('new')
        });
        it('instance proto to be equal to class prototype ', () => {
            let string = new StringBuilder();
            expect(string.__proto__ === StringBuilder.prototype).to.be.true;
        });
        it('has all properties', function () {
            expect(testString.hasOwnProperty('_stringArray')).to.equal(true, "Missing _stringArray property");
        });
    });
    describe("Testing class instance with incorrect data", function () {
        it('should throw error during instance creating', function () {
            expect(() => new StringBuilder(5)).to.throw(TypeError, 'Argument must be string')
        });
        it('should throw error during instance creating', function () {
            expect(() => new StringBuilder({}, "new")).to.throw(TypeError, 'Argument must be string')
        });
    });
    describe("Testing class functionality", function () {
        it('must initialize data to a string array', function () {
            expect(testString._stringArray instanceof Array).to.equal(true, 'Data must be of type array');
            compareArray(testString._stringArray, Array.from("NewString"));
        });
        it('should append text', function () {
            testString.append(" appended");
            expect(testString.toString()).to.be.equal("NewString appended")
        });
        it('should throw error', function () {
            expect(() => testString.append(5)).to.throw(TypeError, 'Argument must be string')
        });
        it('should prepend text', function () {
            testString.prepend("This is ");
            expect(testString.toString()).to.be.equal("This is NewString")
        });
        it('should throw error', function () {
            expect(() => testString.prepend(5)).to.throw(TypeError, 'Argument must be string')
        });
        it('inserts correctly', function () {
            let str = 'kek';
            testString.insertAt(str, 3);
            let expected = Array.from("NewString");
            expected.splice(3, 0, ...str);
            compareArray(testString._stringArray, expected);
        });
        it('should insert text', function () {
            testString.insertAt("_", 3);
            expect(testString.toString()).to.be.equal("New_String")
        });
        it('should throw error', function () {
            expect(() => testString.insertAt(5)).to.throw(TypeError, 'Argument must be string')
        });
        it('should throw error', function () {
            expect(() => testString.insertAt(4, 3)).to.throw(TypeError, 'Argument must be string')
        });
        it('should remove text', function () {
            testString.remove(0, 3);
            expect(testString.toString()).to.be.equal("String")
        });
        it('should remove text', function () {
            testString.remove(-10, 30);
            expect(testString.toString()).to.be.equal("")
        });
        it('should return toString', function () {
            expect(testString.toString()).to.be.equal("NewString")
        });
    })

    function compareArray(source, expected) {
        expect(source.length).to.equal(expected.length, "Arrays don't match");
        for (let i = 0; i < source.length; i++) {
            expect(source[i]).to.equal(expected[i], 'Element ' + i + ' mismatch');
        }
    }
});