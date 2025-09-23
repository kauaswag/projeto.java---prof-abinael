package Gabriela;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;

public class KahnTopoSort {
    public static void main(String[] args) {
        // Solicitar número de vértices
        int V = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vértices:"));

        // Criar lista de adjacência
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }

        // Número de arestas
        int E = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de arestas:"));

        // Preencher arestas
        for (int i = 0; i < E; i++) {
            String entrada = JOptionPane.showInputDialog("Digite a aresta " + (i + 1) + " (origem destino):");
            String[] partes = entrada.split(" ");
            int origem = Integer.parseInt(partes[0]);
            int destino = Integer.parseInt(partes[1]);

            grafo.get(origem).add(destino);
        }

        // Executar Kahn Topological Sort
        int[] ordenacao = kahnTopoSort(grafo, V);

        // Mostrar resultado
        String resultado = "Ordenação topológica: ";
        for (int v : ordenacao) {
            resultado += v + " ";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    static int[] kahnTopoSort(List<List<Integer>> grafo, int V) {
        int[] grauEntrada = new int[V];
        int[] topo = new int[V];
        int index = 0;

        // Calcular grau de entrada de cada vértice
        for (List<Integer> adj : grafo) {
            for (int v : adj) {
                grauEntrada[v]++;
            }
        }

        // Fila de vértices com grau de entrada 0
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (grauEntrada[i] == 0) fila.add(i);
        }

        // Processar vértices
        while (!fila.isEmpty()) {
            int u = fila.poll();
            topo[index++] = u;

            for (int v : grafo.get(u)) {
                grauEntrada[v]--;
                if (grauEntrada[v] == 0) fila.add(v);
            }
        }

        return topo; // retorna a sequência topológica
    }
}
