public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int anterior_2 = 1;
        int anterior_1 = 2;
        int atual = 0;

        for (int i = 3; i <= n; i++) {
            atual = anterior_1 + anterior_2;

            anterior_2 = anterior_1;
            anterior_1 = atual;
        }

        return atual;
    }


    public static void main(String[] args) {
        Solution solver = new Solution();

        int n1 = 2;
        int resultado1 = solver.climbStairs(n1);
        System.out.println("Para n = " + n1 + " degraus: " + resultado1 + " maneiras.");

        int n2 = 3;
        int resultado2 = solver.climbStairs(n2);
        System.out.println("Para n = " + n2 + " degraus: " + resultado2 + " maneiras.");

        int n3 = 5;
        int resultado3 = solver.climbStairs(n3);
        System.out.println("Para n = " + n3 + " degraus: " + resultado3 + " maneiras.");

        int n4 = 10;
        int resultado4 = solver.climbStairs(n4);
        System.out.println("Para n = " + n4 + " degraus: " + resultado4 + " maneiras.");
    }
}