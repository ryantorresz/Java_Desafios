import java.util.List;
import java.util.Arrays;
import java.lang.Math;

class Result {

    public static int flippingMatrix(List<List<Integer>> matrix) {

        int size2n = matrix.size();
        int n = size2n / 2;

        // Usamos 'long' para a soma total para garantir que não haja overflow.
        long maxSum = 0;

        // Iteramos apenas sobre o quadrante superior esquerdo (0 <= i < n, 0 <= j < n)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Elementos simétricos
                int r_sym = size2n - 1 - i;
                int c_sym = size2n - 1 - j;

                // 1. Superior Esquerdo (Original)
                int val1 = matrix.get(i).get(j);

                // 2. Superior Direito
                int val2 = matrix.get(i).get(c_sym);

                // 3. Inferior Esquerdo
                int val3 = matrix.get(r_sym).get(j);

                // 4. Inferior Direito (Diagonalmente oposto)
                int val4 = matrix.get(r_sym).get(c_sym);

                // Escolhe o maior dos quatro valores simétricos
                int maxVal = Math.max(val1, Math.max(val2, Math.max(val3, val4)));

                maxSum += maxVal;
            }
        }

        // Retorna a soma máxima.
        return (int) maxSum;
    }

}

public class MatrixFlipper {

    public static void main(String[] args) {

        System.out.println("--- Teste da Função flippingMatrix ---");

        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)
        );

        System.out.println("\nMatriz Original (4x4):");
        for (List<Integer> row : matrix) {
            System.out.println(row);
        }

        // Chama a função estática da classe Result
        int result = Result.flippingMatrix(matrix);

        System.out.println("\nSoma Máxima do Quadrante Superior Esquerdo (n=2):");
        System.out.println("Resultado: " + result);
    }
}