import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensagem de instrução para o usuário
        System.out.println("------------------------------------------");
        System.out.println("  INVERSÃO DE ARRAY: Digite a entrada.");
        System.out.print("1. Digite o TAMANHO do array (ex: 4): ");
        int n = scanner.nextInt();

        scanner.nextLine(); // Consome a quebra de linha

        System.out.print("2. Digite os " + n + " elementos (separados por espaço, ex: 1 4 3 2): ");
        String inputLine = scanner.nextLine();

        scanner.close();

        // Converte a string de entrada para um array de inteiros
        int[] arr = Arrays.stream(inputLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // ----------------------------------------------------
        // 4. Imprime o array na ordem inversa
        // ----------------------------------------------------
        StringBuilder reversedOutput = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            reversedOutput.append(arr[i]);

            if (i > 0) {
                reversedOutput.append(" ");
            }
        }

        System.out.println("\n------------------------------------------");
        System.out.print("Array Invertido: ");
        // Imprime a saída que o desafio espera
        System.out.println(reversedOutput.toString());

        // Mensagem de que deu certo!
        System.out.println("Operação concluída com sucesso! ✅");
        System.out.println("------------------------------------------");
    }
}