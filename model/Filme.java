package model;

import java.util.ArrayList;

public class Filme {
    String titulo;
    String sinopse;
    int ano;
    float duracao;
    int[] estrelas;
    ArrayList<Pessoa> atores;
    ArrayList<Pessoa> direcao;
    ArrayList<Personagem> personagens;


    public Filme(String titulo, String sinopse, int ano, float duracao, int[] estrelas){
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.ano = ano;
        this.duracao = duracao;
        this.estrelas = estrelas;
    }

    public void adicionarAtor(Pessoa ator){
        atores.add(ator);
    }

    public void adicionarDiretor(Pessoa diretor){
        direcao.add(diretor);
    }

    public void adicionarPersonagens(Personagem personagem){
        personagens.add(personagem);
        // Criar método para linkar personagens a atores.
    }

    // Os métodos obterAtores e obterDiretores são os getters?
}
