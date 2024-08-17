package src.com.github.filmesadab3.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Filme {
    private String titulo;
    private String sinopse;
    private int ano;
    private int duracao; //duração em minutos;
    private int[] estrelas; //número de avaliações (em estrelas)
    ArrayList<Pessoa> atores;
    ArrayList<Pessoa> diretores;
    HashMap<String, String> personagens; //[chave: nome do ator] -> [valor: nome do personagem]

    public Filme(String titulo, String sinopse, int ano, int duracao){
        if(titulo != null && !titulo.isBlank()){
            this.titulo = titulo;
        } else throw new IllegalArgumentException("O campo titulo é de preenchimento obrigatório.");

        if(sinopse != null && !sinopse.isBlank()){
            this.sinopse = sinopse;
        } else throw new IllegalArgumentException("O campo sinopse é de preenchimento obrigatório.");

        if(duracao > 0){
            this.duracao = duracao;
        } else throw new IllegalArgumentException("O campo duração não pode ser menor ou igual a zero.");

        if (ano > 0){
            this.ano = ano;
        }
        else{
            throw new IllegalArgumentException("O campo ano não pode ser menor ou igual a zero.");
        }

        estrelas = new int[5];
        atores = new ArrayList<>();
        diretores = new ArrayList<>();
        personagens = new HashMap<>();
    }

    public void adicionarAtor(Pessoa ator, String nomePersonagem){
        if(ator != null){
            if(nomePersonagem != null && !nomePersonagem.isBlank()){
                atores.add(ator);
                personagens.put(ator.getNome(), nomePersonagem);
            } else throw new IllegalArgumentException("Um ator a ser adicionado deve interpretar um personagem válido.");
        } else throw new IllegalArgumentException("O filme não pode receber um ator nulo.");
    }

    public void adicionarDiretor(Pessoa diretor){
        if(diretor != null) diretores.add(diretor);
        else throw new IllegalArgumentException("O filme não pode receber um diretor nulo.");
    }

    /*Adiciona uma avaliação em estrelas para o filme, sendo entre 1 e 5 estrelas.*/
    public void avaliar(int nota){
        if(nota >= 1 && nota <= 5){
            estrelas[nota - 1] ++;
        } else throw new IllegalArgumentException("O filme deve receber uma nota válida (entre um e cinco).");
    }

    /*Retorna a avaliação média do filme (em estrelas).*/
    public float getEstrelas(){
        float mediaPonderada;

        mediaPonderada = (float) (estrelas[0] + estrelas[1] * 2 + estrelas[2] * 3 + estrelas[3] * 4 + estrelas[4] * 5) /(estrelas[0] + estrelas[1] + estrelas[2] + estrelas[3] + estrelas[4]);

        return mediaPonderada;
    }

    /*Retorna a avaliação média do filme (em estrelas) como uma String, exibindo apenas dois dígitos após a vírgula.*/
    public String getEstrelasString(){
        float media = getEstrelas();
        return String.format("%.2f", media);
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSinopse(){
        return sinopse;
    }

    public int getAno(){
        return this.ano;
    }

    public int getDuracao(){
        return duracao;
    }

    public ArrayList<Pessoa> obterAtores(){
        return atores;
    }

    public ArrayList<Pessoa> obterDiretores(){
        return diretores;
    }

    public HashMap<String, String> obterPersonagens(){ return personagens; }
}


