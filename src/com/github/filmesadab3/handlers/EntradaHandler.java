package src.com.github.filmesadab3.handlers;

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
            System.out.println("O valor de " +nome+ " deve ser maior que zero!");
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

    public static int loopValidaInt(String nome, String objeto, Scanner entrada){
        int retorno = 0;
        boolean erro = true;
        do {
            System.out.println("Informe " +nome+ " " +objeto+ "(apenas números):");
            try {
                retorno = Integer.parseInt(entrada.next());
                erro = EntradaHandler.checkNegativo(retorno, nome);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números.");
            }
        } while (retorno == 0 || erro);
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
                    System.out.println("A nota deve ser de 1 a 5!");
                    erro = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números.");
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
            if (entrada.nextInt() >= primeira && entrada.nextInt() <= ultima){
                erro = false;
            } else {
                System.out.println("Opção inválida! Digite um número de " + primeira+ " a " +ultima);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("Por favor, digite apenas números. Tente novamente:");
        }} while(erro);
        return retorno;
    }

}
