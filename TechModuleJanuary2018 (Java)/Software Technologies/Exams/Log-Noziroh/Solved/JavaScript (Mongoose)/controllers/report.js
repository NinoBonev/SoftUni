const Report = require('../models/Report');

module.exports = {
    index: (req, res) => {
        Report.find().then(reports => {
                res.render('report/index', {'reports': reports});
            });
    },
    createGet: (req, res) => {
        res.render('report/create');
    },
    createPost: (req, res) => {
        let report = req.body;

        if (!report.origin || !report.message || !report.status) {
            return res.redirect('/create')
        }

        Report.create(report).then(report => {
            res.redirect('/');
        });

    },
    detailsGet: (req, res) => {
        Report.findById(req.params.id).then(report => {
            res.render('report/details', report);
        });
    },
    deleteGet: (req, res) => {
        Report.findById(req.params.id).then(report => {
            res.render('report/delete', report);
        }).catch(err => {
            console.log(err);
            return res.redirect('/')
        });

    },
    deletePost: (req, res) => {
        Report.findByIdAndRemove(req.params.id).then(report => {
            res.redirect('/');
        }).catch(err => {
            console.log(err);
            return res.redirect('/');
        });

    }
};