import java.util.Scanner;

public class Kangaroo {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Solução otimizada O(1)

        // Se as velocidades são iguais
        if (v1 == v2) {
            return x1 == x2 ? "YES" : "NO";
        }

        // Verifica se (x2 - x1) é divisível por (v1 - v2)
        // E se o quociente é não negativo
        if ((x2 - x1) % (v1 - v2) == 0) {
            int jumps = (x2 - x1) / (v1 - v2);
            return jumps >= 0 ? "YES" : "NO";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TESTE CANGURU ===");
        System.out.print("Digite x1 v1 x2 v2: ");

        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();

        String result = kangaroo(x1, v1, x2, v2);
        System.out.println("Resultado: " + result);

        // Testes com casos do HackerRank
        System.out.println("\n=== CASOS DE TESTE ===");

        System.out.println("Teste 1 (0 3 4 2): " + kangaroo(0, 3, 4, 2));

        System.out.println("Teste 2 (0 2 5 3): " + kangaroo(0, 2, 5, 3));

        System.out.println("Teste 3 (21 6 47 3): " + kangaroo(21, 6, 47, 3));

        System.out.println("Teste 4 (14 4 98 2): " + kangaroo(14, 4, 98, 2));

        scanner.close();
    }
}