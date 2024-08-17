package src.com.github.filmesadab3.handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaHandler {
    // Classe utilitária que contém os métodos de validação dos dados de entrada;
    private EntradaHandler(){}

    // Método para checar se a entrada é uma String vazia. Chamado pelos loops;
    public static boolean checkVazia(String string){
        boolean check;
        check = string == null || (string.isBlank());
        return check;
    }

    // Método para checar se a entrada é um número negativo. Chamado pelos loops;
    public static boolean checkNegativo(int numero, String nome){
        boolean check;
        if (numero < 0){
            System.err.println("O valor de " +nome+ " deve ser maior que zero!");
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    // Método que valida entradas e retorna valores válidos de strings. Executa em loop até o usuário fornecer uma entrada válida.
    // Os parâmetros são: nome e objeto são strings utilizadas somente para personalizar os outputs do método, de modo que o usuário saiba
    // qual valor está sendo atribuído; entrada recebe um objeto Scanner criado na classe Main;
    public static String loopValidaString(String nome, String objeto, Scanner entrada){
        String retorno;
        boolean erro;
        do{
            System.out.println("Informe " +nome+ " "+objeto);
            retorno = entrada.nextLine();
            erro = EntradaHandler.checkVazia(retorno);
            if (erro) {
                System.out.println("O campo " +nome+ " é de preenchimento obrigatório!");
            }
        } while (erro);
        return retorno;
    }
    // Método que valida entradas e retorna um número inteiro válido para ser atribuído ao atributo Filme.ano;
    // Os parâmetros são: nome, uma string contendo a expressão "ano de lançamento"; e entrada, que recebe um objeto Scanner;
    public static int loopValidaAno(String nome, Scanner entrada){
        int retorno = 0;
        boolean erro = true;
        do {
            System.out.println("Informe o ano de lançamento do filme (apenas números):");
            try {
                retorno = Integer.parseInt(entrada.next());
                erro = EntradaHandler.checkNegativo(retorno, nome);
                if (retorno < 1888){
                    erro = true;
                    System.err.println("Ano inválido! Não existem filmes lançados antes de 1888.");
                } else if (retorno > 3000) {
                    System.err.println("Por favor, digite um ano de lançamento válido.");
                    erro = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, digite apenas números.");
            }
        } while (retorno <= 0 || erro);
        return retorno;
    }
    // Método que valida entradas e retorna um número inteiro válido para ser atribuído ao atributo Filme.duracao;
    // Os parâmetros são: nome, uma string contendo a expressão "duração"; e entrada, que recebe um objeto Scanner;
    public static int loopValidaDuracao(String nome,  Scanner entrada){
        int retorno = 0;
        boolean erro = true;
        do {
            System.out.println("Informe a duração do filme em minutos (apenas números):");
            try {
                retorno = Integer.parseInt(entrada.next());
                erro = EntradaHandler.checkNegativo(retorno, nome);
            } catch (NumberFormatException e) {
                System.err.println("Por favor, digite apenas números.");
            }
        } while (retorno <= 0 || erro);
        return retorno;
    }

    // Método que valida entradas e retorna uma nota de 1 a 5 para computar na avaliação do filme;
    // Os parâmetros seguem o mesmo padrão dos demais loops de validação;
    public static int loopValidaNota(String nome, String objeto, Scanner entrada){
        int retorno = 0;
        boolean erro = true;
        do {
            System.out.println("Informe " +nome+ " " +objeto+ "(apenas números):");
            try {
                retorno = Integer.parseInt(entrada.next());
                erro = EntradaHandler.checkNegativo(retorno, nome);
                if (retorno < 1 || retorno > 5){
                    System.err.println("A nota deve ser de 1 a 5!");
                    erro = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, digite apenas números.");
            }
        } while (retorno == 0 || erro);
        return retorno;
    }

    // Método que valida entradas e retorna um inteiro válido para representar a escolha do usuário diante dos menus de opções;
    // Os parâmetros primeira e última representam as opções do menu que chama o método;
    public static int loopValidaOpcoes(int primeira, int ultima, Scanner entrada){
        int retorno = 0;
        boolean erro = true;
        do {
        try {
            retorno = entrada.nextInt();
            if (retorno >= primeira && retorno <= ultima){
                erro = false;
            } else {
                System.err.println("Opção inválida! Digite um número de " + primeira+ " a " +ultima);
            }
        }
        catch (InputMismatchException e){
            System.err.println("Por favor, digite apenas números. Tente novamente:");
        } catch (Exception e){
            System.err.println("ERRO! Por favor, tente novamente:");
        }
        entrada.nextLine();
        } while(erro);
        return retorno;
    }

}
