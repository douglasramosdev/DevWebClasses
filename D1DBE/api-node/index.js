const express = require('express');
const bodyParser = require('body-parser');
const mysql = require('mysql2');
const dotenv = require('dotenv');

dotenv.config();

const app = express();
const port = 3000;

app.use(bodyParser.json());

// Configuração da conexão com o banco de dados
const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password:"0000",
    database:"dbTeste"
});

// Conectar ao banco de dados
db.connect((err) => {
    if (err) {
        console.error('Erro ao conectar ao banco de dados:', err);
        return;
    }
    console.log('Conectado ao banco de dados MySQL');
});

app.get('/', (req, res) => {
    res.send('API Node.js com Express e MySQL');
});

// Endpoints de produtos
app.get('/produtos', (req, res) => {
    const query = 'SELECT * FROM produtos';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Erro ao buscar produtos:', err);
            res.status(500).send('Erro ao buscar produtos');
            return;
        }
        res.json(results);
    });
});

app.post('/produtos', (req, res) => {
    const { nome, categoria, preco, estoque } = req.body;
    const query = 'INSERT INTO produtos (nome, categoria, preco, estoque) VALUES (?, ?, ?, ?)';
    db.query(query, [nome, categoria, preco, estoque], (err, results) => {
        if (err) {
            console.error('Erro ao inserir produto:', err);
            res.status(500).send('Erro ao inserir produto');
            return;
        }
        console.log('Produto inserido:', req.body);
        res.status(201).send('Produto inserido');
    });
});


app.get('/livros', (req, res) => {
    const query = 'SELECT * FROM livros';
    db.query(query, (err, results) => {
        if (err) {
            console.error('Erro ao buscar livros:', err);
            res.status(500).send('Erro ao buscar livros');
            return;
        }
        res.json(results);
    });
});

app.post('/livros', (req, res) => {
    const { titulo, autor, ano, paginas } = req.body;
    const query = 'INSERT INTO livros (titulo, autor, ano, paginas) VALUES (?, ?, ?, ?)';
    db.query(query, [titulo, autor, ano, paginas], (err, results) => {
        if (err) {
            console.error('Erro ao inserir livro:', err);
            res.status(500).send('Erro ao inserir livro');
            return;
        }
        console.log('Livro inserido:', req.body);
        res.status(201).send('Livro inserido');
    });
});

app.listen(port, () => {
    console.log(`API rodando em http://localhost:${port}`);
});
