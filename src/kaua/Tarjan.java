package kaua;

import java.util.*;

public class Tarjan {

    static class Grafo {
        int vertices;
        List<List<Integer>> adj;

        int tempo = 0;
        int[] ids, low;
        boolean[] naPilha;
        Deque<Integer> pilha;
        List<List<Integer>> componentes;

        public Grafo(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
            ids = new int[vertices];
            Arrays.fill(ids, -1);
            low = new int[vertices];
            naPilha = new boolean[vertices];
            pilha = new ArrayDeque<>();
            componentes = new ArrayList<>();
        }

        void adicionarAresta(int origem, int destino) {
            adj.get(origem).add(destino); // grafo direcionado
        }

        void tarjan() {
            for (int i = 0; i < vertices; i++) {
                if (ids[i] == -1) {
                    dfs(i);
                }
            }

            // Imprime as componentes fortemente conexas
            System.out.println("Componentes Fortemente Conexas (Tarjan):");
            for (List<Integer> componente : componentes) {
                System.out.println(componente);
            }
        }

        void dfs(int u) {
            ids[u] = low[u] = tempo++;
            pilha.push(u);
            naPilha[u] = true;

            for (int v : adj.get(u)) {
                if (ids[v] == -1) {
                    dfs(v);
                    low[u] = Math.min(low[u], low[v]);
                } else if (naPilha[v]) {
                    low[u] = Math.min(low[u], ids[v]);
                }
            }

            // Encontrou uma SCC
            if (ids[u] == low[u]) {
                List<Integer> componente = new ArrayList<>();
                while (true) {
                    int no = pilha.pop();
                    naPilha[no] = false;
                    componente.add(no);
                    if (no == u)
                        break;
                }
                componentes.add(componente);
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(8);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(2, 0);
        grafo.adicionarAresta(3, 1);
        grafo.adicionarAresta(3, 2);
        grafo.adicionarAresta(4, 3);
        grafo.adicionarAresta(4, 5);
        grafo.adicionarAresta(5, 6);
        grafo.adicionarAresta(6, 4);
        grafo.adicionarAresta(6, 7);

        grafo.tarjan();
    }
}
