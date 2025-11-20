import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        BitSet[] B = new BitSet[3];
        B[1] = B1;
        B[2] = B2;

        for (int i = 0; i < M; i++) {
            String operation = scanner.next();
            int arg1 = scanner.nextInt();

            int arg2 = scanner.nextInt();

            switch (operation) {
                case "AND":
                    B[arg1].and(B[arg2]);
                    break;

                case "OR":
                    B[arg1].or(B[arg2]);
                    break;

                case "XOR":
                    B[arg1].xor(B[arg2]);
                    break;

                case "FLIP":
                    B[arg1].flip(arg2);
                    break;

                case "SET":
                    B[arg1].set(arg2);
                    break;
            }

            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }

        scanner.close();
    }
}