package br.edu.atitus.bibliodigital.views;

import br.edu.atitus.bibliodigital.entities.AudioLivro;
import br.edu.atitus.bibliodigital.entities.Livro;
import br.edu.atitus.bibliodigital.entities.LivroDigital;
import br.edu.atitus.bibliodigital.entities.LivroFisico;
import br.edu.atitus.bibliodigital.services.LivroService;

import java.util.List;

public class BiblioDigitalApplication {

    private final LivroService service = new LivroService();

     void main() {

        int opcao = -1;



        while (opcao != 0) {
            IO.println("===== Bem vindo ao BiblioDigital =====");
            IO.println("Menu: ");
            IO.println("1 - Cadastrar novo Livro");
            IO.println("2 - Pesquisar Livro por título");
            IO.println("3 - Pesquisar Livro por autor");
            IO.println("4 - Alterar dados do Livro");
            IO.println("5 - Excluir Livro");
            IO.println("0 - Sair");

            try {
            opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                IO.println("Você precisa digitar um Número.");
                continue;
            }
            switch (opcao) {
                case 1 -> {
                    try {


                        String titulo = IO.readln("Digite o Titulo ");
                        String autor = IO.readln("Digite o Autor ");
                        int anoPublicacao = Integer.parseInt(IO.readln("Digite o ano de publicacao: "));

                        IO.println("Escolha uma opção:");
                        IO.println("1 - livro físico");
                        IO.println("2 - Livro Digital");
                        IO.println("3 - AudioLivro");
                        int opcaoLivro = Integer.parseInt(IO.readln("Digite qual desejar: : "));

                        Livro novo;
                            if (opcaoLivro == 1) {
                                int quantExemplares = Integer.parseInt(IO.readln("Quantidade de exemplares: "));
                                String localizacao = IO.readln("Localização do livro: ").trim();
                                novo = new LivroFisico(titulo, autor, anoPublicacao, quantExemplares, localizacao);
                                service.inserir(novo);
                                IO.println("Livro físico cadastrado com sucesso!");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }


                                List<Livro> all = service.findAll();
                                for (Livro livro : all) {
                                    IO.println(livro);
                                }
                            } else if (opcaoLivro == 2) {
                                String formato = IO.readln("Formato do arquivo do livro: ").trim();
                                double tamanhoArquivo = Double.parseDouble( IO.readln("Tamanho do arquivo em MB: ") );
                                novo = new LivroDigital(titulo, autor, anoPublicacao, formato, tamanhoArquivo);
                                service.inserir(novo);
                                IO.println("Livro Digital cadastrado com sucesso!");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }else if (opcaoLivro == 3) {
                                String narrador = IO.readln("Narrador do livro: ").trim();
                                double duracao = Double.parseDouble( IO.readln("Tempo de duração do áudio: ") );
                                novo = new AudioLivro(titulo, autor, anoPublicacao, duracao, narrador);
                                service.inserir(novo);
                                IO.println("Audio Livro cadastrado com sucesso!");
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }


                            }else{
                                IO.println("Tipo de livro inválido. Cadastro cancelado.");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                    }catch (RuntimeException ex) {
                        IO.println("Erro: " + ex.getMessage());
                    }



                    }
                case 2 -> {
                    try {
                        String pesquisa = IO.readln("Pesquisa por titulo ");
                        List<Livro> livrosEncontrados = service.findByTitulo(pesquisa);
                        if (livrosEncontrados.isEmpty())
                            IO.println("Nenhum livro encontrado");
                        else{
                            for (Livro livro: livrosEncontrados){
                                IO.println(livro);
                            }
                        }
                    }catch (RuntimeException ex){
                            IO.println("Error:" + ex.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        String pesquisarPorAutor = IO.readln("Pesquisa por Autor ");
                        List<Livro> livrosEncontradosAutor = service.findByAutor(pesquisarPorAutor);
                        if (livrosEncontradosAutor.isEmpty())
                            IO.println("Nenhum livro encontrado");
                        else {
                            for (Livro livro : livrosEncontradosAutor) {
                                IO.println(livro);
                            }
                        }
                    } catch (RuntimeException ex) {
                        IO.println("Error:" + ex.getMessage());
                    }
                }

                case 4 -> {
                    try {
                        List<Livro> listaLivros = service.findAll();
                        if (listaLivros.isEmpty()){
                            IO.println("Nenhum livro cadastrado");
                        } else {
                            for (int i = 0; i < listaLivros.size(); i++) {
                                IO.println((i + 1) + " - " + listaLivros.get(i).getTitulo());
                            }
                            int indiceEscolhido = Integer.parseInt(IO.readln("Informe o número do livro escolhido: "));
                            Livro livroEscolhido = service.findByIndice(indiceEscolhido);
                            IO.println(livroEscolhido);

                            String novoTitulo = IO.readln("Novo Título: ");
                            String novoAutor = IO.readln("Novo Autor: ");
                            int novoAnoPublicacao = Integer.parseInt(IO.readln("Novo Ano: "));

                            service.alterar(indiceEscolhido, novoTitulo, novoAutor, novoAnoPublicacao);

                            IO.println("Alteração de livro Bem-sucedida");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }


                        }
                    } catch (RuntimeException ex) {
                        IO.println("Error:" + ex.getMessage());
                    }

                }
            case 5 -> {
                try {
                    List<Livro> listaLivros = service.findAll();
                    if (listaLivros.isEmpty()) {
                        IO.println("Nenhum livro cadastrado");
                    } else {
                        for (int i = 0; i < listaLivros.size(); i++) {
                            IO.println((i + 1) + " - " + listaLivros.get(i).getTitulo());
                        }
                        int indiceEscolhido = Integer.parseInt(IO.readln("Informe o número do livro escolhido: "));
                        String confirmarExclusao = IO.readln("Confirmar exclusao? s/n");

                        if (confirmarExclusao.equalsIgnoreCase("s")) {
                            service.remover(indiceEscolhido);
                            IO.println("Livro removido com sucesso!");

                        } else if (confirmarExclusao.equalsIgnoreCase("n")) {
                            IO.println("Exclusão cancelada!");

                        }else{
                            IO.println("Resposta inválida");
                        }




                    }


                }catch (RuntimeException ex){
                    IO.println("Error:" + ex.getMessage());
                }




            }




            case 0 -> IO.println("Encerrando o sistema...");
            default -> IO.println("Opção inválida");
            }

        }
    }
}
