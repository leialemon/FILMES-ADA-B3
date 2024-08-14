package src.com.github.filmesadab3.model;
// TODO: inserir tratamento de input conforme o padrão estabelecido para o projeto.

public class Personagem {
    String nome;
    Pessoa ator;

    public Personagem (String nome, Pessoa ator){
        if (nome != null && (!nome.isBlank()))
        {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
        }
        this.ator = ator;
    }

    public Personagem (String nome){
        if (nome != null && (!nome.isBlank()))
        {
            this.nome = nome;
        }
        else {
            throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
        }
    }

    //criar método handler para linkar personagem e ator de acordo com o filme?

    public void setAtor(Pessoa ator){
        this.ator = ator;
    }
}
