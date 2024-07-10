package com.exemplo.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping
    public List<Pedido> getPedidos() {
        return Arrays.asList(
                new Pedido(1, "Cliente A", "Produto A", 2, 200.0),
                new Pedido(2, "Cliente B", "Produto B", 3, 600.0),
                new Pedido(3, "Cliente C", "Produto C", 1, 300.0)
        );
    }

    @PostMapping
    public void addPedido(@RequestBody Pedido pedido) {
        System.out.println(pedido);
    }

    static class Pedido {
        public int id;
        public String cliente;
        public String produto;
        public int quantidade;
        public double total;

        public Pedido(int id, String cliente, String produto, int quantidade, double total) {
            this.id = id;
            this.cliente = cliente;
            this.produto = produto;
            this.quantidade = quantidade;
            this.total = total;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getProduto() {
            return produto;
        }

        public void setProduto(String produto) {
            this.produto = produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
        @Override
        public String toString() {
            return "Pedido{" +
                    "id=" + id +
                    ", cliente='" + cliente + '\'' +
                    ", produto='" + produto + '\'' +
                    ", quantidade=" + quantidade +
                    ", total=" + total +
                    '}';
        }
    }
}
