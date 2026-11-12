package br.edu.atitus.bibliodigital.entities;

public abstract class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private static final int anoPublicacaoMinimo = 1450;


    //metodo construtor
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }   

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao < anoPublicacaoMinimo)
            return;
        this.anoPublicacao = anoPublicacao;

    }

    public abstract String getTipo();


    @Override 
    public String toString() {
        return "Titulo %s - Autor %s - Ano de publicação %d".formatted(titulo, autor, anoPublicacao);
    }

    public final int calcularIdade(){
        return java.time.Year.now().getValue() - anoPublicacao;
    }
}

