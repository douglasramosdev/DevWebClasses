// controllers/categoryController.js

const Category = require('../models/Category');

// Listar todas as categorias
exports.listCategories = async (req, res) => {
  try {
    const categories = await Category.findAll();
    res.json(categories);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao listar categorias' });
  }
};

// Obter uma categoria pelo ID
exports.getCategoryById = async (req, res) => {
  const { id } = req.params;
  try {
    const category = await Category.findByPk(id);
    if (!category) {
      return res.status(404).json({ message: 'Categoria não encontrada' });
    }
    res.json(category);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao obter categoria' });
  }
};

// Criar uma nova categoria
exports.createCategory = async (req, res) => {
  try {
    const category = await Category.create(req.body);
    res.status(201).json(category);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao criar categoria' });
  }
};

// Atualizar uma categoria pelo ID
exports.updateCategory = async (req, res) => {
  const { id } = req.params;
  try {
    const [updated] = await Category.update(req.body, { where: { id } });
    if (!updated) {
      return res.status(404).json({ message: 'Categoria não encontrada' });
    }
    res.json({ message: 'Categoria atualizada com sucesso' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao atualizar categoria' });
  }
};

// Deletar uma categoria pelo ID
exports.deleteCategory = async (req, res) => {
  const { id } = req.params;
  try {
    const deleted = await Category.destroy({ where: { id } });
    if (!deleted) {
      return res.status(404).json({ message: 'Categoria não encontrada' });
    }
    res.json({ message: 'Categoria deletada com sucesso' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao deletar categoria' });
  }
};
