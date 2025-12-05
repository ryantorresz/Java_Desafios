import java.util.Scanner;

public class MarsExploration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        System.out.println("Mensagem recebida: " + s);
        System.out.println("Tamanho da mensagem: " + s.length());

        int errors = 0;

        for (int i = 0; i < s.length(); i += 3) {
            System.out.println("\n--- Grupo " + (i/3 + 1) + " ---");
            System.out.println("Posições: " + i + ", " + (i+1) + ", " + (i+2));

            System.out.println("Posição " + i + ": esperado 'S', recebido '" + s.charAt(i) + "'");
            if (s.charAt(i) != 'S') {
                errors++;
                System.out.println("✓ ERRO detectado na posição " + i);
            } else {
                System.out.println("✓ OK na posição " + i);
            }

            System.out.println("Posição " + (i+1) + ": esperado 'O', recebido '" + s.charAt(i+1) + "'");
            if (s.charAt(i+1) != 'O') {
                errors++;
                System.out.println("✓ ERRO detectado na posição " + (i+1));
            } else {
                System.out.println("✓ OK na posição " + (i+1));
            }

            System.out.println("Posição " + (i+2) + ": esperado 'S', recebido '" + s.charAt(i+2) + "'");
            if (s.charAt(i+2) != 'S') {
                errors++;
                System.out.println("✓ ERRO detectado na posição " + (i+2));
            } else {
                System.out.println("✓ OK na posição " + (i+2));
            }
        }

        System.out.println("\n=================================");
        System.out.println("Total de erros encontrados: " + errors);
        System.out.println("Resultado final: " + errors);
    }
}