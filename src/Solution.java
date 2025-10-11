import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            if (lastSeenIndex.containsKey(currentNum)) {
                int lastIndex = lastSeenIndex.get(currentNum);

                if (i - lastIndex <= k) {
                    return true;
                }
            }

            lastSeenIndex.put(currentNum, i);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("--- Contem Duplicatas II ---");
        System.out.println("Digite a sequencia de numeros inteiros separados por espaco (Ex: 1 2 3 1):");

        String inputLine = scanner.nextLine();

        System.out.println("Digite o valor maximo de distancia (k):");
        int k = 0;
        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
        } else {
            System.out.println("Erro: k deve ser um numero inteiro.");
            scanner.close();
            return;
        }
        scanner.close();

        if (inputLine.trim().isEmpty()) {
            System.out.println("Nenhum numero inserido. Resultado: false");
            return;
        }

        try {
            String[] numStrings = inputLine.trim().split("\\s+");
            int[] nums = new int[numStrings.length];

            for (int i = 0; i < numStrings.length; i++) {
                if (numStrings[i].isEmpty()) continue;
                nums[i] = Integer.parseInt(numStrings[i]);
            }

            boolean result = solution.containsNearbyDuplicate(nums, k);

            System.out.print("\nArray de entrada: ");
            System.out.print(java.util.Arrays.toString(nums));
            System.out.println("\nDistancia k: " + k);
            System.out.println("Resultado: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, insira apenas numeros inteiros validos.");
        }
    }
}