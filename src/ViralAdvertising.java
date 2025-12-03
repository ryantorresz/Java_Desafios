import java.util.Scanner;

public class ViralAdvertising {

    public static int viralAdvertising(int n) {
        // O número de pessoas que recebem o anúncio no início do Dia 1 é 5.
        int shared = 5;

        // O contador para o total de curtidas acumuladas.
        int cumulativeLikes = 0;

        // Loop pelos N dias
        for (int day = 1; day <= n; day++) {

            // 1. Calcular as Curtidas (Likes) do dia:
            // Metade das pessoas que recebem curtem (divisão inteira).
            // A operação / 2 em Java com inteiros já faz o floor (divisão inteira).
            int liked = shared / 2;

            // 2. Acumular o Total de Curtidas:
            cumulativeLikes += liked;

            // 3. Atualizar para o Próximo Dia:
            // Cada pessoa que curtiu compartilha com 3 amigos.
            shared = liked * 3;

            // O valor 'shared' agora é o número de pessoas que receberão o anúncio no dia seguinte.
        }

        return cumulativeLikes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de dias (N): ");
        int n = scanner.nextInt();

        int result = viralAdvertising(n);
        System.out.println("\nTotal de curtidas após " + n + " dias: " + result);

        scanner.close();
    }
}