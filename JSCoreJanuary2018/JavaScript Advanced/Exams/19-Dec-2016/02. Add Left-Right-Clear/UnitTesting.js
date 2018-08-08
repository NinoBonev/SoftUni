let expect = require('chai').expect;
let makeList = require('./MakeList');

describe("Testing Make List", function () {
    let list;
    beforeEach(function () {
        list = makeList();
    });
    describe("Testing correct initialization", function () {
        it('should return list of type {}', function () {
            expect(typeof list).to.be.equal('object')
        });
        it('should have prop addLeft', function () {
            expect(list.hasOwnProperty('addLeft')).to.be.true
        });
        it('should have prop addRight', function () {
            expect(list.hasOwnProperty('addLeft')).to.be.true
        });
        it('should have prop clear', function () {
            expect(list.hasOwnProperty('addLeft')).to.be.true
        });
        it('should have empty content', function () {
            expect(list.toString()).to.be.equal("")
        });
    })
    describe("Testing correct functionality", function () {
        it('should add correctly -> addLeft testing', function () {
            list.addLeft("Two");
            list.addLeft("One");
            list.addRight("Three")
            expect(list.toString()).to.be.equal("One, Two, Three");
            list.addLeft("Zero")
            list.addLeft({});
            expect(list.toString()).to.be.equal("[object Object], Zero, One, Two, Three")
        });
        it('should add correctly -> addRight testing', function () {
            list.addLeft("Two");
            list.addLeft("One");
            list.addRight("Three");
            expect(list.toString()).to.be.equal("One, Two, Three");
            list.addRight("Four")
            list.addRight({});
            expect(list.toString()).to.be.equal("One, Two, Three, Four, [object Object]")
        });
        it('should add correctly after clear command', function () {
            list.addLeft("Two");
            list.addLeft("One");
            list.addRight("Three");
            expect(list.toString()).to.be.equal("One, Two, Three");
            list.clear();
            list.addRight(2);
            list.addLeft(1)
            list.addRight("Three")
            expect(list.toString()).to.be.equal("1, 2, Three")
        });
    })
});