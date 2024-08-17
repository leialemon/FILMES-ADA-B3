package com.github.filmesadab3.main;

import com.github.filmesadab3.model.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        int sair;

        Scanner entrada = new Scanner(System.in);

        System.out.println("""
                    \n
                    ########################   |@@|
                    Bem vindo ao Filmes-ADA!  /|  |\\
                    ########################    ||""");
        System.out.println("""
                    \n
                    obs: é necessario ter uma pessoa cadatrada
                    para cadastra um diretor ou autor""");


        do{
            //ainda não está concluido
            System.out.println("""
                                Digite o número da ação deseijada:
                                1-Cadastra Pessoa
                                2-Cadastra Filme
                                -1- sair""");
            
            System.out.println("Digite '-1' para sair:");
            sair = entrada.nextInt();

        }while (sair != -1);

        System.out.println("Obrigado, volte sempre\n");
        System.out.print("Todos os Direitos reservado₢");
    }
}
