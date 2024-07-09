package com.exemplo.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> getClientes() {
        return Arrays.asList(
                new Cliente(1, "João", "joao@gmail.com", "123456789", "Rua A"),
                new Cliente(2, "Maria", "maria@gmail.com", "987654321", "Rua B"),
                new Cliente(3, "José", "jose@gmail.com", "456123789", "Rua C")
        );
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente) {
        System.out.println(cliente);
    }

    static class Cliente {
        public int id;
        public String nome;
        public String email;
        public String telefone;
        public String endereco;

        public Cliente(int id, String nome, String email, String telefone, String endereco) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", email='" + email + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", endereco='" + endereco + '\'' +
                    '}';
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
    }
}

