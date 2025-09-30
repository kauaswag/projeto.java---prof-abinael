package kaua;

import java.util.*;

public class GrafoBFS {

    private int vertices;
    private LinkedList<Integer>[] adjacencia;

    public GrafoBFS(int v) {
        vertices = v;
        adjacencia = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencia[i] = new LinkedList<>();
    }

    void adicionarAresta(int origem, int destino) {
        adjacencia[origem].add(destino);
        adjacencia[destino].add(origem);
    }

    void bfs(int inicio) {
        boolean[] visitado = new boolean[vertices];

        Queue<Integer> fila = new LinkedList<>();

        visitado[inicio] = true;
        fila.add(inicio);

        while (!fila.isEmpty()) {
            int no = fila.poll();
            System.out.print(no + " ");

            for (int vizinho : adjacencia[no]) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS(6);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 4);
        grafo.adicionarAresta(3, 5);
        grafo.adicionarAresta(4, 5);

        System.out.println("BFS a partir do vértice 0:");
        grafo.bfs(0);
    }
}
