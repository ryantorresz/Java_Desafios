import java.util.Scanner;

class Result {
    public static void staircase(int n) {

        for (int i = 1; i <= n; i++) {
            int numEspacos = n - 1;

            StringBuilder linha = new StringBuilder();

            for (int j = 0; j < numEspacos; j++) {
                linha.append(" ");
            }
            for (int k = 0; k < i; k++) {
                linha.append("#");
            }

            System.out.println(linha.toString());
        }
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho (N) da escada:");

        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();

            Result.staircase(n);
        } else {
            System.out.println("Erro: Entrada invalida. Por favor, digite um numero inteiro.");
        }

        scanner.close();
    }
}