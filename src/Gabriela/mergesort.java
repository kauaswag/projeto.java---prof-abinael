package Gabriela;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class mergesort {
    public static void main(String[] args) {
        // Solicitar tamanho do vetor
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] v = new int[n];

        // Preencher vetor
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + ":"));
        }

        // Mostrar vetor original
        JOptionPane.showMessageDialog(null, "Vetor original: " + Arrays.toString(v));

        // Ordenar com Merge Sort
        mergeSort(v, 0, n - 1);

        // Mostrar vetor ordenado
        JOptionPane.showMessageDialog(null, "Vetor ordenado: " + Arrays.toString(v));
    }

    // Função Merge Sort recursiva
    static void mergeSort(int[] v, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            // Ordenar metade esquerda
            mergeSort(v, esquerda, meio);

            // Ordenar metade direita
            mergeSort(v, meio + 1, direita);

            // Unir as duas metades
            merge(v, esquerda, meio, direita);
        }
    }

    // Função para unir duas metades ordenadas
    static void merge(int[] v, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = v[esquerda + i];
        for (int j = 0; j < n2; j++) R[j] = v[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) v[k++] = L[i++];
            else v[k++] = R[j++];
        }

        while (i < n1) v[k++] = L[i++];
        while (j < n2) v[k++] = R[j++];
    }
}
