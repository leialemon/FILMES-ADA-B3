package model;

public class Pessoa {
    String nome;
    String biografia;

    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(String nome, String biografia){
        this.nome = nome;
        this.biografia = biografia;
    }

    // Criei dois construtores: um que recebe apenas o nome da pessoa e outro que recebe o nome e
    // a biografia, caso se queira cadastrar alguém a cuja biografia não se tem acesso.




}
