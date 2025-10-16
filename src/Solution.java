import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class Solution {


    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        // Mapa para armazenar a frequência de cada linha única como String.
        Map<String, Integer> rowCounts = new HashMap<>();

        // 1. Contar a Frequência de Todas as Linhas
        for (int[] row : grid) {
            String rowString = arrayToString(row);
            rowCounts.put(rowString, rowCounts.getOrDefault(rowString, 0) + 1);
        }

        // 2. Iterar pelas Colunas e Verificar a Correspondência no Mapa
        for (int j = 0; j < n; j++) { // Itera sobre as colunas
            // Constrói a representação em String da coluna j
            StringBuilder colBuilder = new StringBuilder();

            for (int i = 0; i < n; i++) { // Itera sobre os elementos da coluna j
                colBuilder.append(grid[i][j]);
                if (i < n - 1) {
                    colBuilder.append(","); // Usa o mesmo delimitador
                }
            }

            String colString = colBuilder.toString();

            // Adiciona a frequência da linha correspondente à contagem total.
            count += rowCounts.getOrDefault(colString, 0);
        }

        return count;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();


        int[][] grid1 = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int result1 = solution.equalPairs(grid1);
        System.out.println("Exemplo 1:");
        System.out.println("Entrada: [[3,2,1],[1,7,6],[2,7,7]]");
        System.out.println("Saída Obtida: " + result1);
        System.out.println("---------------------------------");

        int[][] grid2 = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        int result2 = solution.equalPairs(grid2);
        System.out.println("Exemplo 2:");
        System.out.println("Entrada: [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]");
        System.out.println("Saída Obtida: " + result2);
        System.out.println("---------------------------------");

        int[][] grid3 = {{1, 1}, {1, 1}};
        int result3 = solution.equalPairs(grid3);
        System.out.println("Exemplo 3 (Extra):");
        System.out.println("Entrada: [[1,1],[1,1]]");
        System.out.println("Saída Obtida: " + result3);
    }
}