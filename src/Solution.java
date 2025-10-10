import java.util.Scanner;

class Result {
    public static int solveMeFirst (int a, int b) {
        return a + b;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de A: ");
        int a = scanner.nextInt();

        System.out.print("Digite o valor de B: ");
        int b = scanner.nextInt();

        int soma = a + b;

        System.out.println("A soma de " + a + " e " + b + " é: " + soma);

        scanner.close();
    }
}