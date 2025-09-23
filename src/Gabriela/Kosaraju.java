package Gabriela;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Kosaraju {
    static List<List<Integer>> grafo;
    static List<List<Integer>> transposto;
    static boolean[] visitado;
    static Stack<Integer> pilha;

    public static void main(String[] args) {
        int V = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vértices:"));

        // Criar lista de adjacência
        grafo = new ArrayList<>();
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

        // Inicializar estruturas
        visitado = new boolean[V];
        pilha = new Stack<>();

        // Primeira DFS para preencher a pilha
        for (int i = 0; i < V; i++) {
            if (!visitado[i]) dfs1(i);
        }

        // Transpor o grafo
        transposto = new ArrayList<>();
        for (int i = 0; i < V; i++) transposto.add(new ArrayList<>());
        for (int u = 0; u < V; u++) {
            for (int v : grafo.get(u)) {
                transposto.get(v).add(u);
            }
        }

        // Segunda DFS para descobrir SCCs
        visitado = new boolean[V];
        String resultado = "Componentes Fortemente Conectados:\n";
        while (!pilha.isEmpty()) {
            int v = pilha.pop();
            if (!visitado[v]) {
                String componente = "";
                dfs2(v, componente);
                resultado += componente + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    static void dfs1(int v) {
        visitado[v] = true;
        for (int u : grafo.get(v)) {
            if (!visitado[u]) dfs1(u);
        }
        pilha.push(v);
    }

    static void dfs2(int v, String componente) {
        visitado[v] = true;
        componente += v + " ";
        for (int u : transposto.get(v)) {
            if (!visitado[u]) dfs2(u, componente);
        }
        // Para mostrar corretamente, imprimir no final da DFS
        if (componente.length() > 0) {
            JOptionPane.showMessageDialog(null, "Componente: " + componente);
        }
    }
}
