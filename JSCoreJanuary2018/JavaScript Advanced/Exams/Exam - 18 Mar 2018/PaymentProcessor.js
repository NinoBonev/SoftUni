class PaymentProcessor {

    constructor(obj) {
        this.payments = new Map()
        this.options = {
            types: ["service", "product", "other"],
            precision: 2
        };
        if (obj !== undefined) {
            this.setOptions(obj)
        }
    }

    setTypes(obj) {
        this.options.types = [];
        for (let type of obj.types) {
            if (typeof type !== 'string' || type === undefined){
                throw new Error("invalid type")
            }
            this.options.types.push(type)
        }
    }

    registerPayment(id, name, type, value) {
        if (name === undefined || id === undefined
        || name === "" || id === "") {
            throw new Error('invalid format')
        }
        if (typeof type !== 'string' || type === undefined){
            throw new Error("invalid type")
        }
        if (typeof value !== 'number' || value === undefined) {
            throw new Error("invalid value")
        }
        let hasType = true;
        for (let currentType of this.options.types) {
            if (currentType === type){
                hasType = false;
                break;
            }
        }
        if (hasType){
            throw new Error("invalid type")
        }
        if (this.payments.has(id)){
            throw new Error('Invalid id')
        }
        let payment = {
            id: id,
            name: name,
            type: type,
            value: value
        };
        this.payments.set(id, payment);
    }

    setOptions(obj) {
        if (obj.hasOwnProperty('types')) {
            this.setTypes(obj)
        }
        if (obj.hasOwnProperty('precision')) {
            if (typeof obj.precision !== 'number'){
                throw new Error('invalid number')
            }
            this.options.precision = obj.precision;
        }
    }

    get(id){
        if (!this.payments.has(id)){
            throw new Error('ID not found');
        }
        let payment = this.payments.get(id);
        return `Details about payment ID: ${payment.id}\n- Name: ${payment.name}\n- Type: ${payment.type}\n- Value: ${Number(payment.value).toFixed(this.options.precision)}`;
    }

    deletePayment(id){
        if (!this.payments.has(id)){
            throw new Error('ID not found');
        }
        this.payments.delete(id);
    }

    getBalance(){
        let balance = 0;
        for (let [id, payment] of this.payments) {
            balance += payment.value;
        }
        return balance;
    }

    toString(){
        return `Summary:\n- Payments: ${this.payments.size}\n- Balance: ${Number(this.getBalance()).toFixed(this.options.precision)}`;
    }
}

// Initialize processor with default options
const generalPayments = new PaymentProcessor();
generalPayments.registerPayment('0001', 'Microchips', 'product', 15000);
generalPayments.registerPayment('01A3', 'Biopolymer', 'product', 23000);
console.log(generalPayments.toString());

// // Should throw an error (invalid type)
// generalPayments.registerPayment('E028', 'Rare-earth elements', 'materials', 8000);
//
generalPayments.setOptions({types: ['product', 'material']});
generalPayments.registerPayment('E028', 'Rare-earth elements', 'material', 8000);
console.log(generalPayments.get('E028'));
generalPayments.registerPayment('CF15', 'Enzymes', 'material', 55000);
//
// // Should throw an error (ID not found)
// generalPayments.deletePayment('E027');
// // Should throw an error (ID not found)
// generalPayments.get('E027');
//
generalPayments.deletePayment('E028');
console.log(generalPayments.toString());
//
// Initialize processor with custom types
const servicePyaments = new PaymentProcessor({types: ['service']});
servicePyaments.registerPayment('01', 'HR Consultation', 'service', 3000);
servicePyaments.registerPayment('02', 'Discount', 'service', -1500);
console.log(servicePyaments.toString());
//
// Initialize processor with custom precision
const transactionLog = new PaymentProcessor({precision: 5});
transactionLog.registerPayment('b5af2d02-327e-4cbf', 'Interest', 'other', 0.00153);
console.log(transactionLog.toString());
