import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;

        long high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        long minSpeed = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                minSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) minSpeed;
    }

    private boolean canFinish(int[] piles, int h, long k) {
        long hoursNeeded = 0;

        for (int pile : piles) {
            hoursNeeded += ((long)pile + k - 1) / k;

            if (hoursNeeded > h) {
                return false;
            }
        }

        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Casos de teste
        int[][] testPiles = {
                {3, 6, 7, 11},     // Caso 1
                {30, 11, 23, 4, 20}, // Caso 2
                {30, 11, 23, 4, 20}, // Caso 3
                {1, 1, 1, 1},       // Caso 4
                {1000000000},       // Caso 5 - pile grande
                {2, 2}              // Caso 6
        };

        int[] testHours = {
                8,   // Caso 1
                5,   // Caso 2
                6,   // Caso 3
                4,   // Caso 4
                2,   // Caso 5
                2    // Caso 6
        };

        int[] expectedResults = {
                4,  // Caso 1: k=4
                30, // Caso 2: k=30
                23, // Caso 3: k=23
                1,  // Caso 4: k=1
                500000000, // Caso 5: k=500000000
                2
        };

        System.out.println("=== Testando Koko Eating Bananas ===\n");

        for (int i = 0; i < testPiles.length; i++) {
            int result = solution.minEatingSpeed(testPiles[i], testHours[i]);
            boolean passed = (result == expectedResults[i]);

            System.out.println("Caso " + (i + 1) + ":");
            System.out.println("  Pilhas: " + Arrays.toString(testPiles[i]));
            System.out.println("  Horas (h): " + testHours[i]);
            System.out.println("  Velocidade esperada: " + expectedResults[i]);
            System.out.println("  Velocidade calculada: " + result);
            System.out.println("  Status: " + (passed ? "✓ PASSOU" : "✗ FALHOU"));
            System.out.println();
        }

        System.out.println("=== Teste Interativo ===");
        int[] customPiles = {3, 6, 7, 11};
        int customHours = 8;
        int customResult = solution.minEatingSpeed(customPiles, customHours);
        System.out.println("Pilhas: " + Arrays.toString(customPiles));
        System.out.println("Horas disponíveis: " + customHours);
        System.out.println("Velocidade mínima necessária: " + customResult);
    }
}