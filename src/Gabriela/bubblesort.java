package Gabriela;
import javax.swing.JOptionPane;

public class bubblesort {
    public static void main(String[] args) {
        // Solicitar o tamanho do vetor
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        int[] v = new int[n];

        // Preencher o vetor
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + ":"));
        }

        // Exibir vetor original
        String original = "Vetor original: ";
        for (int num : v) {
            original += num + " ";
        }
        JOptionPane.showMessageDialog(null, original);

        // Aplicar Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false; // Otimização para parar se já estiver ordenado
            for (int j = 0; j < n - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    // Troca os elementos
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocou = true;
                }
            }
            // Se não houve troca, o vetor já está ordenado
            if (!trocou) break;
        }

        // Exibir vetor ordenado
        String ordenado = "Vetor ordenado: ";
        for (int num : v) {
            ordenado += num + " ";
        }
        JOptionPane.showMessageDialog(null, ordenado);
    }
}
