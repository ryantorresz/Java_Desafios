class GuessGame {
    private int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }

        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int pick1 = 6;     // O número secreto
        int n1 = 10;       // Limite superior do intervalo [1, 10]

        Solution solver1 = new Solution(pick1);
        int result1 = solver1.guessNumber(n1);

        System.out.println("--- Teste 1: n=" + n1 + ", pick=" + pick1 + " ---");
        System.out.println("O número secreto é: " + result1);
        System.out.println("Esperado: " + pick1);
        System.out.println("---------------------------------------\n");


        int pick2 = 1;     // O número secreto
        int n2 = 1;        // Limite superior do intervalo [1, 1]

        Solution solver2 = new Solution(pick2);
        int result2 = solver2.guessNumber(n2);

        System.out.println("--- Teste 2: n=" + n2 + ", pick=" + pick2 + " ---");
        System.out.println("O número secreto é: " + result2);
        System.out.println("Esperado: " + pick2);
        System.out.println("---------------------------------------\n");


        int pick3 = 9;     // O número secreto
        int n3 = 10;       // Limite superior do intervalo [1, 10]

        Solution solver3 = new Solution(pick3);
        int result3 = solver3.guessNumber(n3);

        System.out.println("--- Teste 3: n=" + n3 + ", pick=" + pick3 + " ---");
        System.out.println("O número secreto é: " + result3);
        System.out.println("Esperado: " + pick3);
        System.out.println("---------------------------------------");
    }
}