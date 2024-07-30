const { Product } = require('../models');

// Criar novo produto
const createProduct = async (req, res) => {
  try {
    const { name, price, description } = req.body;
    const newProduct = await Product.create({ name, price, description });
    res.status(201).json(newProduct);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao criar produto', error });
  }
};

// Obter todos os produtos
const getAllProducts = async (req, res) => {
  try {
    const products = await Product.find();
    res.status(200).json(products);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao obter produtos', error });
  }
};

module.exports = {
  createProduct,
  getAllProducts,
};
