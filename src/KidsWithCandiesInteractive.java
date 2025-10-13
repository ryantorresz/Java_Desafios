import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}

// Classe principal para interação e teste
public class KidsWithCandiesInteractive {

    public static void main(String[] args) {

        // Inicializa o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        Solution solver = new Solution();

        System.out.println("--- Verificador de Maior Quantidade de Doces ---");

        try {
            // Pede a entrada dos doces
            System.out.print("Digite as quantidades de doces das crianças, separadas por vírgula (ex: 2,3,5,1,3): ");
            String candiesInput = scanner.nextLine();

            // Converte a string de entrada para um array de inteiros (int[])
            int[] candies = Arrays.stream(candiesInput.split(","))
                    .map(String::trim) // Remove espaços em branco
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.out.print("Digite a quantidade de doces extras: ");
            int extraCandies = scanner.nextInt();

            List<Boolean> result = solver.kidsWithCandies(candies, extraCandies);

            System.out.println("\n--- Resultado ---");
            System.out.println("Doces Iniciais: " + Arrays.toString(candies));
            System.out.println("Doces Extras: " + extraCandies);
            System.out.println("O Array Booleano é: " + result);
            System.out.println("\n(True significa que a criança pode ter o maior número de doces)");

        } catch (Exception e) {
            System.out.println("\nErro na entrada. Por favor, insira um formato válido (ex: 2,3,5,1,3 para doces).");
        } finally {
            scanner.close();
        }
    }
}