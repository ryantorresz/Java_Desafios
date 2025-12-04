import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int minimumDistances(int[] a) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int distance = i - map.get(a[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
                // Otimização: se a distância for 1, já é a mínima possível
                if (minDistance == 1) {
                    return 1;
                }
            }
            map.put(a[i], i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}