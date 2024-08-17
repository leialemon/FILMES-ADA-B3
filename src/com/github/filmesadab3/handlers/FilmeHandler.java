package src.com.github.filmesadab3.handlers;

import src.com.github.filmesadab3.db.DatabaseFilmes;
import src.com.github.filmesadab3.model.Filme;
import src.com.github.filmesadab3.model.Pessoa;

import java.util.ArrayList;

public class FilmeHandler {
    private static DatabaseFilmes dbFilmes = new DatabaseFilmes();

    /*Adiciona um filme ao banco de dados.*/
    public static void adicionarFilme(Filme filme){
        if(filme != null) {
            dbFilmes.adicionarFilme(filme);
        } else throw new IllegalArgumentException("Apenas filmes válidos podem ser adicionados ao banco de dados.");
    }

    /*Retorna uma lista de filmes contendo um termo de pesquisa no título.*/
    public static ArrayList<Filme> buscarFilme(String pesquisa){
        ArrayList<Filme> resultados = new ArrayList<>();

        for(Filme f: dbFilmes.obterFilmes()){
            if(f.getTitulo().toLowerCase().contains(pesquisa.toLowerCase())){
                resultados.add(f);
            }
        }

        return resultados;
    }

    /*Retorna o primeiro filme que possui um título exatamente igual ao recebido.*/
    public static Filme buscarFilmeExato(String tituloExato){
        for(Filme f: dbFilmes.obterFilmes()){
            if(f.getTitulo().equals(tituloExato)){
                return f;
            }
        }

        return null;
    }

    /**/
    public static void adicionarDiretor(String tituloFilme, String nomeDiretor){
        Filme f = buscarFilmeExato(tituloFilme);
        if(f != null){
            Pessoa p = PessoaHandler.buscarPessoaExata(nomeDiretor);
            if(p != null){
                f.adicionarDiretor(p);
            } else System.err.println("A pessoa a ser adicionada na direção do filme não foi encontrada na base de dados.");
        } else System.err.println("O filme não foi encontrado no banco de dados.");
    }

    public static void adicionarAtor(String tituloFilme, String nomeAtor, String nomePersonagem){
        Filme f = buscarFilmeExato(tituloFilme);
        if(f != null){
            Pessoa p = PessoaHandler.buscarPessoaExata(nomeAtor);
            if(p != null){
                if(nomePersonagem != null && !nomePersonagem.isBlank()) {
                    f.adicionarAtor(p, nomePersonagem);
                } else System.err.println("Um ator a ser adicionado deve interpretar um personagem válido.");
            } else System.err.println("A pessoa a ser adicionada como ator não foi encontrada na base de dados.");
        } else System.err.println("O filme não foi encontrado no banco de dados.");
    }

    /*Adiciona uma avaliação (em estrelas) a um filme.
    * String tituloFilme - título exato do filme a avaliar;
    * int avaliacao - valor (em estrelas, de 1 a 5) da avaliação.
    * Imprime mensagens de erro caso não seja possível realizar a operação.
    * */
    public static void adicionarAvaliacao(String tituloFilme, int avaliacao){
        Filme f = buscarFilmeExato(tituloFilme);
        if(f != null){
            if(avaliacao >= 1 && avaliacao <= 5){
                f.avaliar(avaliacao);
            } else System.err.println("A avaliação do filme deve ser um valor entre 1 e 5 estrelas.");
        } else System.err.println("O filme não foi encontrado no banco de dados.");
    }
}
