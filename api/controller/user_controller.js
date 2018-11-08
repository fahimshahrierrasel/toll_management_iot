const User = require('../models/user')

exports.getUser = (req, res) => {
    let params = req.params;
    User.getUser(params.id, (error, result) => {
        if (error) {
            res.status(500).end()
        }
        if(result.length <= 0)
            res.status(404).end()
        res.send(JSON.stringify(result[0]))
    })
}