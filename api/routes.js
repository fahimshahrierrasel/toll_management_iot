const authController = require('./controller/auth_controller')
const userController = require('./controller/user_controller')

const router = (app) => {
    app.post('/login', authController.login)
    app.get('/user/:id', userController.getUser)
}

module.exports = router