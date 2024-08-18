package src.com.github.filmesadab3.main;

import src.com.github.filmesadab3.handlers.EntradaHandler;
import src.com.github.filmesadab3.model.Menu;

import java.util.Scanner;

public class Main{
    public static  Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;

        System.out.println("""
                    \n
                    =================================   |@@|
                    Bem-vindo ao Filmes-ADA!           /|  |\\
                    =================================    ||""");

//        System.out.println("========================================");
//        System.out.println("  Bem-vindo ao Sistema de Dados de Filmes!");
//        System.out.println("========================================");
//        System.out.println("Explore uma vasta coleção de filmes, descubra detalhes, ");
//        System.out.println("elenco, sinopses e muito mais!");

        do{
            System.out.println("========================================");
            System.out.println("=            Menu de Opções            =");
            System.out.println("========================================");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Buscar Filmes");
            System.out.println("3. Cadastrar Pessoa");
            System.out.println("4. Buscar Pessoas");
            System.out.println("5. Adicionar Diretor ao Filme");
            System.out.println("6. Adicionar Ator ao Filme");
            System.out.println("7. Avaliar Filme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            System.out.println("Digite '0' para sair:");
            opcao = EntradaHandler.loopValidaOpcoes(0,7,entrada); //Trocar o valor do parâmetro última caso haja alterações
            switch (opcao){ //Adicionar cases conforme as opções;
                case 0: //Sair
                    System.out.println("========================================");
                    System.out.println("Obrigado por utilizar o programa!");
                    System.out.println("========================================");
                    break;
                case 1: //Cadastrar Filme
                    System.out.println("========================================");
                    Menu.menuCadastroFilme();
                    System.out.println("========================================");
                    break;
                case 2: //Buscar Filme
                    System.out.println("========================================");
                    Menu.menuPesquisaFilme();
                    System.out.println("========================================");
                    break;
                case 3: //Cadastrar Pessoa
                    System.out.println("========================================");
                    Menu.menuCadastroPessoa();
                    System.out.println("========================================");
                    break;
                case 4: //Buscar Pessoa
                    System.out.println("========================================");
                    Menu.menuPesquisaPessoa();
                    System.out.println("========================================");
                    break;
                case 5: //Adicionar Diretor ao Filme
                    System.out.println("========================================");
                    Menu.adicionarDiretor();
                    System.out.println("========================================");
                    break;
                case 6: //Adicionar Ator ao Filme
                    System.out.println("========================================");
                    Menu.adicionarAtor();
                    System.out.println("========================================");
                    break;
                case 7: //Avaliar Filme
                    System.out.println("========================================");
                    Menu.avaliarFilme();
                    System.out.println("========================================");
                    break;

                default:
                    System.out.println("========================================");
                    System.out.println("A opção selecionada não existe!");
                    System.out.println("========================================");
                    break;
            }

        }while (opcao != 0);

        System.out.print("Integrantes do projeto:");
        System.out.println("Arthur Willian");
        System.out.println("Fernando Lopes");
        System.out.println("Fernando Trimtrim");
        System.out.println("Juliana Barros");
        System.out.println("========================================");
    }
}
