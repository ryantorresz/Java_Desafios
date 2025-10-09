import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;

        System.out.println("=========================================");
        System.out.println("|| Teste de Conversão de String para Int ||");
        System.out.println("=========================================");

        System.out.print("Digite uma string (ex: 3 ou za): ");

        s = in.next();
        in.close();

        try {
            int integerValue = Integer.parseInt(s);

            System.out.println("\n✅ SUCESSO na Conversão!");
            System.out.print("O valor inteiro é: ");
            System.out.println(integerValue);

        } catch (NumberFormatException e) {
            System.out.println("\n❌ ERRO de Conversão!");
            System.out.println("Resultado: Bad String");
        }

        System.out.println("-----------------------------------------");
        System.out.println("Programa encerrado.");
    }
}

