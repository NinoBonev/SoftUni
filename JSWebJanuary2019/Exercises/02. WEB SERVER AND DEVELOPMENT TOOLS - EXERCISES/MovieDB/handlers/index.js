const homeHandler = require("./home-handler");
const staticFileHandler = require("./static-file-handler");
const movieHandler = require("./movie-handler");
const errorHandler = require("./errorHandler");

module.exports = [homeHandler, staticFileHandler, movieHandler, errorHandler];