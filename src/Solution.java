import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        String inputData = "9\n-100\n50\n0\n56.6\n90\n0.12\n.12\n02.34\n000.000";
        Scanner sc = new Scanner(inputData);

        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();


        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                BigDecimal bd1 = new BigDecimal(s1);
                BigDecimal bd2 = new BigDecimal(s2);

                int comparison = bd2.compareTo(bd1);

                return comparison;
            }
        };

        Arrays.sort(s, customComparator);

        System.out.println("Resultados da Ordenacao Decrescente:");
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}