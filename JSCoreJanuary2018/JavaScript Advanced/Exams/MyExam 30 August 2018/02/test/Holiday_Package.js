let expect = require('chai').expect;
let HolidayPackage = require("../HolidayPackage");

describe("Testing class Holiday_Package", function () {
    let holidayPackage;
    let winterHoliday;
    let springHoliday;

    beforeEach(function () {
        holidayPackage = new HolidayPackage("Albania", "Summer");
        winterHoliday = new HolidayPackage("Bulgaria", "Winter");
        springHoliday = new HolidayPackage("Scotland", "Spring");
    });
    describe("Testing correct initialization ", function () {
        it('Should have all the props', function () {
            expect(HolidayPackage.prototype.hasOwnProperty("vacationers"));
            expect(HolidayPackage.prototype.hasOwnProperty("destination"));
            expect(HolidayPackage.prototype.hasOwnProperty("season"));
            expect(HolidayPackage.prototype.hasOwnProperty("insuranceIncluded"));
        });
        it('Should create a new instance', function () {
            let holiday = new HolidayPackage("Burgas", "Sega");
            expect(holiday.vacationers.length).to.be.equal(0);
            expect(holiday.destination).to.be.equal("Burgas");
            expect(holiday.season).to.be.equal("Sega");
            expect(holiday.insuranceIncluded).to.be.false
        });
        it('Should create a new instance', function () {
            let holiday = new HolidayPackage(123, 345);
            expect(holiday.vacationers.length).to.be.equal(0);
            expect(holiday.destination).to.be.equal(123);
            expect(holiday.season).to.be.equal(345);
            expect(holiday.insuranceIncluded).to.be.false
        });
        it('instance proto to be equal to class prototype ', () => {
            let holiday = new HolidayPackage("Burgas", "Sega");
            expect(holiday.__proto__ === HolidayPackage.prototype).to.be.true
        });
        it('test privacy of class pros', function () {
            let holiday = new HolidayPackage("Burgas", "Sega");
            holiday.destination = "Pesho";
            holiday.season = "Gosho";
            expect(holiday.destination).to.be.equal("Pesho");
            expect(holiday.season).to.be.equal("Gosho");
        });
    });
    describe("Class implementation tests - false", function () {
        it('should throw error', function () {
            let holiday = new HolidayPackage();
            expect(holiday).to.throw
        });
        it('should throw error', function () {
            let holiday = new HolidayPackage("Burgas");
            expect(holiday).to.throw
        });
        it('should throw error', function () {
            let holiday = new HolidayPackage("Burgas", 0);
            expect(holiday).to.throw
        });
        it('should throw error', function () {
            let holiday = new HolidayPackage(0);
            expect(holiday).to.throw
        });
        it('should throw error', function () {
            let holiday = new HolidayPackage({}, "Burgas");
            expect(holiday).to.throw
        });
    });
    describe("Testing class functionality with correct values", function () {
        it('should add vacationers to the Array', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            holidayPackage.addVacationer("Nino Bonev");
            expect(holidayPackage.vacationers.length).to.be.equal(1);
        });
        it('should add vacationers to the Array', function () {
            expect(typeof holidayPackage.insuranceIncluded).to.be.equal('boolean');
        });
        it('should show the correct type of vacationers', function () {
            let message = holidayPackage.showVacationers();
            expect(typeof message).to.be.equal("string");
            holidayPackage.addVacationer("Nino Bonev");
            let newMessage = holidayPackage.showVacationers();
            expect(typeof newMessage).to.be.equal("string");
        });
        it('should show the correct number of vacationers', function () {
            let message = holidayPackage.showVacationers();
            expect(message).to.be.equal("No vacationers are added yet");
            holidayPackage.addVacationer("Nino Bonev");
            let newMessage = holidayPackage.showVacationers();
            expect(newMessage).to.be.equal("Vacationers:\n" + "Nino Bonev");
            holidayPackage.addVacationer("Veselin Bonev");
            let newMess = holidayPackage.showVacationers();
            expect(newMess).to.be.equal("Vacationers:\n" + "Nino Bonev\n" + "Veselin Bonev");
        });
        it('should set the insurance', function () {
            holidayPackage.insuranceIncluded = true;
            expect(holidayPackage.insuranceIncluded).to.be.true;
            holidayPackage.insuranceIncluded = false;
            expect(holidayPackage.insuranceIncluded).to.be.false;
        });
        it('should generate package', function () {
            holidayPackage.addVacationer("Nino Bonev");
            let message = holidayPackage.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Albania\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 600")
        });
        it('should generate package', function () {
            holidayPackage.addVacationer("Nino Bonev");
            let message = holidayPackage.generateHolidayPackage();
            expect(typeof message).to.be.equal('string')
        });
        it('should generate package with addedInsurance', function () {
            holidayPackage.addVacationer("Nino Bonev");
            holidayPackage.insuranceIncluded = true;
            let message = holidayPackage.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Albania\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 700")
        });
        it('should generate package with addedInsurance', function () {
            winterHoliday.addVacationer("Nino Bonev");
            winterHoliday.insuranceIncluded = true;
            let message = winterHoliday.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Bulgaria\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 700")
        });
        it('should generate package with addedInsurance', function () {
            winterHoliday.addVacationer("Nino Bonev");
            winterHoliday.insuranceIncluded = false;
            let message = winterHoliday.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Bulgaria\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 600")
        });
        it('should generate package with addedInsurance', function () {
            springHoliday.addVacationer("Nino Bonev");
            springHoliday.insuranceIncluded = false;
            let message = springHoliday.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Scotland\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 400")
        });
        it('should generate package with addedInsurance', function () {
            springHoliday.addVacationer("Nino Bonev");
            springHoliday.insuranceIncluded = true;
            let message = springHoliday.generateHolidayPackage();
            expect(message).to.be.equal("Holiday Package Generated\n" +
                "Destination: Scotland\n" +
                "Vacationers:\n" +
                "Nino Bonev\n" +
                "Price: 500")
        });
    });
    describe("Testing class functionality with incorrect values", function () {
        it('should throw name error', function () {
            expect(() => holidayPackage.destination = 123).to.be.throw;
        });
        it('should throw name error', function () {
            expect(() => holidayPackage.destination = '').to.be.throw;
        });
        it('should throw name error', function () {
            expect(() => holidayPackage.season = 123).to.be.throw;
        });
        it('should throw name error', function () {
            expect(() => holidayPackage.season = '').to.be.throw;
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer("Nino")).to.throw(Error, "Name must consist of first name and last name");
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer("Nino Ivanov Bonev")).to.throw(Error, "Name must consist of first name and last name");
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer("Nino  ")).to.throw(Error, "Name must consist of first name and last name");
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer("Nino", 123)).to.throw(Error, "Name must consist of first name and last name")
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer(" ")).to.throw(Error, "Vacationer name must be a non-empty string");
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer(123)).to.throw(Error, "Vacationer name must be a non-empty string");
        });
        it('should throw name error', function () {
            expect(holidayPackage.vacationers.length).to.be.equal(0);
            expect(() => holidayPackage.addVacationer(["Nino"])).to.throw(Error, "Vacationer name must be a non-empty string");
        });
        it('should throw error on insurance set', function () {
            expect(() => holidayPackage.insuranceIncluded = 123).to.throw(Error, "Insurance status must be a boolean");
            expect(() => holidayPackage.insuranceIncluded = "true").to.throw(Error, "Insurance status must be a boolean");
        });
        it('should not generateHoliday', function () {
            expect(() => holidayPackage.generateHolidayPackage()).to.throw(Error, "There must be at least 1 vacationer added")
        });
        it('should remove the strings after divide', function () {

        });
    });
});