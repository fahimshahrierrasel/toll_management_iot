const authController = require('./controller/auth_controller')
const userController = require('./controller/user_controller')
const carController = require('./controller/car_controller')

const router = (app) => {
    app.post('/login', authController.login)
    app.get('/user/:id', userController.getUser)
    app.get('/user/:id/cars', carController.getDriverCars)
}

module.exports = router