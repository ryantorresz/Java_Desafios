import java.util.Scanner;
import java.util.Arrays;

class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;

            int minHeight = Math.min(height[left], height[right]);

            int currentArea = width * minHeight;

            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Contêiner com Mais Água (Max Area) ---");
        System.out.println("Exemplo 1: [1,8,6,2,5,4,8,3,7] -> Saída Esperada: 49");
        System.out.println("Exemplo 2: [1,1] -> Saída Esperada: 1");
        System.out.println("------------------------------------------");

        while (true) {
            System.out.print("\nInsira as alturas do array separadas por vírgula (ex: 1,8,6,2,5,4,8,3,7) ou 'sair': ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Entrada inválida. Por favor, insira uma sequência de números.");
                continue;
            }

            try {
                String[] parts = input.replaceAll("\\s+", "").split(",");

                int[] height = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    height[i] = Integer.parseInt(parts[i]);
                }

                if (height.length < 2) {
                    System.out.println("O array deve conter pelo menos 2 elementos.");
                    continue;
                }

                int result = solver.maxArea(height);

                System.out.println("Array Original: " + Arrays.toString(height));
                System.out.println("Área Máxima Encontrada: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Erro: A entrada contém caracteres não numéricos. Por favor, use apenas números inteiros e vírgulas.");
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        scanner.close();
    }
}