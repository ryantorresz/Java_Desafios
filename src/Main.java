import java.util.Scanner;
import java.util.Arrays;


public class Main {


    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k > nums.length || k <= 0) {
            throw new IllegalArgumentException("Parâmetros inválidos: k deve ser <= n e > 0.");
        }

        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        long maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- 643. Maximum Average Subarray I ---");

        try {
            System.out.print("Insira os números do array (separados por espaço, ex: 1 12 -5 -6 50 3): ");
            String inputLine = scanner.nextLine();

            String[] numStrings = inputLine.trim().split("\\s+");
            int[] nums = new int[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                nums[i] = Integer.parseInt(numStrings[i]);
            }

            System.out.print("Insira o tamanho da submatriz k (ex: 4): ");
            int k = scanner.nextInt();

            Main mainInstance = new Main(); // Cria uma instância da classe para chamar o método
            double maxAverage = mainInstance.findMaxAverage(nums, k);

            System.out.println("\n-------------------------------------------");
            System.out.println("Array de Entrada (nums): " + Arrays.toString(nums));
            System.out.println("Tamanho da Submatriz (k): " + k);
            System.out.printf("O MÁXIMO VALOR MÉDIO é: %.5f\n", maxAverage);
            System.out.println("-------------------------------------------");

        } catch (java.util.InputMismatchException e) {
            System.err.println("Erro: A entrada de k é inválida. Por favor, insira um número inteiro.");
        } catch (NumberFormatException e) {
            System.err.println("Erro: A entrada de números do array é inválida. Por favor, insira apenas números inteiros separados por espaço.");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de Validação: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}