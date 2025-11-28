public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Array de testes
        int[][] testCases = {
                {2, 3, 1, 1, 4},      // Caso 1: mínimo 2 pulos
                {2, 1, 3, 2, 1, 4},   // Caso 2: mínimo 3 pulos
                {1, 1, 1, 1, 1},      // Caso 3: mínimo 4 pulos
                {3, 2, 1, 0, 4},      // Caso 4: impossível (mas nosso algoritmo não chega aqui)
                {0},                   // Caso 5: já está no final (0 pulos)
                {1, 2, 3, 4, 5},      // Caso 6: mínimo 3 pulos
                {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3} // Caso 7: complexo
        };

        System.out.println("=== TESTES JUMP GAME II ===\n");

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int result = solution.jump(nums);

            System.out.println("Teste " + (i + 1) + ":");
            System.out.print("Array: [");
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j]);
                if (j < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Mínimo de pulos: " + result);
            System.out.println("---");
        }

        // Teste adicional com explicação passo a passo
        System.out.println("\n=== EXEMPLO DETALHADO ===");
        int[] detailedExample = {2, 3, 1, 1, 4};
        System.out.println("Array: [2, 3, 1, 1, 4]");
        System.out.println("Execução passo a passo:");

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < detailedExample.length - 1; i++) {
            farthest = Math.max(farthest, i + detailedExample[i]);
            System.out.printf("i=%d, nums[%d]=%d, farthest=%d, currentEnd=%d, jumps=%d",
                    i, i, detailedExample[i], farthest, currentEnd, jumps);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                System.out.printf(" → PULO! jumps=%d, novo currentEnd=%d", jumps, currentEnd);
            }
            System.out.println();
        }

        System.out.println("\nResultado final: " + jumps + " pulos");
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}