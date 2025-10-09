import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static int hourglassSum(List<List<Integer>> arr) {

        int maxSum = Integer.MIN_VALUE;

        int rows = arr.size();
        int cols = arr.get(0).size();

        for(int i = 0; i <= rows - 3; i++) {
            for(int j = 0; j <= cols - 3; j++) {

                int currentSum = 0;

                currentSum += arr.get(i).get(j);
                currentSum += arr.get(i).get(j + 1);
                currentSum += arr.get(i).get(j + 2);

                currentSum += arr.get(i + 1).get(j + 1);

                currentSum += arr.get(i + 2).get(j);
                currentSum += arr.get(i + 2).get(j + 1);
                currentSum += arr.get(i + 2).get(j + 2);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;

    }
    public static void main(String[] args) throws IOException {

        // --- INSTRUÇÕES DE INTERAÇÃO ---
        System.out.println("=============================================");
        System.out.println("  CÁLCULO DA SOMA MÁXIMA DA AMPULHETA (6x6)  ");
        System.out.println("=============================================");
        System.out.println("INSTRUÇÃO: Digite os 6x6 números do array.");
        System.out.println("Cada linha deve conter 6 números separados por espaço (Enter a cada linha):");
        System.out.println("---------------------------------------------");


        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Leitura do array 6x6
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            // Mensagem de guia para a linha atual
            System.out.print("Linha " + (i + 1) + "/6: ");

            try {
                // A lógica de leitura é complexa, mas agora está guiada pela mensagem acima
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Calcula o resultado
        int result = hourglassSum(arr);

        // --- EXIBIÇÃO DO RESULTADO ---
        System.out.println("---------------------------------------------");
        System.out.print("A Soma Máxima da Ampulheta é: ");
        System.out.println(result);
        System.out.println("Operação concluída com sucesso! ✅");
        System.out.println("=============================================");

        bufferedReader.close();
    }
}

