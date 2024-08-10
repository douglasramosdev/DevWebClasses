const express = require('express');
const bodyParser = require('body-parser');
const sequelize = require('./config/database');
const connectDB = require('./config/mongoose');
require('dotenv').config();

// Inicialização do aplicativo Express
const app = express();

// Middlewares
app.use(bodyParser.json()); // Para interpretar requisições com corpo em JSON

// Importar e usar rotas
app.use('/api/users', require('./routes/users'));
app.use('/api/products', require('./routes/products'));
app.use('/api/order', require('./routes/ordersRoutes'));
app.use('/api/catergory', require('./routes/categoriesRoutes'));

// Teste da Conexão com o banco de dados SQL
sequelize.authenticate()
  .then(() => {
    console.log('Conectado ao banco de dados SQL');
    // Sincronizar os modelos com o banco de dados
    sequelize.sync({ force: false })  // Alterar para true se quiser recriar as tabelas a cada inicialização
      .then(() => {
        console.log('Sincronização com o banco de dados concluída.');
      })
      .catch(err => {
        console.error('Erro ao sincronizar com o banco de dados:', err);
      });
  })
  .catch(err => {
    console.error('Não foi possível conectar ao banco de dados SQL:', err);
  });

// Conexão com o MongoDB
connectDB();

// Inicialização do Servidor
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Servidor rodando na porta ${PORT}`);
});
