const encryption = require('../util/encryption');
const User = require('../models/User');

module.exports = {
    registerGet: (req, res) => {
        res.render('user/register')
    },
    registerPost: async (req, res) => {
       const userBody = req.body;

       if (!userBody.password || !userBody.repeatPassword || !userBody.username) {
           userBody.error = 'Please feel all required fields';
           res.render('user/register', userBody);
           return;
       }

       if (userBody.password !== userBody.repeatPassword){
           userBody.error = 'Both passwords should match';
           res.render('user/register', userBody);
           return;
       }

       const salt = encryption.generateSalt();
       const hashedPass = encryption.generateHashedPassword(salt, userBody.password);


       try {
           const user = await User.create({
               username: userBody.username,
               hashedPass,
               firstName: userBody.firstName,
               lastName: userBody.lastName,
               salt,
               roles: ['User']
           });

           req.logIn(user, (err) => {
               if (err) {
                   userBody.error = err;
                   res.render('user/register', userBody);
               } else {
                   res.redirect("/")
               }
           })
       } catch (err) {
           console.error(err);
       }
    },
    logout: (req, res) => {
        req.logout();
        res.redirect('/')
    },
    loginGet: (req, res) => {
        res.render('user/login')
    },
    loginPost: async (req, res) => {
        const userBody = req.body;

        try {
            const user = await User.findOne({username: userBody.username})
            
            if (!user){
                userBody.error = 'Invalid username';
                res.render('user/login', userBody);
                return;
            }

            if (!user.authenticate(userBody.password)){
                userBody.error = 'Invalid password';
                res.render('user/login', userBody);
                return;
            }

            req.logIn(user, (err) => {
                if (err) {
                    userBody.error = err;
                    res.render('user/login', userBody);
                } else {
                    res.redirect("/")
                }
            })

        } catch (err) {
            userBody.error = 'Someting went wrong'
            console.error(err);
        }
    },
    myRents: (req, resp) => {

    }
};