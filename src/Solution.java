import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;
        for (int element : ar) {
            sum += element;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array (n): ");
        int n = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite os " + n + " elementos do array, separados por espaço:");

        String linhaElementos = scanner.nextLine();

        List<Integer> ar = new ArrayList<>();
        String[] elementos = linhaElementos.split(" ");
        for (String elemento : elementos) {
            try {
                ar.add(Integer.parseInt(elemento));
            } catch (NumberFormatException e) {
                System.out.println("Aviso: O valor '" + elemento + "' não é um número válido e foi ignorado.");
            }
        }

        int resultado = simpleArraySum(ar);
        System.out.println("\nA soma total dos elementos é: " + resultado);

        scanner.close();
    }
}