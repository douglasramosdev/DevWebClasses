// routes/ordersRoutes.js

const express = require('express');
const router = express.Router();
const { listOrders, getOrderById, createOrder, updateOrder, deleteOrder } = require('../controllers/orderController');

// Listar todos os pedidos
router.get('/', listOrders);

// Obter um pedido pelo ID
router.get('/:id', getOrderById);

// Criar um novo pedido
router.post('/', createOrder);

// Atualizar um pedido pelo ID
router.put('/:id', updateOrder);

// Deletar um pedido pelo ID
router.delete('/:id', deleteOrder);

module.exports = router;
