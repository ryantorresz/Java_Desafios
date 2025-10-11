import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("--- Verificador de Duplicatas ---");
        System.out.println("Digite a sequencia de numeros inteiros, separados por espaco:");
        System.out.println("Exemplo: 1 2 3 1");

        String inputLine = scanner.nextLine();
        scanner.close();

        if (inputLine.trim().isEmpty()) {
            System.out.println("Nenhum numero inserido.");
            return;
        }

        try {
            String[] numStrings = inputLine.trim().split("\\s+");

            int[] nums = new int[numStrings.length];

            for (int i = 0; i < numStrings.length; i++) {
                nums[i] = Integer.parseInt(numStrings[i]);
            }

            boolean result = solution.containsDuplicate(nums);

            System.out.print("\nArray de entrada: [");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + (i < nums.length - 1 ? ", " : ""));
            }
            System.out.println("]");

            System.out.println("Resultado: " + result);
            System.out.println(result ? "Existem elementos duplicados." : "Todos os elementos sao distintos.");

        } catch (NumberFormatException e) {
            System.out.println("Erro: Por favor, insira apenas numeros inteiros validos.");
        }
    }
}