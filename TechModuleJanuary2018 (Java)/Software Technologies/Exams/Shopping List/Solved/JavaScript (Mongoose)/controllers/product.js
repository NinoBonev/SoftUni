const Product = require('../models/Product');

module.exports = {
	index: (req, res) => {
        Product.find().then(entries => {
            res.render('product/index', {'entries': entries});
        });
    },
	createGet: (req, res) => {
        res.render('product/create');
	},
	createPost: (req, res) => {
        let product = req.body;

        if (!product.name || !product.priority || !product.quantity || !product.status) {
            return res.redirect('/create')
        }

        Product.create(product).then(product => {
            res.redirect('/');
        });

    },
	editGet: (req, res) => {
        Product.findById(req.params.id).then(product => {
            res.render('product/edit', product);
        });

    },
	editPost: (req, res) => {
        let product = req.body;
        let id = req.params.id;

        Product.findByIdAndUpdate(id, product).then(product => {
            res.redirect('/')
        })

    }
};