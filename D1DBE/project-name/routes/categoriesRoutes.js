// routes/categoriesRoutes.js

const express = require('express');
const router = express.Router();
const { listCategories, getCategoryById, createCategory, updateCategory, deleteCategory } = require('../controllers/categoryController');

// Listar todas as categorias
router.get('/', listCategories);

// Obter uma categoria pelo ID
router.get('/:id', getCategoryById);

// Criar uma nova categoria
router.post('/', createCategory);

// Atualizar uma categoria pelo ID
router.put('/:id', updateCategory);

// Deletar uma categoria pelo ID
router.delete('/:id', deleteCategory);

module.exports = router;
