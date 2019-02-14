const homeController = require('../controllers/homeContoroller');
const cubeController = require('../controllers/cubeController')

module.exports = app => {
    app.get('/', homeController.homeGet);
    app.get('/about', homeController.about);

    app.get('/create', cubeController.createGet);
    app.post('/create', cubeController.createPost);

    app.get('/details/:cubeId', cubeController.details)
    app.get('/search', homeController.search)
};