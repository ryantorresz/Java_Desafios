import java.util.*;

class Result {

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        Map<String, Integer> frenquecyMap = new HashMap<>();

        for (String s : stringList) {
            frenquecyMap.put(s, frenquecyMap.getOrDefault(s, 0) + 1);
        }

        List<Integer> results = new ArrayList<>();

        for (String query : queries) {

            int count = frenquecyMap.getOrDefault(query, 0);
            results.add(count);
        }

        return results;
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("||          CONTADOR DE STRINGS         ||");
        System.out.println("==========================================");

        // --- 1. LEITURA DA LISTA DE ENTRADA (stringList) ---
        System.out.print("\n[PASSO 1/4] Digite o número de strings de ENTRADA (N): ");
        int stringListSize = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        List<String> stringList = new ArrayList<>();
        System.out.println(">> Digite as " + stringListSize + " strings de entrada (uma por linha):");
        for (int i = 0; i < stringListSize; i++) {
            System.out.print("   String " + (i + 1) + ": ");
            stringList.add(scanner.nextLine());
        }

        // --- 2. LEITURA DA LISTA DE CONSULTAS (queries) ---
        System.out.print("\n[PASSO 2/4] Digite o número de strings de CONSULTA (Q): ");
        int queriesSize = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha

        List<String> queries = new ArrayList<>();
        System.out.println(">> Digite as " + queriesSize + " strings de consulta (uma por linha):");
        for (int i = 0; i < queriesSize; i++) {
            System.out.print("   Consulta " + (i + 1) + ": ");
            queries.add(scanner.nextLine());
        }

        // --- 3. CÁLCULO E RESULTADO ---
        System.out.println("\n[PASSO 3/4] Processando as consultas...");
        List<Integer> results = Result.matchingStrings(stringList, queries);

        // --- 4. EXIBIÇÃO DA SAÍDA ---
        System.out.println("\n==========================================");
        System.out.println("||            RESULTADOS                ||");
        System.out.println("==========================================");

        for (int i = 0; i < queries.size(); i++) {
            System.out.printf("'%s' ocorre %d vezes.\n", queries.get(i), results.get(i));
        }

        System.out.println("\n[PASSO 4/4] Operação concluída com sucesso.");
        scanner.close();
    }
}