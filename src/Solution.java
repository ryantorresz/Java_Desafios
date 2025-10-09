import java.util.Scanner;

class Exception extends java.lang.Exception {
    public Exception(String message) {
        super(message);
    }
}

class MyCalculator {
    long power(int n, int p) throws Exception {

        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be a zero.");

        }
        if (n < 0 || p< 0) {
            throw new Exception("n or p should not be negative.");
        }


        return (long) Math.pow(n,p);
    }
}


public class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        // Novo e aprimorado cabeçalho
        System.out.println("\n==============================================");
        System.out.println("         Calculadora de Potência (n^p)        ");
        System.out.println("==============================================");
        System.out.println("Instruções: Digite 'n' e 'p' para calcular n^p.");
        System.out.println("Para encerrar o programa, insira um caractere não-numérico.\n");
        // O '\n' final garante uma linha em branco antes da primeira solicitação de entrada.

        // Usamos um contador para rastrear a ordem das entradas
        int contador = 1;

        // O loop continua enquanto houver números inteiros na entrada para 'n' e 'p'
        while (in.hasNextInt()) {

            // Adiciona uma linha de separação para cada nova entrada
            System.out.println("\n----------------- ENTRADA #" + contador + " -----------------");

            // Solicita e lê o valor de n (base)
            System.out.print("Digite o valor de 'n' (base): ");
            int n = in.nextInt();

            // Solicita e lê o valor de p (expoente)
            System.out.print("Digite o valor de 'p' (expoente): ");
            int p = in.nextInt();

            System.out.println("----------------------------------------");

            try {
                // Imprime o resultado formatado
                System.out.println("RESULTADO (" + n + "^" + p + "): " + my_calculator.power(n, p));
            } catch (Exception e) {
                // Imprime o erro formatado
                System.out.println("ERRO: " + e.getClass().getName() + ": " + e.getMessage());
            }

            // Linha em branco para separar a saída do resultado da próxima entrada
            System.out.println("\n");

            contador++;
        }

        // Mensagem de encerramento
        System.out.println("\n==============================================");
        System.out.println("Programa encerrado. Obrigado!");
        System.out.println("==============================================\n");
    }
}
