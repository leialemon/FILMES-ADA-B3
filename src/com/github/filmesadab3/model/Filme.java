package src.com.github.filmesadab3.model;

import java.util.ArrayList;

// TODO: inserir tratamento de input conforme o padrão estabelecido para o projeto.
// TODO: refatorar de acordo com o que for decidido para handling.

public class Filme {
    String titulo;
    String sinopse;
    int duracao; //duração em minutos;
    private Estrelas estrelas;
    ArrayList<Pessoa> atores;
    ArrayList<Pessoa> direcao;
    ArrayList<Personagem> personagens;

    public Filme(String titulo){
        this.titulo = titulo;
    } //Construtor mínimo para criar entrada do filme;

    public void adicionarAtor(Pessoa ator){
        atores.add(ator);
    }

    public void adicionarDiretor(Pessoa diretor){
        direcao.add(diretor);
    }

    public void adicionarPersonagem(Personagem personagem){
        personagens.add(personagem);
    }

    // Refatorar sem enum? (Usar int com tratamento em método handler);

    public void setEstrelas(int estrelas){
        switch (estrelas){
            case 1:
                this.estrelas = Estrelas.UMA;
                break;
            case 2:
                this.estrelas = Estrelas.DUAS;
                break;
            case 3:
                this.estrelas = Estrelas.TRES;
                break;
            case 4:
                this.estrelas = Estrelas.QUATRO;
                break;
            case 5:
                this.estrelas = Estrelas.CINCO;
                break;
            default:
                throw new IllegalArgumentException("Quantidade de estrelas inválida.");
        }
    }

    public String getEstrelas(){
        Estrelas estrelas = this.estrelas;
        String estrelasOutput = "";
        switch(estrelas){
            case UMA -> estrelasOutput = "* (1 estrela)";
            case DUAS -> estrelasOutput = "** (2 estrelas)";
            case TRES -> estrelasOutput = "*** (3 estrelas)";
            case QUATRO -> estrelasOutput = "**** (4 estrelas)";
            case CINCO -> estrelasOutput = "***** (5 estrelas)";
        }
        return estrelasOutput;
    }
}


