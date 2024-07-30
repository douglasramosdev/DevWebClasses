const express = require('express');
const router = express.Router();
const { createProduct, getAllProducts } = require('../controllers/productController');

// Rota para criar novo produto
router.post('/', createProduct);

// Rota para obter todos os produtos
router.get('/', getAllProducts);

module.exports = router;
