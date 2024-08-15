package src.com.github.filmesadab3.db;

import src.com.github.filmesadab3.model.Filme;

import java.util.ArrayList;

public class DatabaseFilmes {
    private ArrayList<Filme> filmes;

    public DatabaseFilmes(){
        filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme){
        filmes.add(filme);
    }

    public ArrayList<Filme> obterFilmes(){
        return filmes;
    }
}
