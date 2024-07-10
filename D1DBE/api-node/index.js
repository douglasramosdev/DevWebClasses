const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

app.use(bodyParser.json());

const produtos = [
    { id: 1, nome: "Produto A", categoria: "Categoria 1", preco: 100.00, estoque: 50 },
    { id: 2, nome: "Produto B", categoria: "Categoria 2", preco: 200.00, estoque: 30 },
    { id: 3, nome: "Produto C", categoria: "Categoria 3", preco: 300.00, estoque: 20 }
];

const livros = [
    { id: 1, titulo: "Livro A", autor: "Autor 1", ano: 2001, paginas: 300 },
    { id: 2, titulo: "Livro B", autor: "Autor 2", ano: 2002, paginas: 350 },
    { id: 3, titulo: "Livro C", autor: "Autor 3", ano: 2003, paginas: 400 }
];

const clientes = [
    { id: 1, nome: "Cliente A", email: "clienteA@example.com", idade: 30, cidade: "Cidade 1" },
    { id: 2, nome: "Cliente B", email: "clienteB@example.com", idade: 40, cidade: "Cidade 2" },
    { id: 3, nome: "Cliente C", email: "clienteC@example.com", idade: 50, cidade: "Cidade 3" }
];

const carros = [
    { id: 1, modelo: "Carro A", marca: "Marca 1", ano: 2020, preco: 30000 },
    { id: 2, modelo: "Carro B", marca: "Marca 2", ano: 2021, preco: 40000 },
    { id: 3, modelo: "Carro C", marca: "Marca 3", ano: 2022, preco: 50000 }
];

const pedidos = [
    { id: 1, cliente: "Cliente A", produto: "Produto A", quantidade: 2, total: 200.00 },
    { id: 2, cliente: "Cliente B", produto: "Produto B", quantidade: 1, total: 200.00 },
    { id: 3, cliente: "Cliente C", produto: "Produto C", quantidade: 3, total: 900.00 }
];

app.get('/produtos', (req, res) => {
    res.json(produtos);
});

app.post('/produtos', (req, res) => {
    console.log("Recebendo requisição POST com dados do produto:");
    console.log(req.body);
    res.status(201).send();
});

app.get('/livros', (req, res) => {
    res.json(livros);
});

app.post('/livros', (req, res) => {
    console.log("Recebendo requisição POST com dados do livro:");
    console.log(req.body);
    res.status(201).send();
});

app.get('/clientes', (req, res) => {
    res.json(clientes);
});

app.post('/clientes', (req, res) => {
    console.log("Recebendo requisição POST com dados do cliente:");
    console.log(req.body);
    res.status(201).send();
});

app.get('/carros', (req, res) => {
    res.json(carros);
});

app.post('/carros', (req, res) => {
    console.log("Recebendo requisição POST com dados do carro:");
    console.log(req.body);
    res.status(201).send();
});

app.get('/pedidos', (req, res) => {
    res.json(pedidos);
});

app.post('/pedidos', (req, res) => {
    console.log("Recebendo requisição POST com dados do pedido:");
    console.log(req.body);
    res.status(201).send();
});

app.listen(port, () => {
    console.log(`API rodando em http://localhost:${port}`);
});
