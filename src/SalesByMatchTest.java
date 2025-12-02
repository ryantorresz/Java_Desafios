import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Result {

    public static int sockMerchant(int n, List<Integer> ar) {
        int numPares = 0;

        Set<Integer> meiasImpares = new HashSet<>();

        for (int cor : ar) {
            if (meiasImpares.contains(cor)) {

                meiasImpares.remove(cor);

                numPares++;
            } else {

                meiasImpares.add(cor);
            }
        }
        return numPares;
    }
}

public class SalesByMatchTest {
    public static void main(String[] args) {
        int n1 = 9;
        List<Integer> ar1 = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int resultado1 = Result.sockMerchant(n1, ar1);
        System.out.println("Exemplo 1: Pares encontrados: " + resultado1);

        int n2 = 10;
        List<Integer> ar2 = List.of(1, 1, 3, 1, 2, 1, 3, 3, 3, 3);
        int resultado2 = Result.sockMerchant(n2, ar2);
        System.out.println("Exemplo 2: Pares encontrados: " + resultado2);
    }
}