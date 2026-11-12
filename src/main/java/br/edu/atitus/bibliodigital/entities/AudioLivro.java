package br.edu.atitus.bibliodigital.entities;

public final class AudioLivro extends Livro {

    private double duracao;
    private String narrador;

    public AudioLivro(String titulo, String autor, int anoPublicacao, double duracao, String narrador) {
        super(titulo, autor, anoPublicacao);
        this.duracao = duracao;
        this.narrador = narrador;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    @Override
    public String getTipo() {
        return "Audio-livro";
    }
    
}
