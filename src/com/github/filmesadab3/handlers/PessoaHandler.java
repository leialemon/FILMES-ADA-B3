package src.com.github.filmesadab3.handlers;

import src.com.github.filmesadab3.db.DatabasePessoas;
import src.com.github.filmesadab3.model.Pessoa;

import java.util.ArrayList;

public class PessoaHandler {
    private static DatabasePessoas dbPessoas = new DatabasePessoas();

    public static void adicionarPessoa(Pessoa pessoa){
        if(pessoa != null){
            dbPessoas.adicionarPessoa(pessoa);
            System.out.println("A pessoa \"" + pessoa.getNome() + "\" foi adicionada ao banco de dados.");
        } else throw new IllegalArgumentException("Apenas pessoas válidas podem ser adicionadas ao banco de dados.");
    }

    /*Retorna uma lista de pessoas contendo um termo de pesquisa como nome.*/
    public static ArrayList<Pessoa> buscarPessoa(String pesquisa){
        ArrayList<Pessoa> resultados = new ArrayList<>();

        for(Pessoa p: dbPessoas.obterPessoas()){
            if(p.getNome().toLowerCase().contains(pesquisa.toLowerCase())){
                resultados.add(p);
            }
        }

        return resultados;
    }

    /*Retorna a primeira pessoa que possui um nome exatamente igual ao recebido.*/
    public static Pessoa buscarPessoaExata(String nomeExato){
        for(Pessoa p: dbPessoas.obterPessoas()){
            if(p.getNome().equals(nomeExato)){
                return p;
            }
        }

        return null;
    }
}
