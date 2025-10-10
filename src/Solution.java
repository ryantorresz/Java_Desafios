import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    // (Coloque sua função compareTriplets aqui, se quiser testar)
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }
        return Arrays.asList(aliceScore, bobScore);
    }

    // --- Bloco Principal de Leitura (SOUT para Inserção) ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. SOUT para as Pontuações de Alice
        System.out.println("Insira as 3 pontuações de Alice (separadas por espaço, ex: 5 6 7):");

        // 2. Leitura e Processamento dos dados de Alice
        String linhaAlice = scanner.nextLine();
        List<Integer> a = Arrays.stream(linhaAlice.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 3. SOUT para as Pontuações de Bob
        System.out.println("Insira as 3 pontuações de Bob (separadas por espaço, ex: 3 6 10):");

        // 4. Leitura e Processamento dos dados de Bob
        String linhaBob = scanner.nextLine();
        List<Integer> b = Arrays.stream(linhaBob.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        scanner.close();

        // 5. Chamada da Função e Resultado Final (Sout)
        List<Integer> resultado = compareTriplets(a, b);

        System.out.println("\n--- Resultado da Comparação ---");
        System.out.println("Pontuação de Alice: " + resultado.get(0));
        System.out.println("Pontuação de Bob: " + resultado.get(1));
        System.out.println("Resultado final (Alice, Bob): " + resultado);
    }
}