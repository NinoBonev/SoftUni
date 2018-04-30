const mongoose = require('mongoose');

let productSchema = mongoose.Schema({
    name: {type: String, required: true},
    priority: {type: Number, required: true},
    quantity: {type: Number, required: true},
    status: {type: String, required: true}
});

let Product = mongoose.model('Product', productSchema);

module.exports = Product;