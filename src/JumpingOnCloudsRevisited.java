import java.util.Arrays;

public class JumpingOnCloudsRevisited {

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int n = c.length;
        int currentIndex = 0; // Começa na nuvem 0

        // Usamos um do-while loop para garantir que o primeiro salto ocorra antes da verificação
        // da condição de parada (currentIndex == 0).
        do {
            // 1. Calcular o próximo índice:
            // O salto é de tamanho k, usando o módulo n para garantir o wrap-around (volta).
            currentIndex = (currentIndex + k) % n;

            // 2. Reduzir a energia do salto (custo fixo).
            energy -= 1;

            // 3. Reduzir a energia por pousar em nuvem de trovão ('1').
            // Se c[currentIndex] for 1, energy será reduzida em 2.
            if (c[currentIndex] == 1) {
                energy -= 2;
            }

            // O loop continua enquanto o índice atual não for a nuvem inicial (0).
        } while (currentIndex != 0);

        return energy;
    }

    public static void main(String[] args) {

        int[] clouds = {0, 0, 1, 0, 0, 1, 1, 0};
        int jumpK = 2;
        int result = jumpingOnClouds(clouds, jumpK);

        System.out.println("Nuvens: " + Arrays.toString(clouds));
        System.out.println("Salto fixo (k): " + jumpK);
        System.out.println("Energia restante: " + result);
    }
}