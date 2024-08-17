import java.util.Scanner;

public class MenuOpcoes {

    public static void exibirOpcoes() {
        System.out.println("Por favor, escolha uma das opções abaixo:");
        System.out.println("1. Buscar filmes por título");
        System.out.println("2. Listar todos os filmes");
        System.out.println("3. Exibir detalhes de um filme");
        System.out.println("4. Adicionar um novo filme");
        System.out.println("5. Sair");
        System.out.print("Digite o número da opção desejada: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirOpcoes();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 selecionada: Buscar filmes por título.");
                    // Adicione o código correspondente para buscar filmes
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada: Listar todos os filmes.");
                    // Adicione o código correspondente para listar filmes
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada: Exibir detalhes de um filme.");
                    // Adicione o código correspondente para exibir detalhes
                    break;
                case 4:
                    System.out.println("Opção 4 selecionada: Adicionar um novo filme.");
                    // Adicione o código correspondente para adicionar um filme
                    break;
                case 5:
                    System.out.println("Saindo do sistema. Obrigado por usar o Sistema de Dados de Filmes!");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}