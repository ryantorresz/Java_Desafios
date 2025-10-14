static class Solution {

    public int [] productExceptSelf(int[] nums) {

        int n = nums.length;


        int[] aswer = new int[n];

        int prefixProduct = 1;

        for (int i = 0; i < n; i++) {

            aswer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;

        for(int i = n - 1; i >= 0; i--) {
            aswer[i] *= suffixProduct;

            suffixProduct *= nums[i];
        }


        return aswer;
    }
}


public static void main(String[] args) {
    Solution solver = new Solution();
    Scanner scanner = new Scanner(System.in);

    System.out.println("--- Teste de Produto do Array Exceto Ele Próprio ---");
    System.out.println("Exemplo de Entrada: [1,2,3,4] -> Saída Esperada: [24,12,8,6]");
    System.out.println("-----------------------------------------------------");

    while (true) {
        System.out.print("\nInsira os números do array separados por vírgula (ex: 1,2,3,4) ou 'sair': ");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("sair")) {
            System.out.println("Programa encerrado.");
            break;
        }

        if (input.isEmpty()) {
            System.out.println("Entrada inválida. Por favor, insira uma sequência de números.");
            continue;
        }

        try {
            // Remove espaços e divide a string por vírgulas para obter os números
            String[] parts = input.replaceAll("\\s+", "").split(",");

            // Converte as strings em inteiros
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }

            // O problema exige no mínimo 2 elementos
            if (nums.length < 2) {
                System.out.println("O array deve conter pelo menos 2 elementos.");
                continue;
            }

            // Processa o array
            int[] result = solver.productExceptSelf(nums);

            // Exibe o resultado
            System.out.println("Array Original: " + Arrays.toString(nums));
            System.out.println("Array Resultado: " + Arrays.toString(result));

        } catch (NumberFormatException e) {
            System.out.println("Erro: A entrada contém caracteres não numéricos. Por favor, use apenas números e vírgulas.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    scanner.close();
}