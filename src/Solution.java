import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {


        String minusculas = s.toLowerCase();
        boolean [] mapaAlfabeto = new boolean [26];
        int contagemLetras = 0;

        for (int i = 0; i < minusculas.length(); i++){
            char c = minusculas.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (c >= 'a' && c <= 'z'){
                int index = c - 'a';

                if (!mapaAlfabeto[index]){
                    mapaAlfabeto[index] = true;
                    contagemLetras++;
                }

                if (contagemLetras == 26){
                    return "pangram";
                }
            }
        }

        return (contagemLetras == 26) ? "pangram" : "not pangram";

    }

}

