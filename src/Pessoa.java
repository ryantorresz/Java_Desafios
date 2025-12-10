import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

class Result {

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        int numeros = a.size();
        d = d % numeros;


        if (d == 0) return a;

        Integer[] resultado = new Integer[numeros];

        for (int i = 0; i < numeros - d; i++){
            resultado[i] = a.get(i + d);
        }
        for (int i = 0; i < d; i++){
            resultado[numeros - d + i] = a.get(i);
        }
        return Arrays.asList(resultado);
    }

}
