// controllers/orderController.js

const Order = require('../models/Order');

// Listar todos os pedidos
exports.listOrders = async (req, res) => {
  try {
    const orders = await Order.findAll();
    res.json(orders);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao listar pedidos' });
  }
};

// Obter um pedido pelo ID
exports.getOrderById = async (req, res) => {
  const { id } = req.params;
  try {
    const order = await Order.findByPk(id);
    if (!order) {
      return res.status(404).json({ message: 'Pedido não encontrado' });
    }
    res.json(order);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao obter pedido' });
  }
};

// Criar um novo pedido
exports.createOrder = async (req, res) => {
  try {
    const order = await Order.create(req.body);
    res.status(201).json(order);
  } catch (error) {
    res.status(500).json({ message: 'Erro ao criar pedido' });
  }
};

// Atualizar um pedido pelo ID
exports.updateOrder = async (req, res) => {
  const { id } = req.params;
  try {
    const [updated] = await Order.update(req.body, { where: { id } });
    if (!updated) {
      return res.status(404).json({ message: 'Pedido não encontrado' });
    }
    res.json({ message: 'Pedido atualizado com sucesso' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao atualizar pedido' });
  }
};

// Deletar um pedido pelo ID
exports.deleteOrder = async (req, res) => {
  const { id } = req.params;
  try {
    const deleted = await Order.destroy({ where: { id } });
    if (!deleted) {
      return res.status(404).json({ message: 'Pedido não encontrado' });
    }
    res.json({ message: 'Pedido deletado com sucesso' });
  } catch (error) {
    res.status(500).json({ message: 'Erro ao deletar pedido' });
  }
};
