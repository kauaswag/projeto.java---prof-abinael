package kaua;

import java.util.*;

class Aresta implements Comparable<Aresta> {
    int origem, destino, peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int compareTo(Aresta outra) {
        return this.peso - outra.peso;
    }
}

class Grafo {
    int vertices;
    List<Aresta> arestas;

    public Grafo(int vertices) {
        this.vertices = vertices;
        arestas = new ArrayList<>();
    }

    void adicionarAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    int encontrarPai(int[] pai, int i) {
        if (pai[i] != i)
            pai[i] = encontrarPai(pai, pai[i]);
        return pai[i];
    }

    void unir(int[] pai, int[] rank, int x, int y) {
        int raizX = encontrarPai(pai, x);
        int raizY = encontrarPai(pai, y);

        if (rank[raizX] < rank[raizY]) {
            pai[raizX] = raizY;
        } else if (rank[raizX] > rank[raizY]) {
            pai[raizY] = raizX;
        } else {
            pai[raizY] = raizX;
            rank[raizX]++;
        }
    }

    void kruskal() {
        List<Aresta> resultado = new ArrayList<>();
        Collections.sort(arestas);

        int[] pai = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; ++i) {
            pai[i] = i;
            rank[i] = 0;
        }

        for (Aresta aresta : arestas) {
            int raizOrigem = encontrarPai(pai, aresta.origem);
            int raizDestino = encontrarPai(pai, aresta.destino);

            if (raizOrigem != raizDestino) {
                resultado.add(aresta);
                unir(pai, rank, raizOrigem, raizDestino);
            }
        }

        System.out.println("Arestas da Árvore Geradora Mínima (Kruskal):");
        int custoTotal = 0;
        for (Aresta a : resultado) {
            System.out.println(a.origem + " - " + a.destino + " : " + a.peso);
            custoTotal += a.peso;
        }
        System.out.println("Custo total: " + custoTotal);
    }
}

public class Kruskal {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.adicionarAresta(0, 1, 4);
        grafo.adicionarAresta(0, 2, 4);
        grafo.adicionarAresta(1, 2, 2);
        grafo.adicionarAresta(1, 3, 5);
        grafo.adicionarAresta(2, 3, 5);
        grafo.adicionarAresta(2, 4, 11);
        grafo.adicionarAresta(3, 4, 2);
        grafo.adicionarAresta(3, 5, 1);
        grafo.adicionarAresta(4, 5, 7);

        grafo.kruskal();
    }
}
