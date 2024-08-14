package src.com.github.filmesadab3.model;
// TODO: inserir tratamento de input conforme o padrão estabelecido para o projeto.
public class Pessoa {
    private String nome;
    private String biografia;

    public Pessoa(String nome, String biografia){
        if (nome != null && (!nome.isBlank()))
        {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
        }
        this.biografia = biografia;
    }
    //Construtor apenas com nome;
    public Pessoa(String nome){
        if (nome != null && (!nome.isBlank()))
        {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
        }
    }

    // getters/setters conforme a necessidade;
}
