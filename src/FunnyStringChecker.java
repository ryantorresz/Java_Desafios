import java.lang.Math;

public class FunnyStringChecker {

    public static String funnyString(String s) {
        int n = s.length();

        // Iteramos de 0 até n-2 para considerar todos os pares adjacentes
        for (int i = 0; i < n - 1; i++) {

            // 1. Diferença absoluta entre o par S[i] e S[i+1] (da esquerda)
            // O cast (int) é automático ao subtrair chars
            int diffEsquerda = Math.abs(s.charAt(i + 1) - s.charAt(i));

            // 2. Diferença absoluta do par correspondente na string inversa R
            // Os caracteres são S[n-1-i] e S[n-2-i], que são o par de trás para frente.
            int diffDireita = Math.abs(s.charAt(n - 1 - i) - s.charAt(n - 2 - i));

            // 3. Verifica a condição
            if (diffEsquerda != diffDireita) {
                return "Not Funny";
            }
        }

        // Se o loop terminar sem retornar, a string satisfaz a condição
        return "Funny";
    }

    public static void main(String[] args) {
        String s1 = "acxz";
        System.out.println("A string \"" + s1 + "\" é: " + funnyString(s1));

        String s2 = "bcxz";
        System.out.println("A string \"" + s2 + "\" é: " + funnyString(s2));

        String s3 = "ivhz";
        System.out.println("A string \"" + s3 + "\" é: " + funnyString(s3));
    }
}