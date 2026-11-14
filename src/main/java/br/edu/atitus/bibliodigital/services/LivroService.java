package br.edu.atitus.bibliodigital.services;

import br.edu.atitus.bibliodigital.entities.Livro;
import br.edu.atitus.bibliodigital.repositories.LivroRepository;

import java.util.List;

public class LivroService {
    private final LivroRepository repository = new LivroRepository();


    public void inserir(Livro Livro){
        if (Livro == null)
            throw new RuntimeException("Objeto Nulo");

        validarDados(Livro.getTitulo(), Livro.getAutor(), Livro.getAnoPublicacao());
        Livro.setTitulo(Livro.getTitulo().trim());
        if (repository.existeTitulo(Livro.getTitulo())) {
            throw new RuntimeException("Titulo ja existente");
        }
        Livro.setAutor(Livro.getAutor().trim());




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

    public Livro findByIndice (int indice){
        int totalLivros = repository.findAll().size();

        if (indice < 1 || indice  > totalLivros)
            throw new RuntimeException("Indice invalido");
        return repository.findByIndice(indice - 1);
    }

    public void alterar(int indice, String novoTitulo, String novoAutor, int novoAnoPublicacao) {
        Livro escolhido = findByIndice(indice);
        validarDados(novoTitulo, novoAutor, novoAnoPublicacao);
        novoTitulo = novoTitulo.trim();
        novoAutor = novoAutor.trim();

        for (Livro outroLivro : repository.findAll()) {
            if (outroLivro == escolhido)
                continue;

            if (novoTitulo.equalsIgnoreCase(outroLivro.getTitulo())) {
                throw new RuntimeException("Titulo ja existente");
            }

        }

        escolhido.setTitulo(novoTitulo);
        escolhido.setAutor(novoAutor);
        escolhido.setAnoPublicacao(novoAnoPublicacao);
        repository.alterar(indice - 1, escolhido);

    }


    public void remover(int indice){
        int totalLivros = repository.findAll().size();

        if (indice < 1 || indice  > totalLivros)
            throw new RuntimeException("Indice invalido");
        repository.remover(indice - 1);
    }

    private void validarDados (String titulo, String autor, int anoPublicacao){

        if (titulo == null || titulo.isBlank())
            throw new RuntimeException("Titulo Invalido");
        if (autor == null || autor.isBlank())
            throw new RuntimeException("Autor Invalido");
        if (anoPublicacao < 1900)
            throw  new RuntimeException("Ano inválido");

    }

}
