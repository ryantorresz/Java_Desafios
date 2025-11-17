import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current,
                           int k, int remaining, int start) {
        // Caso base: se usamos k números
        if (current.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Tenta números de start até 9
        for (int i = start; i <= 9; i++) {
            // Poda: se o número atual é muito grande, para o loop
            if (i > remaining) {
                break;
            }

            current.add(i);
            backtrack(result, current, k, remaining - i, i + 1);
            current.remove(current.size() - 1); // backtrack
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("=== Teste Combination Sum III ===");

        // Teste 1
        System.out.println("\nTeste 1: k=3, n=7");
        List<List<Integer>> result1 = solution.combinationSum3(3, 7);
        printResult(result1);

        // Teste 2
        System.out.println("\nTeste 2: k=3, n=9");
        List<List<Integer>> result2 = solution.combinationSum3(3, 9);
        printResult(result2);

        // Teste 3
        System.out.println("\nTeste 3: k=4, n=1");
        List<List<Integer>> result3 = solution.combinationSum3(4, 1);
        printResult(result3);

        // Teste 4
        System.out.println("\nTeste 4: k=3, n=15");
        List<List<Integer>> result4 = solution.combinationSum3(3, 15);
        printResult(result4);

        // Teste 5
        System.out.println("\nTeste 5: k=2, n=18");
        List<List<Integer>> result5 = solution.combinationSum3(2, 18);
        printResult(result5);
    }

    // Método auxiliar para imprimir resultados
    private static void printResult(List<List<Integer>> result) {
        if (result.isEmpty()) {
            System.out.println("Nenhuma combinação encontrada");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println("Combinação " + (i + 1) + ": " + result.get(i));
            }
        }
    }
}