import java.util.Scanner;

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();

        int minLength = Math.min(len1, len2);

        for (int i = 0; i < minLength; i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }


        if (len1 > minLength) {
            merged.append(word1.substring(minLength));
        }

        if (len2 > minLength) {
            merged.append(word2.substring(minLength));
        }

        return merged.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("--- Fusao de Strings Alternada ---");

        System.out.print("Digite a primeira palavra (word1): ");
        String word1 = scanner.nextLine();

        System.out.print("Digite a segunda palavra (word2): ");
        String word2 = scanner.nextLine();

        String result = solution.mergeAlternately(word1, word2);

        System.out.println("\n----------------------------------");
        System.out.println("Palavra 1: \"" + word1 + "\"");
        System.out.println("Palavra 2: \"" + word2 + "\"");
        System.out.println("Resultado da Fusao: \"" + result + "\"");
        System.out.println("----------------------------------");

        scanner.close();
    }
}