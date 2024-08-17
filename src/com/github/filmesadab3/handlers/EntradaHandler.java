package src.com.github.filmesadab3.handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaHandler {
    private EntradaHandler(){}
    public static boolean checkVazia(String string){
        boolean check;
        check = string == null || (string.isBlank());
        return check;
    }

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
