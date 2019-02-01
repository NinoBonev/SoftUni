const Cube = require('../models/CubeSchema').model('Cube')

function handleErrors(name, from, to) {
    let errors = [];
    if (from < 1 || from > 6) {
        errors.push('From must be between 1 and 6')
    }
    if (to < 1 || to > 6) {
        errors.push('To must be between 1 and 6')
    }
    if (from > to) {
        errors.push('From value must be than than to value')
    }

    if (!name || !from || !to) {
        errors.push('You must fill all the fields');
    }

    return errors;
}

module.exports = {
    homeGet: (req, res) => {
        Cube.find({})
            .select('_id name imageUrl difficulty')
            .then((cubes) => {
                res.render('index', {cubes})
            }).catch((e) => console.log(e))
    },
    about: (req, res) => {
        res.render('about')
    },
    search: async (req, res) => {
        const query = req.query;
        let from = Number(query.from);
        let to = Number(query.to);
        let name = query.name;

        let errors = handleErrors(name, from, to);

        if (errors.length > 0) {
            res.locals.globalErrors = handleErrors(name, from, to);

            try {
                const Cubes = await Cube.find({})
                res.render('index', {cubes: Cubes})

            } catch(e){
                console.log(e);
            }
        } else {
            Cube.find({})
                .where('difficulty')
                .gte(from)
                .lte(to)
                .then((cubes) => {
                    const filtered = cubes.filter((c) => c.name.toLowerCase().includes(name.toLowerCase()));

                    res.render('index', {cubes: filtered})
                })
        }
    }
}