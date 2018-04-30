const Sequelize = require('sequelize');

module.exports = function (sequelize) {
    let Baby = sequelize.define('Baby', {
        name: Sequelize.STRING,
        // TODO FIXME
    });

    return Baby;
};