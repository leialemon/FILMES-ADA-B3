package src.com.github.filmesadab3.model;
import src.com.github.filmesadab3.handlers.*;
import src.com.github.filmesadab3.main.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    static Scanner entrada = Main.entrada;
    private Menu(){}

    public static void menuCadastroFilme(){
        System.out.println("Cadastro de filme");
        String titulo, sinopse;
        int ano, duracao, proximo;

        titulo = EntradaHandler.loopValidaString("título","do filme: ", entrada);
        sinopse = EntradaHandler.loopValidaString("sinopse","do filme: ", entrada);
        ano = EntradaHandler.loopValidaInt("ano de lançamento","do filme: ", entrada);
        duracao = EntradaHandler.loopValidaInt("duração", "do filme: ", entrada);

        Filme filme = new Filme(titulo, sinopse, duracao, ano);
        FilmeHandler.adicionarFilme(filme);
        do {
        System.out.println("O que deseja fazer agora?");
        System.out.println("1. Adicionar atores ao filme; \n2. Adicionar diretores ao filme; " +
                "\n3. Adicionar avaliações ao filme;" +
                "\n4. Adicionar novo filme; \n5. Voltar ao menu principal;");
        proximo = EntradaHandler.loopValidaOpcoes(1, 5, entrada);

        switch (proximo){
            case 1:
                adicionarAtorAoFilme(filme);
                break;
            case 2:
                adicionarDiretorAoFilme(filme);
                break;
            case 3:
                avaliarFilmeAoFilme(filme);
                break;
            case 4:
                menuCadastroFilme();
                break;
        }}while (proximo != 5);
    }

    public static void menuCadastroPessoa(){
        System.out.println("Cadastro de Pessoas");
        String nome, biografia;

        nome = EntradaHandler.loopValidaString("nome", "da pessoa: ", entrada);
        biografia = EntradaHandler.loopValidaString("biografia", "da pessoa: ", entrada);

        Pessoa pessoa = new Pessoa(nome, biografia);
        PessoaHandler.adicionarPessoa(pessoa);
    }

    public static void menuPesquisaFilme(){
        String tituloFilme;
        System.out.println("Digite o nome do filme que você deseja procurar:");
        tituloFilme = entrada.nextLine();
        ArrayList<Filme> resultados = FilmeHandler.buscarFilme(tituloFilme);
        System.out.println("Resultados:");
        int i = 1;
        for (Filme filme : resultados){
            System.out.println(i + " - " + filme.getTitulo() + "\nNota: " + filme.getEstrelasString() + " estrelas");
            i++;
        }
        System.out.println();
        System.out.println("Para ver mais detalhes sobre um filme, digite o número correspondente,"+
                "ou digite '0' para voltar ao menu principal.");

        int filmeEscolhido = (EntradaHandler.loopValidaOpcoes(0, i, entrada)) - 1;
        if (filmeEscolhido != -1){
            menuExibirInfosPesquisa(resultados.get(filmeEscolhido));
        }
    }

    public static void menuExibirInfos(){} // TODO busca pelo título exato;

    public static void menuExibirInfosPesquisa(Filme filme){
        System.out.println("Página do filme");
        System.out.println("Título: "+filme.getTitulo());
        System.out.println("Ano de lançamento: "+filme.getAno());
        System.out.print("Duração: "+filme.getDuracao()+" minutos");
        System.out.println("   Nota: "+filme.getEstrelasString()+" estrelas");
        System.out.println("Sinopse: "+filme.getSinopse());
        System.out.println("Direção:");
        ArrayList<Pessoa> direcao = filme.obterDiretores();
        for (Pessoa diretor : direcao){
            System.out.printf(" %s;",diretor.getNome());
        }
        System.out.println("Elenco:");
        HashMap<String, String> elenco = filme.obterPersonagens();
        for (Map.Entry<String, String> personagem: elenco.entrySet()){ // key - nome do ator; value - nome do personagem
            System.out.println(personagem.getValue() + " - " + personagem.getKey());
        }
        System.out.println();
        System.out.println("Digite qualquer tecla para voltar ao menu principal...");
        entrada.next();
    }

    public static void adicionarDiretor(){
        String tituloFilme, nome;

        nome = EntradaHandler.loopValidaString("nome", "do diretor: ", entrada);
        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);

        FilmeHandler.adicionarDiretor(tituloFilme, nome);
    }

    public static void adicionarDiretorAoFilme(Filme filme){
        String nome;

        nome = EntradaHandler.loopValidaString("nome", "do diretor: ", entrada);
        FilmeHandler.adicionarDiretor(filme.getTitulo(), nome);
    }

    public static void adicionarAtor(){
        String tituloFilme, nomeAtor, nomePersonagem;

        nomeAtor = EntradaHandler.loopValidaString("nome", "do ator: ", entrada);
        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);
        nomePersonagem = EntradaHandler.loopValidaString("nome do personagem", "a ser interpretado pelo ator: ", entrada);

        FilmeHandler.adicionarAtor(tituloFilme, nomeAtor, nomePersonagem);
    }

    public static void adicionarAtorAoFilme(Filme filme){
        String nomeAtor, nomePersonagem;

        nomeAtor = EntradaHandler.loopValidaString("nome", "do ator: ", entrada);
        nomePersonagem = EntradaHandler.loopValidaString("nome do personagem", "a ser interpretado pelo ator: ", entrada);

        FilmeHandler.adicionarAtor(filme.getTitulo(), nomeAtor, nomePersonagem);
    }

    public static void avaliarFilme(){
        String tituloFilme;
        int avaliacao;

        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);
        avaliacao = EntradaHandler.loopValidaNota("nota", "de 1 a 5 estrelas para o filme: ", entrada);

        FilmeHandler.adicionarAvaliacao(tituloFilme, avaliacao);
    }

    public static void avaliarFilmeAoFilme(Filme filme){
        int avaliacao;
        avaliacao = EntradaHandler.loopValidaNota("nota", "de 1 a 5 estrelas para o filme: ", entrada);

        FilmeHandler.adicionarAvaliacao(filme.getTitulo(), avaliacao);
    }
}
