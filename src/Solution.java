import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void countSwaps(List<Integer> a) {


        int n = a.size();
        int passos = 0;

        for (int i = 0; i < n; i++){

            int passosPassados = 0;

            for (int j = 0; j < n - 1; j++){
                if (a.get(j) > a.get(j + 1)){
                    int temporario = a.get(j);
                    a.set(j, a.get(j + 1));
                    a.set(j + 1, temporario);
                    passosPassados++;
                    passos++;
                }
            }
        }

        System.out.println("Array is sorted in " + passos + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(n - 1));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}