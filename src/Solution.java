import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Ponteiro de escrita e contador de elementos válidos

        // Percorre todos os elementos do array
        for (int i = 0; i < nums.length; i++) {

            // Se o elemento atual for diferente do valor a ser removido (é um elemento VÁLIDO)
            if (nums[i] != val) {
                // Move o elemento válido para a posição 'k'
                nums[k] = nums[i];
                // Incrementa 'k' para a próxima posição livre
                k++;
            }
            // Se nums[i] == val, 'i' avança, mas 'k' fica parado,
            // resultando na sobreposição do valor indesejado.
        }

        // 'k' é o novo tamanho lógico do array
        return k;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // --- Exemplo 1 ---
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;

        System.out.println("--- Teste Exemplo 1 ---");
        System.out.println("Array de entrada: " + Arrays.toString(nums1) + ", Valor a remover: " + val1);

        int k1 = solution.removeElement(nums1, val1);

        System.out.println("Saída k: " + k1);

        // Imprime os primeiros k elementos (o que interessa ao juiz)
        System.out.print("Primeiros k elementos de nums: [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Resultado esperado: 2, [2, 2]

        System.out.println("\n");

        // --- Exemplo 2 ---
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;

        System.out.println("--- Teste Exemplo 2 ---");
        System.out.println("Array de entrada: " + Arrays.toString(nums2) + ", Valor a remover: " + val2);

        int k2 = solution.removeElement(nums2, val2);

        System.out.println("Saída k: " + k2);

        // Imprime os primeiros k elementos
        System.out.print("Primeiros k elementos de nums: [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]");
        // Resultado esperado: 5. A ordem dos elementos é permitida.
    }
}