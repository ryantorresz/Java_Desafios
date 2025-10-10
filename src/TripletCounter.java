import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class TripletCounter {

    /**
     * Encontra o número de trigêmeos em progressão geométrica em 'arr' com razão 'r'.
     * A complexidade de tempo é O(N), onde N é o tamanho do array.
     */
    public static long countTriplets(List<Long> arr, long r) {

        // Armazena a contagem de elementos vistos até agora (potenciais arr[i])
        // Chave: valor do elemento, Valor: contagem de ocorrências
        Map<Long, Long> countElements = new HashMap<>();

        // Armazena a contagem de PARES (arr[i], arr[j]) encontrados até agora.
        // Chave: valor necessário para arr[k] (ou seja, arr[j] * r)
        // Valor: número de pares válidos que precisam dessa chave para se completar.
        Map<Long, Long> countPairsNeeded = new HashMap<>();

        long tripletCount = 0;

        for (long x : arr) {

            // 3. PASSO: Encontrar o terceiro elemento (arr[k]) e completar os trigêmeos.
            // Se 'x' estiver no mapa de pares, significa que ele é o terceiro elemento
            // de 'countPairsNeeded[x]' pares já encontrados.
            if (countPairsNeeded.containsKey(x)) {
                tripletCount += countPairsNeeded.get(x);
            }

            // 2. PASSO: Encontrar o segundo elemento (arr[j]) e formar novos pares.
            // O primeiro elemento necessário é arr[i] = x / r.
            if (r == 1 || (r != 0 && x % r == 0)) {
                long val_i = (r == 1) ? x : x / r;

                if (countElements.containsKey(val_i)) {
                    long count_i = countElements.get(val_i);
                    long val_k = x * r;

                    // Atualiza o mapa de pares: o novo par (arr[i], x) precisa de 'val_k'
                    // para se completar. A contagem de novos pares é 'count_i'.
                    countPairsNeeded.put(val_k, countPairsNeeded.getOrDefault(val_k, 0L) + count_i);
                }
            }

            // 1. PASSO: 'x' é um potencial primeiro elemento (arr[i]).
            // Atualiza a contagem total de 'x's vistos.
            countElements.put(x, countElements.getOrDefault(x, 0L) + 1);
        }

        return tripletCount;
    }
    public static void main(String[] args) {
        System.out.println("--- Teste da Função countTriplets (Progressão Geométrica) ---");

        List<Long> arr0 = Arrays.asList(1L, 2L, 2L, 4L);
        long r0 = 2;
        long result0 = countTriplets(arr0, r0);
        System.out.printf("\nExemplo 0: arr=%s, r=%d\n", arr0, r0, result0);

        List<Long> arr1 = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
        long r1 = 3;
        long result1 = countTriplets(arr1, r1);
        System.out.printf("\nExemplo 1: arr=%s, r=%d\n", arr1, r1, result1);

        List<Long> arr2 = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        long r2 = 5;
        long result2 = countTriplets(arr2, r2);
        System.out.printf("\nExemplo 2: arr=%s, r=%d\n", arr2, r2, result2);

        List<Long> arr3 = Arrays.asList(2L, 2L, 2L, 2L);
        long r3 = 1;
        long result3 = countTriplets(arr3, r3);
        System.out.printf("\nExemplo 3 (r=1): arr=%s, r=%d\n", arr3, r3, result3);
    }
}