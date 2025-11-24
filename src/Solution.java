public class Solution {

    // Solução usando programação dinâmica
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Criar uma tabela DP para armazenar os resultados dos subproblemas
        int[][] dp = new int[m + 1][n + 1];

        // Preencher casos base
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Remover todos os caracteres de word1
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserir todos os caracteres de word2
        }

        // Preencher a tabela DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Caracteres iguais, não há operação necessária
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Escolher a operação com menor custo:
                    // 1. Inserção (dp[i][j-1] + 1)
                    // 2. Remoção (dp[i-1][j] + 1)
                    // 3. Substituição (dp[i-1][j-1] + 1)
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i][j - 1], dp[i - 1][j]),
                            dp[i - 1][j - 1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    // Versão otimizada em espaço
    public static int minDistanceOptimized(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if (m < n) {
            return minDistanceOptimized(word2, word1);
        }

        int[] dp = new int[n + 1];

        // Inicializar a primeira linha
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(
                            Math.min(dp[j - 1], dp[j]),
                            prev
                    );
                }
                prev = temp;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
                {"horse", "ros"},
                {"intention", "execution"},
                {"", "abc"},
                {"abc", ""},
                {"abc", "abc"},
                {"sunday", "saturday"}
        };

        System.out.println("=== Testes da Distância de Edição ===\n");

        for (String[] testCase : testCases) {
            String word1 = testCase[0];
            String word2 = testCase[1];

            int result1 = minDistance(word1, word2);
            int result2 = minDistanceOptimized(word1, word2);

            System.out.printf("Word1: \"%s\"", word1);
            System.out.printf(" | Word2: \"%s\"", word2);
            System.out.printf(" | Distância: %d", result1);
            System.out.printf(" | Otimizada: %d", result2);
            System.out.printf(" | ✓: %s\n", result1 == result2 ? "Sim" : "Não");
        }

        // Demonstração detalhada
        System.out.println("\n=== Demonstração Detalhada ===");
        String word1 = "horse";
        String word2 = "ros";
        System.out.printf("\nTransformando \"%s\" em \"%s\":\n", word1, word2);

        int distance = minDistance(word1, word2);
        System.out.printf("Número mínimo de operações: %d\n", distance);

        // Explicação das operações
        System.out.println("\nOperações possíveis:");
        System.out.println("1. horse -> rorse (substituir 'h' por 'r')");
        System.out.println("2. rorse -> rose (remover 'r')");
        System.out.println("3. rose -> ros (remover 'e')");
    }
}