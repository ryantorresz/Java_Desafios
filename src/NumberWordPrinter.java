import java.util.Scanner;

public class NumberWordPrinter {

    public static void main(String[] args) {
                System.out.println("-----------------");
                System.out.println("Digite um número:");
                System.out.println("-----------------");
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                scanner.close();

                String[] words = {
                        "", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"
                };

                if (n >= 1 && n <= 9) {
                    System.out.println(words[n]);
                } else {
                    System.out.println("Greater than 9");
                }

    }
}