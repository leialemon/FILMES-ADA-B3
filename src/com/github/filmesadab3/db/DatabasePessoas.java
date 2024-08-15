package src.com.github.filmesadab3.db;

import src.com.github.filmesadab3.model.Pessoa;

import java.util.ArrayList;

public class DatabasePessoas {
    private ArrayList<Pessoa> pessoas;

    public DatabasePessoas(){
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> obterPessoas(){
        return pessoas;
    }
}
