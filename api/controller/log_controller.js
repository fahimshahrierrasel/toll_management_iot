const Log = require('../models/log')

exports.getCarTollLogs = (req, res) => {
    let params = req.params;
    Log.getCarTollLogs(params.id, (error, result) => {
        if (error) {
            res.status(500).end()
        }
        if(result.length <= 0)
            res.status(404).end()
        res.send(JSON.stringify(result))
    })
}

exports.getDriverTollLogs = (req, res) => {
    let params = req.params;
    Log.getDriverTollLogs(params.id, (error, result) => {
        if (error) {
            res.status(500).end()
        }
        if(result.length <= 0)
            res.status(404).end()
        res.send(JSON.stringify(result))
    })
}