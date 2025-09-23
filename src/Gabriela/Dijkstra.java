package Gabriela;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Dijkstra {
    public static void main(String[] args) {
        // Quantidade de vértices
        int V = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vértices:"));

        // Criar grafo como matriz de adjacência
        int[][] grafo = new int[V][V];

        // Número de arestas
        int E = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de arestas:"));

        // Preencher arestas e pesos
        for (int i = 0; i < E; i++) {
            String entrada = JOptionPane.showInputDialog("Digite a aresta " + (i + 1) + " (origem destino peso):");
            String[] partes = entrada.split(" ");
            int origem = Integer.parseInt(partes[0]);
            int destino = Integer.parseInt(partes[1]);
            int peso = Integer.parseInt(partes[2]);

            grafo[origem][destino] = peso;
        }

        // Vértice inicial
        int inicio = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice inicial:"));

        // Executar Dijkstra
        int[] distancias = dijkstra(grafo, inicio);

        // Mostrar resultado
        String resultado = "Distâncias mínimas a partir do vértice " + inicio + ":\n";
        for (int i = 0; i < V; i++) {
            resultado += "Vértice " + i + ": " + distancias[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Função que calcula distâncias mínimas
    static int[] dijkstra(int[][] grafo, int inicio) {
        int V = grafo.length;
        int[] dist = new int[V];        // vetor de distâncias
        boolean[] visitado = new boolean[V]; // vetor de visitados

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[inicio] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = minDist(dist, visitado); // escolher vértice com menor distância
            visitado[u] = true;

            // Atualizar distâncias dos vizinhos
            for (int v = 0; v < V; v++) {
                if (!visitado[v] && grafo[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + grafo[u][v] < dist[v]) {
                    dist[v] = dist[u] + grafo[u][v];
                }
            }
        }

        return dist;
    }

    // Função auxiliar para encontrar vértice com menor distância
    static int minDist(int[] dist, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visitado[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

