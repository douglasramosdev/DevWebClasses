const express = require('express');
const router = express.Router();
const { createUser, getAllUsers } = require('../controllers/userController');

// Rota para criar novo usuário
router.post('/', createUser);

// Rota para obter todos os usuários
router.get('/', getAllUsers);

module.exports = router;
