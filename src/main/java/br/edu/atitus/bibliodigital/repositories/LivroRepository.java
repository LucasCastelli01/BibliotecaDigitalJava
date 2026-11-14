package br.edu.atitus.bibliodigital.repositories;

import br.edu.atitus.bibliodigital.entities.Livro;

import java.util.ArrayList;
import java.util.List;


public class LivroRepository {
    private List<Livro> acervo = new ArrayList<>();

    public List<Livro> findAll() {
        return acervo;
    }

    public void inserir(Livro Livro) {
        acervo.add(Livro);
    }

    public List<Livro> findByTitulo(String parametro){
            List<Livro> resultado = new ArrayList<>();
        for (Livro livro :acervo){
               if (livro.getTitulo().toUpperCase().contains(parametro.toUpperCase())){
                    resultado.add(livro);
            }
        }
        return resultado;

    }

    public List <Livro> findByAutor(String parametro) {
            List<Livro> resultadoAutor = new ArrayList<>();
        for (Livro livro: acervo){
                if (livro.getAutor().toUpperCase().contains(parametro.toUpperCase())){
                  resultadoAutor.add(livro);
            }
        }
        return resultadoAutor;


    }

    public boolean existeTitulo(String titulo){
        for (Livro livro: acervo){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        return false;

    }
}
