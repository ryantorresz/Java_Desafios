import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        scan.close();

        int negativeSubarrayCount = 0;


        for (int i = 0; i < n; i++) {

            int currentSum = 0;

            for (int j = i; j < n; j++) {

                currentSum += a[j];

                if (currentSum < 0) {
                    negativeSubarrayCount++;
                }
            }
        }

        System.out.println(negativeSubarrayCount);
    }
}