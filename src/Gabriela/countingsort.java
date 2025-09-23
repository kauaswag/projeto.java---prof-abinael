package Gabriela;
import javax.swing.JOptionPane;

public class countingsort {
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

        // Encontrar o valor máximo para criar o vetor de contagem
        int max = v[0];
        for (int i = 1; i < n; i++) {
            if (v[i] > max) max = v[i];
        }

        // Criar vetor de contagem e inicializar com zeros
        int[] count = new int[max + 1];

        // Contar a frequência de cada elemento
        for (int i = 0; i < n; i++) {
            count[v[i]]++;
        }

        // Recriar o vetor ordenado
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                v[index++] = i;
                count[i]--;
            }
        }

        // Exibir vetor ordenado
        String ordenado = "Vetor ordenado: ";
        for (int num : v) {
            ordenado += num + " ";
        }
        JOptionPane.showMessageDialog(null, ordenado);
    }
}
