
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int inicio = 1;
        int fim = x;
        int resultado = 0;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            
            long quadrado = (long)meio * meio;

            if (quadrado == x) {
                return meio;
            } else if (quadrado < x) {
                resultado = meio; 
                inicio = meio + 1; 
            } else {
                fim = meio - 1;
            }
        } 

        return resultado;
    }
}



public class Main {
    

    public static void main(String[] args) {
        Solution solucao = new Solution();

        int[] casosDeTeste = {
            4,          
            8,          
            9,          
            0,          
            1,         
            2147395599  
        }; 

        System.out.println("--- Testando mySqrt usando Busca Binária ---");

        for (int x : casosDeTeste) {
            int resultado = solucao.mySqrt(x);
            
            long verificacaoQuadrado = (long)resultado * resultado;

            System.out.printf("Número: %-10d | Raiz Quadrada (Inteira): %-5d | Verificação: %d^2 = %d\n",
                              x, resultado, resultado, verificacaoQuadrado);
        }

        System.out.println("--------------------------------------------");
    }
}