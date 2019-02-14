const mongoose = require('mongoose');
const Car = require('./Car');

const rentSchema = new mongoose.Schema({
    days: {type: mongoose.Schema.Types.Number, required: true},
    car: {type: mongoose.Schema.Types.ObjectId, required: true, ref: 'Car'},
    owner: {type: mongoose.Schema.Types.ObjectId, required: true, ref: 'User'}
})

const Rent = mongoose.model('Rent', rentSchema);
module.exports = Rent;