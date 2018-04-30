const Sequelize = require('sequelize');

module.exports = function (sequelize) {
    let Baby = sequelize.define('Baby', {
        name:{
            type: Sequelize.TEXT,
            required: true,
            allowNull: false,
        },
        gender:{
            type: Sequelize.TEXT,
            required: true,
            allowNull: false,
        },
        birthday:{
            type: Sequelize.TEXT,
            required: true,
            allowNull: false,
        }
    },{
        timestamps:false
    });

    return Baby;
};