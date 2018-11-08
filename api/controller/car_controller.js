const Car = require('../models/car')

exports.getDriverCars = (req, res) => {
    let params = req.params;
    Car.getDriverCars(params.id, (error, result) => {
        if (error) {
            res.status(500).end()
        }
        if(result.length <= 0)
            res.status(404).end()
        res.send(JSON.stringify(result))
    })
}