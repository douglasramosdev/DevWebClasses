package com.exemplo.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public List<Produto> getProdutos() {
        return Arrays.asList(
                new Produto(1, "Produto A", "Categoria 1", 100.0, 10),
                new Produto(2, "Produto B", "Categoria 2", 200.0, 20),
                new Produto(3, "Produto C", "Categoria 3", 300.0, 30)
        );
    }

    @PostMapping
    public void addProduto(@RequestBody Produto produto) {
        System.out.println(produto);
    }

    static class Produto {
        public int id;
        public String nome;
        public String categoria;
        public double preco;
        public int quantidade;

        public Produto(int id, String nome, String categoria, double preco, int quantidade) {
            this.id = id;
            this.nome = nome;
            this.categoria = categoria;
            this.preco = preco;
            this.quantidade = quantidade;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
        @Override
        public String toString() {
            return "Produto{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", categoria='" + categoria + '\'' +
                    ", preco=" + preco +
                    ", quantidade=" + quantidade +
                    '}';
        }
    }
}
