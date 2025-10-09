import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static int [] rotateLeft(int[] arr, int d) {
        int n = arr.length;

        d = d % n;

        int[] rotatedArr = new int[n];

        for (int i = 0; i < n; i++) {
            int originalIndex = (i + d) % n;
            rotatedArr[i] = arr[originalIndex];
        }

        return rotatedArr;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("  ROTAÇÃO DE ARRAY CIRCULAR PARA A ESQUERDA");
        System.out.println("==========================================");

        // Solicita n (tamanho do array)
        System.out.print("Digite o tamanho do array (n): ");
        int n = scanner.nextInt();

        // Solicita d (número de rotações)
        System.out.print("Digite o número de rotações para a esquerda (d): ");
        int d = scanner.nextInt();

        // Consome a quebra de linha pendente
        scanner.nextLine();

        // Solicita os elementos do array
        System.out.print("Digite os " + n + " elementos do array (separados por espaço): ");

        // Lê a linha inteira de elementos
        String inputLine = scanner.nextLine();

        scanner.close();


        int [] arr = Arrays.stream(inputLine.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] result = rotateLeft(arr, d);

        String output = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));


        // --- Mensagens de Saída ---
        System.out.println("\n------------------------------------------");
        System.out.println("Array Rotacionado (" + d + " vezes):");
        System.out.println(output);
        System.out.println("------------------------------------------");
    }
   }