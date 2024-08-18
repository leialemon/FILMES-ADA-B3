package src.com.github.filmesadab3.model;
import src.com.github.filmesadab3.handlers.*;
import src.com.github.filmesadab3.main.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    //Classe utilitária que gerencia os métodos chamados pelos menus;
    static Scanner entrada = Main.entrada; //objeto Scanner importado da classe Main;
    private Menu(){}

    // Adiciona um filme na base de dados através dos dados fornecidos pelo usuário e por intermédio dos métodos handlers;
    public static void menuCadastroFilme(){ //MP
        System.out.println("Cadastrar Filme");
        System.out.println("========================================");
        String titulo, sinopse;
        int ano, duracao, proximo;

        titulo = EntradaHandler.loopValidaString("título","do filme: ", entrada);
        sinopse = EntradaHandler.loopValidaString("sinopse","do filme: ", entrada);
        ano = EntradaHandler.loopValidaAno("ano de lançamento", entrada);
        duracao = EntradaHandler.loopValidaDuracao("duração", entrada);

        Filme filme = new Filme(titulo, sinopse, ano, duracao);
        FilmeHandler.adicionarFilme(filme);
        do {
            System.out.println("========================================");
            System.out.println("O que deseja fazer agora?");
            System.out.println("1. Adicionar atores ao filme; \n2. Adicionar diretores ao filme; " +
                    "\n3. Adicionar avaliações ao filme;" +
                    "\n4. Adicionar novo filme; \n5. Voltar ao menu principal;");
            proximo = EntradaHandler.loopValidaOpcoes(1, 5, entrada);

            System.out.println("========================================");

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
            }
        }while (proximo != 5);
    }

    // Adiciona uma pessoa na base de dados através dos dados fornecidos pelo usuário e por intermédio dos métodos handlers;
    public static void menuCadastroPessoa(){ //MP
        System.out.println("Cadastrar Pessoa");
        System.out.println("========================================");
        String nome, biografia;

        nome = EntradaHandler.loopValidaString("nome", "da pessoa: ", entrada);
        biografia = EntradaHandler.loopValidaString("biografia", "da pessoa: ", entrada);

        Pessoa pessoa = new Pessoa(nome, biografia);
        PessoaHandler.adicionarPessoa(pessoa);
    }

    // Faz a busca de filmes por título e retorna todos os resultados com a expressão pesquisada;
    public static void menuPesquisaFilme(){ //MP
        System.out.println("Buscar Filmes");
        System.out.println("========================================");
        System.out.println("Digite o nome do filme que você deseja procurar");
        String tituloFilme = EntradaHandler.loopValidaString("título","do filme",entrada);
        System.out.println("========================================");
        ArrayList<Filme> resultados = FilmeHandler.buscarFilme(tituloFilme);
        System.out.println("Resultados:");
        if (resultados.isEmpty()){
            System.out.println("Nenhum filme encontrado.");
        } else {
            int i = 1;
            for (Filme filme : resultados){
                String notaFilme = (filme.getEstrelasString().equals("Sem avaliações") ? filme.getEstrelasString() : filme.getEstrelasString() + " estrelas");
                System.out.println(i + " - " + filme.getTitulo() + "\nNota: " + notaFilme);
                i++;
            }
            System.out.println("Para ver mais detalhes sobre um filme, digite o número correspondente,"+
                    "ou digite '0' para voltar ao menu anterior.");

            int filmeEscolhido = (EntradaHandler.loopValidaOpcoes(0, i, entrada)) - 1;
            if (filmeEscolhido != -1){
                System.out.println("========================================");
                menuExibirInfosPesquisa(resultados.get(filmeEscolhido));
            }
        }
        System.out.println("Deseja realizar outra pesquisa? 1.Sim/2.Não");
        int resposta = EntradaHandler.loopValidaOpcoes(1,2,entrada);
        if (resposta == 1){
            System.out.println("========================================");
            menuPesquisaFilme();
        }
    }

    // Faz a busca de pessoas por nome e retorna todos os resultados com o nome pesquisado;
    public static void menuPesquisaPessoa(){
        System.out.println("Buscar Pessoas");
        System.out.println("========================================");
        System.out.println("Digite o nome da pessoa que você deseja procurar");
        String nomePessoa = EntradaHandler.loopValidaString("nome","da pessoa",entrada);
        ArrayList<Pessoa> resultados = PessoaHandler.buscarPessoa(nomePessoa);

        if (resultados.isEmpty()){
            System.out.println("========================================");
            System.out.println("Nenhuma pessoa encontrada.");
            System.out.println("========================================");
        } else {
            System.out.println("========================================");
            for (Pessoa pessoa : resultados){
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Biografia: " + pessoa.getBiografia());
            }
            System.out.println("========================================");
        }
    }

    // Realiza a pesquisa conforme o título exato informado pelo usuário e retorna todas as informações sobre aquele filme;
    public static void menuPesquisaExata(){ //MP
        System.out.println("Digite o título exato do filme que deseja pesquisar");
        String tituloExato = EntradaHandler.loopValidaString("título exato","do filme",entrada);
        System.out.println("========================================");
        var filme = FilmeHandler.buscarFilmeExato(tituloExato);
        if (filme == null){
            System.out.println("Desculpe, não encontramos filmes com esse título em nossa base de dados.");
            System.out.println("Deseja tentar novamente? 1.Sim/2.Não");
            int resposta = EntradaHandler.loopValidaOpcoes(1,2,entrada);
            if (resposta == 1){
                System.out.println("========================================");
                menuPesquisaExata();
            }
        } else {
            System.out.println("========================================");
            menuExibirInfosPesquisa(filme);
        }
    }

    // Método que retorna as informações sobre um filme, chamado pelos métodos menuPesquisaFilme e menuPesquisaExata;
    public static void menuExibirInfosPesquisa(Filme filme){
        System.out.println("Página do filme");
        System.out.println("========================================");
        System.out.println("Título: "+filme.getTitulo());
        System.out.println("Ano de lançamento: "+filme.getAno());
        System.out.print("Duração: "+filme.getDuracao()+" minutos");
        String notaFilme = (filme.getEstrelasString().equals("Sem avaliações") ? filme.getEstrelasString() : filme.getEstrelasString() + " estrelas");
        System.out.println("   Nota: " + notaFilme);
        System.out.println("Sinopse: "+filme.getSinopse());
        System.out.println("Direção:");
        ArrayList<Pessoa> direcao = filme.obterDiretores();
        for (Pessoa diretor : direcao){
            System.out.printf(" %s;",diretor.getNome());
        }
        System.out.println("\nElenco:");
        HashMap<String, String> elenco = filme.obterPersonagens();
        for (Map.Entry<String, String> personagem: elenco.entrySet()){ // key - nome do ator; value - nome do personagem
            System.out.println(personagem.getValue() + " - " + personagem.getKey());
        }
        System.out.println("========================================");
        System.out.println();
        System.out.println("Digite qualquer tecla para voltar ao menu principal...");
        entrada.next();
    }

    //Métodos que adicionam atributos a um filme;
    public static void adicionarDiretor(){ //MP
        System.out.println("Adicionar Diretor a um Filme");
        System.out.println("========================================");

        String tituloFilme, nome;

        nome = EntradaHandler.loopValidaString("nome", "do diretor: ", entrada);
        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);

        FilmeHandler.adicionarDiretor(tituloFilme, nome);
    }

    public static void adicionarAtor(){ //MP
        System.out.println("Adicionar Ator a um Filme");
        System.out.println("========================================");

        String tituloFilme, nomeAtor, nomePersonagem;

        nomeAtor = EntradaHandler.loopValidaString("nome", "do ator: ", entrada);
        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);
        nomePersonagem = EntradaHandler.loopValidaString("nome do personagem", "a ser interpretado pelo ator: ", entrada);

        FilmeHandler.adicionarAtor(tituloFilme, nomeAtor, nomePersonagem);
    }

    public static void avaliarFilme(){ //MP
        String tituloFilme;
        int avaliacao;

        tituloFilme = EntradaHandler.loopValidaString("título", "do filme: ", entrada);
        avaliacao = EntradaHandler.loopValidaNota("nota", "de 1 a 5 estrelas para o filme: ", entrada);

        FilmeHandler.adicionarAvaliacao(tituloFilme, avaliacao);
    }

    // Métodos iguais aos acima, mas chamados pelo menu de adicionar filmes;

    public static void adicionarDiretorAoFilme(Filme filme){
        String nome;

        nome = EntradaHandler.loopValidaString("nome", "do diretor: ", entrada);
        FilmeHandler.adicionarDiretor(filme.getTitulo(), nome);
    }

    public static void adicionarAtorAoFilme(Filme filme){
        String nomeAtor, nomePersonagem;

        nomeAtor = EntradaHandler.loopValidaString("nome", "do ator: ", entrada);
        nomePersonagem = EntradaHandler.loopValidaString("nome do personagem", "a ser interpretado pelo ator: ", entrada);

        FilmeHandler.adicionarAtor(filme.getTitulo(), nomeAtor, nomePersonagem);
    }

    public static void avaliarFilmeAoFilme(Filme filme){
        System.out.println("Avaliar Filme");
        System.out.println("========================================");

        int avaliacao;
        avaliacao = EntradaHandler.loopValidaNota("nota", "de 1 a 5 estrelas para o filme: ", entrada);

        FilmeHandler.adicionarAvaliacao(filme.getTitulo(), avaliacao);
    }
}
