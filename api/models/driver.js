const db = require('../db')

function response(error, res, callback) {
    if (error) {
        console.log("Query Error: ", error);
        callback(error, null);
    } else {
        callback(null, res);
    }
}

exports.getDriver = (id, callback) => {
    db.query("SELECT id, name, license_no, address, balance FROM Driver WHERE id = ?", [id], (error, res) => {
        response(error, res, callback)
    })
}