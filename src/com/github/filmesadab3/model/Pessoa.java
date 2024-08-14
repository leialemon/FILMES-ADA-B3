package src.com.github.filmesadab3.model;

public class Pessoa {
    private String nome;
    private String biografia;

    //Tanto o nome como a biografia devem aparecer no sistema IMdb
    public Pessoa(String nome, String biografia){
        if (nome != null && (!nome.isBlank()))
        {
            this.nome = nome;
        }
        else throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");

        if (biografia != null && (!biografia.isBlank()))
        {
            this.biografia = biografia;
        }
        else throw new IllegalArgumentException("O campo biografia é de preenchimento obrigatório.");
    }
    //Construtor apenas com nome;
//    public Pessoa(String nome){
//        if (nome != null && (!nome.isBlank()))
//        {
//            this.nome = nome;
//        }
//        else {
//            throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
//        }
//    }

    public String getNome(){
        return nome;
    }

    public String getBiografia(){
        return biografia;
    }
}
