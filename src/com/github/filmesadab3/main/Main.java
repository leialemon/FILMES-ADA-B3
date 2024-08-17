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
                    ########################   |@@|
                    Bem vindo ao Filmes-ADA!  /|  |\\
                    ########################    ||""");
        System.out.println("""
                    \n
                    obs: é necessário ter uma pessoa cadastrada
                    para cadastra um diretor ou autor""");


        do{
            //ainda não está concluido - Adicionar as opções ao usuário
            System.out.println("""
                                Digite o número da ação desejada: 
                                1-Cadastrar Pessoa
                                2-Cadastrar Filme
                                3-Pesquisar Filme
                                0- sair""");
            
            System.out.println("Digite '0' para sair:");
            opcao = EntradaHandler.loopValidaOpcoes(0,3,entrada); //Trocar o valor do parâmetro última caso haja alterações
            switch (opcao){ //Adicionar cases conforme as opções;
                case 1:
                    Menu.menuCadastroPessoa();
                    break;
                case 2:
                    Menu.menuCadastroFilme();
                    break;
                case 3:
                    Menu.menuPesquisaFilme();
            }

        }while (opcao != 0);

        System.out.println("Obrigado, volte sempre\n");
        System.out.print("Todos os Direitos reservado₢");
    }
}
