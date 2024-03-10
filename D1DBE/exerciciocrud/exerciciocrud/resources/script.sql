-- Active: 1709815321446@@127.0.0.1@3306@crud
CREATE DATABASE crud

CREATE TABLE alunos(
  ra INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(200),
  idade INT,
  endereco VARCHAR(200),
  datamatricula DATE
)

CREATE TABLE professores(
  idProfessor INT PRIMARY KEY AUTO_INCREMENT,
  nomeProfessor VARCHAR(200),
  disciplina VARCHAR(200),
  emailProfessor VARCHAR(200),
  telefoneProfessor VARCHAR(50)
)

CREATE TABLE cursos(
  idCurso INT PRIMARY KEY AUTO_INCREMENT,
  nomeCurso VARCHAR(200),
  descricaoCurso VARCHAR(200),
  dataInicio DATE,
  dataFinal DATE
)


