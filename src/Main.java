import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapeamento dos dígitos para letras
    private final String[] digitToLetters = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Caso base: se a string estiver vazia, retorna lista vazia
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Se atingimos o final dos dígitos, adiciona a combinação ao resultado
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Pega o dígito atual e suas letras correspondentes
        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];

        // Para cada letra correspondente ao dígito, faz recursão
        for (char letter : letters.toCharArray()) {
            current.append(letter); // Adiciona a letra
            backtrack(result, digits, current, index + 1); // Chama para próximo dígito
            current.deleteCharAt(current.length() - 1); // Backtrack: remove a letra
        }
    }

    // Método main para testar
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Casos de teste
        String[] testCases = {
                "23",
                "",
                "2",
                "79",
                "234"
        };

        System.out.println("=== Letter Combinations of a Phone Number ===\n");

        for (String digits : testCases) {
            List<String> combinations = solution.letterCombinations(digits);

            System.out.println("Input: \"" + digits + "\"");
            System.out.println("Output: " + combinations);
            System.out.println("Number of combinations: " + combinations.size());
            System.out.println();
        }

        // Exemplo detalhado
        System.out.println("=== Exemplo Detalhado ===");
        String example = "23";
        List<String> result = solution.letterCombinations(example);
        System.out.println("Dígitos: " + example);
        System.out.println("Combinações: " + result);
        System.out.println("Explicação:");
        System.out.println("  2 -> abc, 3 -> def");
        System.out.println("  Combinações: a+d, a+e, a+f, b+d, b+e, b+f, c+d, c+e, c+f");
    }
}