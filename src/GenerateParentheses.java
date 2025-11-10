import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String currentString, int open, int close, int max) {
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }

        if (open < max) {
            backtrack(result, currentString + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(result, currentString + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        GenerateParentheses gp = new GenerateParentheses();
        List<String> combinations1 = gp.generateParenthesis(n1);

        System.out.println("--- Gerando parênteses bem-formados para n = " + n1 + " ---");
        System.out.println("Combinações encontradas: " + combinations1.size());
        System.out.println(combinations1);

        System.out.println("\n--- Exemplo 2: n = 1 ---");
        int n2 = 1;
        List<String> combinations2 = gp.generateParenthesis(n2);
        System.out.println("Combinações encontradas: " + combinations2.size());
        System.out.println(combinations2);

    }
}
