package br.edu.atitus.bibliodigital.services;

import br.edu.atitus.bibliodigital.entities.Livro;
import br.edu.atitus.bibliodigital.repositories.LivroRepository;

import java.util.List;

public class LivroService {
    private final LivroRepository repository = new LivroRepository();


    public void inserir(Livro Livro){
        if (Livro == null)
            throw new RuntimeException("Objeto Nulo");

        if (Livro.getTitulo() == null || Livro.getTitulo().isBlank())
            throw new RuntimeException("Titulo Inválido");
        Livro.setTitulo(Livro.getTitulo().trim());
        if (repository.existeTitulo(Livro.getTitulo())) {
            throw new RuntimeException("Titulo ja existente");
        }

        if (Livro.getAutor() == null || Livro.getAutor().isBlank())
            throw new RuntimeException("Autor Inválido");
        Livro.setAutor(Livro.getAutor().trim());


        if (Livro.getAnoPublicacao() < 1900) {
        throw new RuntimeException("Ano de publicação inválido");
        }



        repository.inserir(Livro);


    }

    public List<Livro> findAll(){
        return repository.findAll();
    }

    public List<Livro> findByTitulo(String parametro){
        if (parametro == null || parametro.isBlank())
            throw new RuntimeException("Parametro Invalido");
        return repository.findByTitulo(parametro);
    }

    public List<Livro> findByAutor(String parametro){
        if (parametro == null || parametro.isBlank())
            throw new RuntimeException("Parametro Invalido");
        return repository.findByAutor(parametro);
    }

}
