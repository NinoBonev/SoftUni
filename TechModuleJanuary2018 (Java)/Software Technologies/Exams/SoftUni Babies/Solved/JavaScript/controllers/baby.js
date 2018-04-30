const Baby = require('../models').Baby;

module.exports = {
    index: (req, res) => {
        Baby.findAll().then(babies => {
            res.render('baby/index', {'babies': babies});
        });
    },

    createGet: (req, res) => {
        res.render('baby/create');
    },

    createPost: (req, res) => {
        let args = req.body.baby;
        console.log(args);
        Baby.create(args).then(()=>{
            res.redirect("/");
        })
    },

    editGet: (req, res) => {
        Baby.findById(req.params.id).then(baby => {
            res.render('baby/edit', {'baby':baby});
        });
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let args = req.body.baby;
        Baby.findById(id).then(baby => {
            baby.updateAttributes(args).then(()=>{
                res.redirect('/');
            });
        })
    },

    deleteGet: (req, res) => {
        Baby.findById(req.params.id).then(baby => {
            res.render('baby/delete', {'baby':baby});
        }).catch(err => {
            console.log(err);
            return res.redirect('/')
        });

    },

    deletePost: (req, res) => {
        Baby.findById(req.params.id).then(baby => {
            baby.destroy().then(() => {
                res.redirect('/');
            });
        }).catch(err => {
            console.log(err);
            return res.redirect('/');
        });
    }
};