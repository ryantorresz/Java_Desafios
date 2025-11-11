import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Quantas linhas de números existirão
        System.out.print("Digite o número de linhas: ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Lendo cada linha de números
        for (int i = 0; i < n; i++) {
            System.out.print("Quantos números na linha " + (i + 1) + "? ");
            int d = sc.nextInt();
            ArrayList<Integer> innerList = new ArrayList<>();

            if (d > 0) {
                System.out.println("Digite " + d + " números separados por espaço:");
            }

            for (int j = 0; j < d; j++) {
                innerList.add(sc.nextInt());
            }

            list.add(innerList);
        }

        // Quantas consultas (queries)
        System.out.print("Digite o número de consultas: ");
        int q = sc.nextInt();

        // Executando as consultas
        for (int i = 0; i < q; i++) {
            System.out.print("Consulta " + (i + 1) + " (linha e posição): ");
            int x = sc.nextInt(); // número da linha (1-indexado)
            int y = sc.nextInt(); // posição na linha (1-indexado)

            try {
                int valor = list.get(x - 1).get(y - 1);
                System.out.println("Resultado: " + valor);
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
