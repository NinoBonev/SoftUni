const mongoose = require('mongoose');

const tagSchema = new mongoose.Schema({
    tagName: {type: mongoose.SchemaTypes.String, required: true},
    creationDate: {type: mongoose.SchemaTypes.Date, required: true, default: Date.now},
    images: [{type: mongoose.SchemaTypes.ObjectId}]
});

module.exports = mongoose.model('Tag', tagSchema);