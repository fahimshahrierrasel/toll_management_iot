const Driver = require('../models/driver')

exports.getDriver = (req, res) => {
    let params = req.params;
    Driver.getDriver(params.id, (error, result) => {
        if (error) {
            res.status(500).end()
        }
        if(result.length <= 0)
            res.status(404).end()
        res.send(JSON.stringify(result[0]))
    })
}