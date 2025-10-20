public class CaixeiroViajanteSimplificado {

    public static class Main {
        public static void main(String[] args) {


            int[][] distancias = {
                    {Integer.MAX_VALUE, 10, 15, 20},
                    {10, Integer.MAX_VALUE, 35, 25},
                    {15, 35, Integer.MAX_VALUE, 30},
                    {20, 25, 30, Integer.MAX_VALUE}
            };

            CaixeiroViajanteSolution solution = new CaixeiroViajanteSolution();

            long custoMinimo = solution.encontrarCaminhoMinimo(distancias);

            System.out.println("--- Desafio do Caixeiro Viajante Simplificado ---");
            System.out.println("Cidades a visitar (pontos): " + distancias.length);
            System.out.println("Ponto de Partida: 0");
            System.out.println("Custo Mínimo do Caminho (0 -> ... -> n-1): " + custoMinimo);

        }
    }


    public static class CaixeiroViajanteSolution {
        private int numPontos;
        private int[][] distancias;
        private long custoMinimoGlobal;

        public long encontrarCaminhoMinimo(int[][] distancias) {
            if (distancias == null || distancias.length == 0) {
                return 0;
            }
            this.distancias = distancias;
            this.numPontos = distancias.length;
            this.custoMinimoGlobal = Long.MAX_VALUE;

            boolean[] visitados = new boolean[numPontos];

            int pontoInicial = 0;

            visitados[pontoInicial] = true;


            buscarCaminho(pontoInicial, 0, visitados, 1); // O último '1' é o contador de nós visitados

            return custoMinimoGlobal;
        }


        private void buscarCaminho(int pontoAtual, long custoAtual, boolean[] visitados, int contagemVisitados) {
            if (contagemVisitados == numPontos) {
                if (custoAtual < custoMinimoGlobal) {
                    custoMinimoGlobal = custoAtual;
                }
                return;
            }

            if (custoAtual >= custoMinimoGlobal) {
                return;
            }

            for (int proximoPonto = 0; proximoPonto < numPontos; proximoPonto++) {

                if (!visitados[proximoPonto] && distancias[pontoAtual][proximoPonto] != Integer.MAX_VALUE) {

                    visitados[proximoPonto] = true;

                    long novoCusto = custoAtual + distancias[pontoAtual][proximoPonto];
                    buscarCaminho(proximoPonto, novoCusto, visitados, contagemVisitados + 1);

                    visitados[proximoPonto] = false;
                }
            }
        }
    }
}