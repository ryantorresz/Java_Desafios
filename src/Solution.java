import java.util.Scanner;

public class Solution {

    static int B; // Breadth (Base)
    static int H; // Height (Altura)
    static boolean flag = true; // Controla se o cálculo da área deve prosseguir

    // Bloco de Inicialização Estática: executado ao carregar a classe
    static {

        // --- SOUTs para instrução de entrada ---
        System.out.println("--- Digite a entrada ---");
        System.out.println("1. Digite o valor da Base (B) e pressione ENTER:");

        Scanner scan = new Scanner(System.in);

        // Leitura da Base
        B = scan.nextInt();

        // --- SOUT para instrução de entrada (Altura) ---
        System.out.println("2. Digite o valor da Altura (H) e pressione ENTER:");

        // Leitura da Altura
        H = scan.nextInt();
        scan.close();

        // Verificação da Restrição
        if (B <= 0 || H <= 0) {
            flag = false;

            // Imprime a mensagem de erro exigida pelo problema
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {

        // O método main só executa o cálculo se a flag for verdadeira (B e H positivos).
        if (flag) {
            int area = B * H;
            System.out.println("--- Resultado ---");
            System.out.println("Área do Paralelogramo: " + area);
        } else {
            // Caso a flag seja falsa, a mensagem de erro já foi impressa pelo bloco estático.
            System.out.println("Fim da Execução devido a valores não positivos.");
        }
    }
}