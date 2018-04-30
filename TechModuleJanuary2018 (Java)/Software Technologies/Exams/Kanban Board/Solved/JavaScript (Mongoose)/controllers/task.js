const Task = require('../models/Task');

module.exports = {
	index: (req, res) => {
		Task.find().then(tasks => {
            res.render('task/index', {
                'openTasks': tasks.filter(t => t.status === 'Open'),
                'inProgressTasks': tasks.filter(t => t.status === 'In Progress'),
                'finishedTasks': tasks.filter(t => t.status === 'Finished'),
            });
        })
    },
	createGet: (req, res) => {
        res.render('task/create');
    },
	createPost: (req, res) => {
        let task = req.body;

        if (!task.title || !task.status) {
            return res.redirect('/create')
        }

        Task.create(task).then(task => {
            res.redirect('/');
        });

    },
	editGet: (req, res) => {
        Task.findById(req.params.id).then(task => {
            res.render('task/edit', task);
        });
    },
	editPost: (req, res) => {
        let task = req.body;
        let id = req.params.id;

        Task.findByIdAndUpdate(id, task).then(task => {
            res.redirect('/')
        })
    }
};