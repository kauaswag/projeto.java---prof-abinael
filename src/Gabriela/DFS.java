package Gabriela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DFS {
    static List<List<Integer>> grafo; // lista de adjacência
    static boolean[] visitado;        // marca os vértices visitados
    static String ordem = "";         // armazena a ordem de visitação

    public static void main(String[] args) {
        // Solicitar o número de vértices
        int V = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vértices do grafo:"));

        // Inicializar estrutura do grafo
        grafo = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }

        // Solicitar o número de arestas
        int E = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de arestas:"));

        // Preencher as arestas do grafo
        for (int i = 0; i < E; i++) {
            String entrada = JOptionPane.showInputDialog("Digite a aresta " + (i + 1) + " (formato: origem destino):");
            String[] partes = entrada.split(" ");
            int origem = Integer.parseInt(partes[0]);
            int destino = Integer.parseInt(partes[1]);

            grafo.get(origem).add(destino);
            // Se o grafo for não-direcionado, adicione a linha abaixo:
            // grafo.get(destino).add(origem);
        }

        // Solicitar vértice inicial
        int inicio = Integer.parseInt(JOptionPane.showInputDialog("Digite o vértice inicial para DFS:"));

        // Inicializar vetor de visitados
        visitado = new boolean[V];

        // Executar DFS
        dfs(inicio);

        // Exibir ordem de visitação
        JOptionPane.showMessageDialog(null, "Ordem de visitação DFS: " + ordem);
    }

    // Função DFS recursiva
    static void dfs(int v) {
        visitado[v] = true;
        ordem += v + " ";

        for (int vizinho : grafo.get(v)) {
            if (!visitado[vizinho]) {
                dfs(vizinho);
            }
        }
    }
}
