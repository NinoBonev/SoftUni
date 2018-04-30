const Article = require('../models').Article;
const User = require('../models').User;

module.exports = {
    createGet: (req, res) => {
        res.render("article/create");
    },

    createPost: (req, res) => {
        const title = req.body.title;
        const content = req.body.content;
        const pictureUrl = req.body.pictureUrl;
        const summary = req.body.summary;

        let errorMsg = false;

        if (!req.isAuthenticated()) {
            errorMsg = 'You must be logged in before creating articles'
        } else if (!title) {
            errorMsg = 'Title cannot be empty!'
        } else if (!content) {
            errorMsg = 'Content cannot be empty!'
        }

        if (errorMsg) {
            res.render('article/create', {error: errorMsg});
            return;
        }

        const authorId = req.user.id;

        const article = {
            title,
            pictureUrl,
            content,
            summary,
            authorId
        };

        Article.create(article).then(article => {
            res.redirect('/')
        }).catch(e => {
            console.log(e.message);
            res.render('article/create', {error: e.message});
        })
    },

    details: (req, res) => {
        const id = Number(req.params.id);

        Article.findById(
            id,
            {
                include: [{
                    model: User
                }]
            }).then(article => {
            res.render('article/details', article.dataValues)
        });
    }
};