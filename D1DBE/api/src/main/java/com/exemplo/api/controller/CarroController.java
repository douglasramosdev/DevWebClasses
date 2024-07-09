package com.exemplo.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @GetMapping
    public List<Carro> getCarros() {
        return Arrays.asList(
                new Carro(1, "Carro A", "Marca 1", 2020, 30000),
                new Carro(2, "Carro B", "Marca 2", 2021, 40000),
                new Carro(3, "Carro C", "Marca 3", 2022, 50000)
        );
    }

    @PostMapping
    public void addCarro(@RequestBody Carro carro) {
        System.out.println(carro);
    }

    static class Carro {
        public int id;
        public String modelo;
        public String marca;
        public int ano;
        public double preco;

        public Carro(int id, String modelo, String marca, int ano, double preco) {
            this.id = id;
            this.modelo = modelo;
            this.marca = marca;
            this.ano = ano;
            this.preco = preco;
        }

        @Override
        public String toString() {
            return "Carro{" +
                    "id=" + id +
                    ", modelo='" + modelo + '\'' +
                    ", marca='" + marca + '\'' +
                    ", ano=" + ano +
                    ", preco=" + preco +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }
}
