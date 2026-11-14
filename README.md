# BiblioDigital

Projeto acadêmico de uma biblioteca digital desenvolvido em Java. A aplicação permite cadastrar e gerenciar livros físicos, digitais e audiolivros por meio de um menu no terminal.

## Funcionalidades

- Cadastrar livros físicos, digitais e audiolivros.
- Pesquisar livros por título ou autor, aceitando buscas parciais e ignorando maiúsculas e minúsculas.
- Alterar título, autor e ano de publicação.
- Excluir livros com confirmação.
- Validar título, autor, ano de publicação e títulos duplicados.
- Remover espaços extras dos dados textuais.

## Tipos de livro

- **Livro físico:** quantidade de exemplares e localização.
- **Livro digital:** formato e tamanho do arquivo.
- **Audiolivro:** duração e narrador.

## Organização do projeto

O projeto utiliza arquitetura em camadas:

- **View — `BiblioDigitalApplication`:** exibe o menu, recebe as informações e mostra os resultados.
- **Service — `LivroService`:** valida os dados e aplica as regras de negócio.
- **Repository — `LivroRepository`:** mantém e consulta o acervo de livros em memória.
- **Entities:** representam `Livro`, `LivroFisico`, `LivroDigital` e `AudioLivro`.

## Tecnologias

- Java 25
- Maven
- IntelliJ IDEA

## Como executar

1. Abra a pasta do projeto no IntelliJ IDEA.
2. Configure o JDK 25 para o projeto.
3. Execute a classe `BiblioDigitalApplication`, no pacote `br.edu.atitus.bibliodigital.views`.

## Observação

Os livros são armazenados em memória durante a execução. Ao encerrar a aplicação, os dados cadastrados são perdidos.