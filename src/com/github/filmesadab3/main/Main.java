package src.com.github.filmesadab3.main;
import src.com.github.filmesadab3.model.*;
public class Main{
    public static void main(String[] args) {
        System.out.println("Início do programa");

        Filme filmeTeste = new Filme("teste");
        filmeTeste.setEstrelas(3);

        System.out.println("Nota: " + filmeTeste.getEstrelas());
    }
}