package br.edu.atitus.bibliodigital.entities;

public final class  LivroFisico extends Livro {

    private int quantidadeExemplares;
    private String localizacao;

    public LivroFisico(String titulo, String autor, int anoPublicacao, Object o, int quantidadeExemplares, String localizacao) {
        super(titulo, autor, anoPublicacao);
        this.quantidadeExemplares = quantidadeExemplares;
        this.localizacao = localizacao;
    }

    public LivroFisico(String titulo, String autor, int anoPublicacao, int quantidadeExemplares, String localizacao) {
        super(titulo, autor, anoPublicacao);
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }

    

}
