import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiagonalCalculator {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr.get(i).get(i);

            secondaryDiagonalSum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da matriz quadrada (N):");

        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Erro: Entrada inválida para o tamanho.");
            return;
        }

        List<List<Integer>> arr = new ArrayList<>();
        System.out.println("Digite os elementos da matriz, linha por linha, separados por espaço:");

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (scanner.hasNextInt()) {
                    row.add(scanner.nextInt());
                } else {
                    System.out.println("Erro: Entrada inválida na linha " + (i + 1) + ", coluna " + (j + 1));
                    return;
                }
            }
            arr.add(row);
        }

        int result = diagonalDifference(arr);

        System.out.println("\n------------------------------------");
        System.out.println("O resultado da Diferença Diagonal é:");
        System.out.println(result);
        System.out.println("------------------------------------");

        scanner.close();
    }
}