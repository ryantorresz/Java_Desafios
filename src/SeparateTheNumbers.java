import java.math.BigInteger;

public class SeparateTheNumbers {

    public static void separateNumbers(String s) {
        int n = s.length();

        // Uma string com menos de 2 dígitos não pode ser dividida em 2+ inteiros positivos.
        if (n < 2) {
            System.out.println("NO");
            return;
        }

        // Itera sobre todos os possíveis comprimentos (L) do primeiro número (a1).
        // L pode ser de 1 até a metade do comprimento da string.
        for (int len = 1; len <= n / 2; len++) {

            // 1. Extrair a substring que representa o primeiro número a1
            String startStr = s.substring(0, len);

            // 2. Condição: Nenhum número pode ter zeros à esquerda.
            if (startStr.startsWith("0")) {
                // Se começar com zero, esta e todas as substrings mais longas começando com '0'
                // para este len são inválidas.
                continue;
            }

            // Usamos BigInteger para lidar com números que excedem o long (se a string for longa)
            BigInteger currentNum = new BigInteger(startStr);

            // Inicializa o construtor da string com o primeiro número
            StringBuilder sequence = new StringBuilder(startStr);

            // 3. Constrói a sequência até que o comprimento seja igual ou exceda o da string original
            while (sequence.length() < n) {
                // Incrementa o número para obter o próximo elemento da sequência
                currentNum = currentNum.add(BigInteger.ONE);

                // Anexa o novo número à sequência construída
                sequence.append(currentNum.toString());
            }

            // 4. Verifica se a sequência construída é idêntica à string original
            if (sequence.toString().equals(s)) {
                // Se for idêntica, encontramos a menor solução (pois iteramos do menor comprimento L)
                System.out.println("YES " + startStr);
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) {
        // Exemplos de Teste:
        separateNumbers("1234");
        separateNumbers("91011");
        separateNumbers("99100");
        separateNumbers("101103");
        separateNumbers("010203");
        separateNumbers("13");
        separateNumbers("1");
        separateNumbers("111112");
        separateNumbers("99910001001");
    }
}