package com.exemplo.api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public List<Livro> getLivros() {
        return Arrays.asList(
                new Livro(1, "Livro A", "Autor 1", "Editora 1", 100),
                new Livro(2, "Livro B", "Autor 2", "Editora 2", 200),
                new Livro(3, "Livro C", "Autor 3", "Editora 3", 300)
        );
    }

    @PostMapping
    public void addLivro(@RequestBody Livro livro) {
        System.out.println(livro);
    }

    static class Livro {
        public int id;
        public String titulo;
        public String autor;
        public String editora;
        public int paginas;

        public Livro(int id, String titulo, String autor, String editora, int paginas) {
            this.id = id;
            this.titulo = titulo;
            this.autor = autor;
            this.editora = editora;
            this.paginas = paginas;
        }

        @Override
        public String toString() {
            return "Livro{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", editora='" + editora + '\'' +
                    ", paginas=" + paginas +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getEditora() {
            return editora;
        }

        public void setEditora(String editora) {
            this.editora = editora;
        }

        public int getPaginas() {
            return paginas;
        }

        public void setPaginas(int paginas) {
            this.paginas = paginas;
        }
    }
}
