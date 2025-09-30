package kaua;

import java.util.*;

public class TopoSortDFS {

    static class Grafo {
        int vertices;
        List<List<Integer>> adj;
        boolean[] visitado;
        Stack<Integer> pilha;

        public Grafo(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
            visitado = new boolean[vertices];
            pilha = new Stack<>();
        }

        void adicionarAresta(int origem, int destino) {
            adj.get(origem).add(destino);
        }

        void dfs(int u) {
            visitado[u] = true;

            for (int vizinho : adj.get(u)) {
                if (!visitado[vizinho]) {
                    dfs(vizinho);
                }
            }

            pilha.push(u);
        }

        void ordenacaoTopologica() {
            for (int i = 0; i < vertices; i++) {
                if (!visitado[i]) {
                    dfs(i);
                }
            }

            System.out.println("Ordenação Topológica (DFS):");
            while (!pilha.isEmpty()) {
                System.out.print(pilha.pop() + " ");
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.adicionarAresta(5, 2);
        grafo.adicionarAresta(5, 0);
        grafo.adicionarAresta(4, 0);
        grafo.adicionarAresta(4, 1);
        grafo.adicionarAresta(2, 3);
        grafo.adicionarAresta(3, 1);

        grafo.ordenacaoTopologica();
    }
}
