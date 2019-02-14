const Cube = require('../models/CubeSchema').model('Cube')

function handleError(err, res, cubeBody) {
    let errors = [];

    for (const prop in err.errors) {
        errors.push(err.errors[prop].message);
    }

    res.locals.globalErrors = errors;
    res.render('cube/create', cubeBody)
}

module.exports = {
    createGet : (req, res) => {
        res.render('cube/create')
    },
    createPost: (req, res) => {
        const cubeBody = req.body;
        cubeBody.difficulty = Number(cubeBody.difficulty);

        Cube.create(cubeBody)
            .then((c) => {
                res.redirect('/')
            })
            .catch((e) => handleError(e, res, cubeBody));
    },
    details: (req, res) => {
        const cubeId = req.params.cubeId;
        const cube = Cube.findById(cubeId);

        Cube.findById(cubeId)
            .then((cube) => {
                console.log(cube);
                res.render('cube/details', cube)
            })
            .catch((e) => console.log(e))

    }
}