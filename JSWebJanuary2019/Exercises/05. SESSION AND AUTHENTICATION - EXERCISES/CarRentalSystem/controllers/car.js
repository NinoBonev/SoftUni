const Car = require('../models/Car');
const Rent = require('../models/Rent');

module.exports = {
    viewAllCars: (req, res) => {
        Car.find({isRented: false})
            .then((cars) => {
                res.render('car/all', { cars })
            })
            .catch((err) => {
                console.log(err)
            })
    },
    addCarGet: (req, res) => {
        res.render('car/add')
    },
    addCarPost: async (req, res) => {
        const carBody = req.body;
        carBody.pricePerDay = +carBody.pricePerDay;

        if (!carBody.model || !carBody.image || !carBody.pricePerDay) {
            carBody.error = 'Please feel all required fields';
            res.render('car/add', carBody);
            return;
        }

        try {
            const car = await Car.create(carBody)
                .then(res.redirect('../car/all'))
                .catch((err) => console.log(err));
        } catch (err) {
            carBody.error = 'Something went wrong'
            res.render('car/add', carBody);
        }
    },
    rentCarGet: (req, res) => {
        const carId = req.params.id;

        Car.findById(carId).then((car) => {
            res.render('car/rent', car)
        })
            .catch(console.error);
    },
    rentCarPost: (req, res) => {
        const car = req.params.id;
        const owner = req.user._id;
        const days = Number(req.body.days);

        Rent
            .create({days, car, owner})
            .then(() => {
                Car.findById(car).then((c) => {
                    c.isRented = true;
                    return c.save();

            }).then(() => {
                    res.redirect('/car/all')
                }).catch(console.error)})
            .catch(console.error);
    },
    editCarGet: (req, resp) => {
        res.render('car/edit')
    },
    editCarPost: (req, resp) => {

    }
}