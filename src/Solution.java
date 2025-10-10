import java.util.Scanner;

interface AdvancedArithmetic {

    int divisorSum(int n);

}

class Calculator implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        int sum = 0;


        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum+= i;
            } if (i * i != n) {
                sum += (n / i);
            }
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an integer n (e.g., 6):");
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new Calculator();

        int sum = myCalculator.divisorSum(n);

        System.out.println("I implemented: AdvancedArithmetic");
        System.out.println(sum);
    }
}




