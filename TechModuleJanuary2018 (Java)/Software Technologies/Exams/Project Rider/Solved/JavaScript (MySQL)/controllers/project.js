const Project = require('../models').Project;

module.exports = {
    index: (req, res) => {
        Project.findAll().then(projects => {
            res.render('project/index', {'projects': projects});
        });

    },
    createGet: (req, res) => {
        res.render('project/create');
    },
    createPost: (req, res) => {
        let args = req.body.project;
        console.log(args);
        Project.create(args).then(()=>{
            res.redirect("/");
        })
    },
    editGet: (req, res) => {
        Project.findById(req.params.id).then(project => {
            res.render('project/edit', {'project':project});
        });

    },

    editPost: (req, res) => {
        let id = req.params.id;
        let args = req.body.project;
        Project.findById(id).then(project=> {
            project.updateAttributes(args).then(()=>{
                res.redirect('/');
            });
        })
    },

    deleteGet: (req, res) => {
        Project.findById(req.params.id).then(project => {
            res.render('project/delete', {'project':project});
        }).catch(err => {
            console.log(err);
            return res.redirect('/')
        });
    },
    deletePost: (req, res) => {
        Project.findById(req.params.id).then(project => {
            project.destroy().then(() => {
                res.redirect('/');
            });
        }).catch(err => {
            console.log(err);
            return res.redirect('/');
        });
    }
};