import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public String reverseWords(String s) {

        String[] wordsArray = s.trim().split("\\s+");

        List<String> wordList = Arrays.asList(wordsArray);

        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Teste de Reversão de Palavras em uma String ---");
        System.out.println("Exemplos de entrada:");
        System.out.println("  \"the sky is blue\"");
        System.out.println("  \"  hello world  \"");
        System.out.println("  \"a good   example\"");
        System.out.println("--------------------------------------------------");

        while (true) {
            System.out.print("\nInsira a string (ou digite 'sair' para encerrar): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Entrada vazia. Por favor, insira uma string.");
                continue;
            }

            String cleanInput = input.replaceAll("^[\"']|[\"']$", "");

            String result = solver.reverseWords(cleanInput);

            System.out.println("String Original: \"" + cleanInput + "\"");
            System.out.println("String Revertida: \"" + result + "\"");
        }

        scanner.close();
    }
}