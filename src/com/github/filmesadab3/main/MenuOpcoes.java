package src.com.github.filmesadab3;

import src.com.github.filmesadab3.handlers.EntradaHandler;
import src.com.github.filmesadab3.handlers.FilmeHandler;
import src.com.github.filmesadab3.handlers.PessoaHandler;
import src.com.github.filmesadab3.model.Filme;
import src.com.github.filmesadab3.model.Pessoa;

import java.util.Scanner;

public class MenuOpcoes {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("====== Menu de Opções ======");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Buscar Filme");
            System.out.println("3. Adicionar Pessoa");
            System.out.println("4. Buscar Pessoa");
            System.out.println("5. Adicionar Diretor ao Filme");
            System.out.println("6. Adicionar Ator ao Filme");
            System.out.println("7. Avaliar Filme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = EntradaHandler.loopValidaOpcoes(0, 7, entrada);

            switch (opcao) {
                case 1:
                    adicionarFilme(entrada);
                    break;
                case 2:
                    buscarFilme(entrada);
                    break;
                case 3:
                    adicionarPessoa(entrada);
                    break;
                case 4:
                    buscarPessoa(entrada);
                    break;
                case 5:
                    adicionarDiretor(entrada);
                    break;
                case 6:
                    adicionarAtor(entrada);
                    break;
                case 7:
                    avaliarFilme(entrada);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void adicionarFilme(Scanner entrada) {
        String titulo = EntradaHandler.loopValidaString("Título do Filme", "", entrada);
        Filme filme = new Filme(titulo);
        FilmeHandler.adicionarFilme(filme);
        System.out.println("Filme adicionado com sucesso!");
    }

    private static void buscarFilme(Scanner entrada) {
        String pesquisa = EntradaHandler.loopValidaString("Pesquisa de Filme", "", entrada);
        var filmes = FilmeHandler.buscarFilme(pesquisa);

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado com o termo de pesquisa.");
        } else {
            System.out.println("Filmes encontrados:");
            for (Filme filme : filmes) {
                System.out.println("- " + filme.getTitulo());
            }
        }
    }

    private static void adicionarPessoa(Scanner entrada) {
        String nome = EntradaHandler.loopValidaString("Nome da Pessoa", "", entrada);
        Pessoa pessoa = new Pessoa(nome);
        PessoaHandler.adicionarPessoa(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    private static void buscarPessoa(Scanner entrada) {
        String pesquisa = EntradaHandler.loopValidaString("Pesquisa de Pessoa", "", entrada);
        var pessoas = PessoaHandler.buscarPessoa(pesquisa);

        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa encontrada com o termo de pesquisa.");
        } else {
            System.out.println("Pessoas encontradas:");
            for (Pessoa pessoa : pessoas) {
                System.out.println("- " + pessoa.getNome());
            }
        }
    }

    private static void adicionarDiretor(Scanner entrada) {
        String tituloFilme = EntradaHandler.loopValidaString("Título do Filme", "", entrada);
        String nomeDiretor = EntradaHandler.loopValidaString("Nome do Diretor", "", entrada);
        FilmeHandler.adicionarDiretor(tituloFilme, nomeDiretor);
        System.out.println("Diretor adicionado com sucesso!");
    }

    private static void adicionarAtor(Scanner entrada) {
        String tituloFilme = EntradaHandler.loopValidaString("Título do Filme", "", entrada);
        String nomeAtor = EntradaHandler.loopValidaString("Nome do Ator", "", entrada);
        FilmeHandler.adicionarAtor(tituloFilme, nomeAtor);
        System.out.println("Ator adicionado com sucesso!");
    }

    private static void avaliarFilme(Scanner entrada) {
        String tituloFilme = EntradaHandler.loopValidaString("Título do Filme", "", entrada);
        int avaliacao = EntradaHandler.loopValidaNota("Avaliação", "do Filme", entrada);
        FilmeHandler.adicionarAvaliacao(tituloFilme, avaliacao);
        System.out.println("Avaliação adicionada com sucesso!");
    }
}