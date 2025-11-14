import java.util.Arrays;

class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        // 1. Ordena o array de poções para permitir a Busca Binária.
        Arrays.sort(potions);

        int[] result = new int[n];

        // 2. Itera sobre cada feitiço e aplica a Busca Binária.
        for (int i = 0; i < n; i++) {
            long spellStrength = spells[i];

            // Calcula a força mínima da poção necessária (minPotionNeeded).
            // Usa (success + spellStrength - 1) / spellStrength para calcular o teto (ceil) de forma segura.
            long minPotionNeeded = (success + spellStrength - 1) / spellStrength;

            // Encontra o primeiro índice (firstSuccessfulIndex) tal que potions[j] >= minPotionNeeded.
            int firstSuccessfulIndex = binarySearchForMinIndex(potions, minPotionNeeded);

            // O número de pares bem-sucedidos é o número de poções restantes a partir desse índice.
            // Se o índice for 'm', significa que não há poções suficientes.
            if (firstSuccessfulIndex == m) {
                result[i] = 0;
            } else {
                result[i] = m - firstSuccessfulIndex;
            }
        }

        return result;
    }

    /**
     * Busca Binária customizada (Lower Bound) para encontrar o primeiro índice >= target.
     */
    private int binarySearchForMinIndex(int[] arr, long target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Padrão se não encontrar nada (todos os elementos são menores)

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                // Este é um resultado possível, guarda e tenta buscar algo menor à esquerda.
                ans = mid;
                high = mid - 1;
            } else {
                // Muito pequeno, move o limite inferior.
                low = mid + 1;
            }
        }
        return ans;
    }
}

// 3. Classe Principal para Execução e Teste
public class Main {
    public static void main(String[] args) {
        Solution solver = new Solution();

        // --- Exemplo 1 (do LeetCode) ---
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        long success1 = 7;

        int[] result1 = solver.successfulPairs(spells1, potions1, success1);

        System.out.println("--- Teste 1 ---");
        System.out.println("Feitiços: " + Arrays.toString(spells1));
        System.out.println("Poções: " + Arrays.toString(potions1));
        System.out.println("Successo: " + success1);
        System.out.println("Pares Bem-Sucedidos: " + Arrays.toString(result1)); // Esperado: [4, 0, 3]
        System.out.println("---------------------------------------\n");

        // --- Exemplo 2 ---
        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        long success2 = 16;

        int[] result2 = solver.successfulPairs(spells2, potions2, success2);

        System.out.println("--- Teste 2 ---");
        System.out.println("Feitiços: " + Arrays.toString(spells2));
        System.out.println("Poções (Antes de ordenar): " + Arrays.toString(new int[]{8, 5, 8}));
        System.out.println("Successo: " + success2);
        System.out.println("Pares Bem-Sucedidos: " + Arrays.toString(result2)); // Esperado: [2, 0, 2]
        System.out.println("---------------------------------------");
    }
}