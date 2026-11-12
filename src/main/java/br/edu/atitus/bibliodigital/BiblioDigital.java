import br.edu.atitus.bibliodigital.entities.AudioLivro;
import br.edu.atitus.bibliodigital.entities.Livro;
import br.edu.atitus.bibliodigital.entities.LivroDigital;
import br.edu.atitus.bibliodigital.entities.LivroFisico;

import java.util.ArrayList;
 
import java.util.List;

void main(){

    List<Livro> livros=new ArrayList<>();

    do {
        IO.println("Escolha uma opção:");
        IO.println("1 - Cadastrar livro");
        IO.println("2 - Listar livros");
        IO.println("0 - Sair do Sistema");

        int opcao = lerInteiro("Digite a opção desejada: ");   

       

        switch (opcao) {
 
            case 1 -> {

                String titulo = IO.readln("Digite o título do livro: ");
                if (titulo.isEmpty()) {
                    IO.println("O título do livro não pode ser vazio!");
                    break;
                }
                String autor = IO.readln("Digite o autor do livro: ");
                int anoPublicacao = lerInteiro( "Digite o ano de publicação do livro: ");
                    IO.println("Escolha uma opção:");
                    IO.println("1 - livro físico");
                    IO.println("2 - Livro Digital");
                    IO.println("0 - AudioLivro");

                    int opcaoLivro = lerInteiro("Digite a opção desejada: ");
                        if (opcaoLivro == 1) {
                            int quantidadeExemplares = lerInteiro("Digite a quantidade de exemplares do livro: ");
                            String localizacao = IO.readln("Digite a localização do livro: ");
                            LivroFisico livroFisico = new LivroFisico(titulo, autor, anoPublicacao, quantidadeExemplares, localizacao);
                            livros.add(livroFisico);
                            IO.println("Livro físico cadastrado com sucesso!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }

                        } else if (opcaoLivro == 2) {
                            String formato = IO.readln("Digite o formato do livro digital: ");
                            double tamanhoArquivo = Double.parseDouble(IO.readln("Digite o tamanho do arquivo do livro digital (em MB): "));
                            LivroDigital livroDigital = new LivroDigital(titulo, autor, anoPublicacao, formato, tamanhoArquivo);
                            livros.add(livroDigital);
                            IO.println("Livro digital cadastrado com sucesso!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }

                        } else if (opcaoLivro == 0) {
                            double duracao = Double.parseDouble(IO.readln("Digite a duração do audiolivro (em horas): "));
                            String narrador = IO.readln("Digite o nome do narrador do audiolivro: ");
                            AudioLivro audioLivro = new AudioLivro(titulo, autor, anoPublicacao, duracao, narrador);
                            livros.add(audioLivro);
                            IO.println("Audiolivro cadastrado com sucesso!");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        } else {
                            IO.println("Opção inválida!");
                        }

 
            }
 
            case 2 -> {
                
                if (livros.isEmpty()) {
                    IO.println("Nenhum livro cadastrado!");
                } else {
                    imprimirLivros(livros);
                }
                

            }

            case 0 -> {
 
                IO.println("Encerrando o sistema...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
 
            }


            default-> {
 
                IO.println("Opção inválida!");
                
                continue;
 
            }
 
        }

    } while (true);

}


void imprimirLivros (List<Livro> livros) {
    for (Livro livro : livros) {
        IO.println(livro.toString());
        IO.println("Tipo: " + livro.getTipo());
    }
}

int lerInteiro(String mensagem) {
    while (true) {
        try {
            return Integer.parseInt(IO.readln(mensagem));
        } catch (NumberFormatException e) {
            IO.println("Valor inválido! Digite apenas números.");
        }
    }
}