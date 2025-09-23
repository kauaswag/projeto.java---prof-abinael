package Gabriela;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Prim {
    public static void main(String[] args) {
        // Solicitar número de vértices
        int V = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vértices:"));
        int[][] grafo = new int[V][V];

        // Preencher matriz de adjacência
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    String entrada = JOptionPane.showInputDialog("Digite o peso da aresta " + i + "->" + j + " (0 se não existe):");
                    grafo[i][j] = Integer.parseInt(entrada);
                }
            }
        }

        // Executar Prim
        primMST(grafo);
    }

    static void primMST(int[][] grafo) {
        int V = grafo.length;
        int[] key = new int[V];       // Peso mínimo para incluir o vértice
        int[] parent = new int[V];    // Para armazenar MST
        boolean[] mstSet = new boolean[V]; // Vértices incluídos na MST

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;       // Começar do vértice 0
        parent[0] = -1;   // Raiz da MST

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Atualizar chaves dos vizinhos
            for (int v = 0; v < V; v++) {
                if (grafo[u][v] != 0 && !mstSet[v] && grafo[u][v] < key[v]) {
                    key[v] = grafo[u][v];
                    parent[v] = u;
                }
            }
        }

        // Mostrar MST
        String resultado = "Arestas da MST (Prim):\n";
        int pesoTotal = 0;
        for (int i = 1; i < V; i++) {
            resultado += parent[i] + " - " + i + " = " + grafo[i][parent[i]] + "\n";
            pesoTotal += grafo[i][parent[i]];
        }
        resultado += "Peso total da MST: " + pesoTotal;
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Função para encontrar o vértice com a menor chave não incluído na MST
    static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
