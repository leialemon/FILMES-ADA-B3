package src.com.github.filmesadab3.model;
import src.com.github.filmesadab3.handlers.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner entrada = new Scanner(System.in);
    private Menu(){}

    public static void menuCadastroFilme(){
        System.out.println("Cadastro de filme");
        String titulo, sinopse;
        int ano, duracao;
        String tituloString = "título";
        String sinopseString = "sinopse";
        String anoString = "ano de lançamento";
        String duracaoString = "duração";
        String objetoFilme = "do filme";

        titulo = EntradaHandler.loopValidaString(tituloString,objetoFilme, entrada);
        sinopse = EntradaHandler.loopValidaString(sinopseString,objetoFilme, entrada);
        ano = EntradaHandler.loopValidaInt(anoString,objetoFilme, entrada);
        duracao = EntradaHandler.loopValidaInt(duracaoString, objetoFilme, entrada);

        Filme filme = new Filme(titulo, sinopse, duracao, ano);
        FilmeHandler.adicionarFilme(filme);

        System.out.println("O que deseja fazer agora?");
        System.out.println("1. Adicionar atores ao filme; \n2. Adicionar diretores ao filme; " +
                "\n3. Adicionar personagens ao filme; \n4. Adicionar avaliações ao filme;" +
                "\n5. Adicionar novo filme; \n6. Voltar ao menu principal;");
        int proximo = EntradaHandler.loopValidaOpcoes(1, 6, entrada);

        switch (proximo){
            case 1:
                adicionarAtorAoFilme(filme);
                break;
            case 2:
                adicionarDiretorAoFilme(filme);
                break;
            case 3:
                adicionarPersonagemAoFilme(filme);
                break;
            case 4:
                avaliarFilmeAoFilme(filme);
                break;
            case 5:
                menuCadastroFilme();
                break;
            case 6:
                return;
        }
    }

    public static void menuCadastroPessoa(){
        System.out.println("Cadastro de Pessoas");
        String nome, biografia;
        String nomeString = "nome";
        String biografiaString = "biografia";
        String pessoaObjeto = "da pessoa";

        nome = EntradaHandler.loopValidaString(nomeString, pessoaObjeto, entrada);
        biografia = EntradaHandler.loopValidaString(biografiaString, pessoaObjeto, entrada);

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
            System.out.println(i + filme.getTitulo() + "\nNota: " + filme.getEstrelasString() + " estrelas");
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

    public static void menuExibirInfos(){}

    public static void menuExibirInfosPesquisa(Filme filme){
        System.out.println("Página do filme");
        System.out.println("Título: "+filme.getTitulo());
        System.out.println("Ano de lançamento: "+filme.getAno());
        System.out.print("   Duração: "+filme.getDuracao()+" minutos");
        System.out.println("Nota: "+filme.getEstrelasString()+" estrelas");
        System.out.println("Sinopse: "+filme.getSinopse());
        System.out.println("Direção:");
        ArrayList<Pessoa> direcao = filme.obterDiretores();
        for (Pessoa diretor : direcao){
            System.out.printf(" %s;",diretor.getNome());
        }
        System.out.println("Elenco:");
        ArrayList<Pessoa> elenco = filme.obterAtores();
        for (Pessoa ator : elenco){
            System.out.println(ator.getNome());
        }
        System.out.println();
        System.out.println("Digite qualquer tecla para voltar ao menu principal:");
        entrada.next();
    }

    public static void adicionarDiretor(){
        String tituloFilme, nome;
        String tituloString = "título";
        String nomeString = "nome";
        String diretorObjeto = "do diretor";
        String objetoFilme = "do filme";

        nome = EntradaHandler.loopValidaString(nomeString, diretorObjeto, entrada);
        tituloFilme = EntradaHandler.loopValidaString(tituloString, objetoFilme, entrada);

        FilmeHandler.adicionarDiretor(tituloFilme, nome);
    }

    public static void adicionarDiretorAoFilme(Filme filme){
        String nome;
        String nomeString = "nome";
        String diretorObjeto = "do diretor";

        nome = EntradaHandler.loopValidaString(nomeString, diretorObjeto, entrada);
        FilmeHandler.adicionarDiretor(filme.getTitulo(), nome);
    }

    public static void adicionarAtor(){
        String tituloFilme, nome;
        String tituloString = "título";
        String nomeString = "nome";
        String atorObjeto = "do ator";
        String objetoFilme = "do filme";

        nome = EntradaHandler.loopValidaString(nomeString, atorObjeto, entrada);
        tituloFilme = EntradaHandler.loopValidaString(tituloString, objetoFilme, entrada);

        FilmeHandler.adicionarAtor(tituloFilme, nome);
    }

    public static void adicionarAtorAoFilme(Filme filme){
        String nome;
        String nomeString = "nome";
        String atorObjeto = "do ator";

        nome = EntradaHandler.loopValidaString(nomeString, atorObjeto, entrada);
        FilmeHandler.adicionarAtor(filme.getTitulo(), nome);
    }

    public static void adicionarPersonagem(){}

    public static void adicionarPersonagemAoFilme(Filme filme){}

    public static void avaliarFilme(){
        String tituloFilme;
        String tituloString = "título";
        String objetoFilme = "do filme";
        int avaliacao;
        String avaliacaoString = "nota";
        String objeto = "de 1 a 5 para o filme:";

        tituloFilme = EntradaHandler.loopValidaString(tituloString, objetoFilme, entrada);
        avaliacao = EntradaHandler.loopValidaNota(avaliacaoString, objeto, entrada);

        FilmeHandler.adicionarAvaliacao(tituloFilme, avaliacao);
    }

    public static void avaliarFilmeAoFilme(Filme filme){
        int avaliacao;
        String avaliacaoString = "nota";
        String objeto = "de 1 a 5 para o filme:";
        avaliacao = EntradaHandler.loopValidaNota(avaliacaoString, objeto, entrada);

        FilmeHandler.adicionarAvaliacao(filme.getTitulo(), avaliacao);
    }
}
