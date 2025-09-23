package Gabriela;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class bucketsort {
    public static void main(String[] args) {
        // Solicitar o tamanho do vetor
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor:"));
        double[] v = new double[n];

        // Preencher o vetor
        for (int i = 0; i < n; i++) {
            v[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o elemento " + (i + 1) + " (entre 0 e 1):"));
        }

        // Exibir vetor original
        String original = "Vetor original: ";
        for (double num : v) {
            original += num + " ";
        }
        JOptionPane.showMessageDialog(null, original);

        // Criar baldes
        int numBaldes = n; // geralmente o número de baldes = tamanho do vetor
        ArrayList<Double>[] baldes = new ArrayList[numBaldes];
        for (int i = 0; i < numBaldes; i++) {
            baldes[i] = new ArrayList<>();
        }

        // Distribuir elementos nos baldes
        for (int i = 0; i < n; i++) {
            int indiceBalde = (int) (v[i] * numBaldes); // define em qual balde vai
            if (indiceBalde == numBaldes) indiceBalde--; // tratar caso v[i] = 1
            baldes[indiceBalde].add(v[i]);
        }

        // Ordenar cada balde individualmente
        for (int i = 0; i < numBaldes; i++) {
            Collections.sort(baldes[i]);
        }

        // Concatenar baldes no vetor original
        int index = 0;
        for (int i = 0; i < numBaldes; i++) {
            for (double num : baldes[i]) {
                v[index++] = num;
            }
        }

        // Exibir vetor ordenado
        String ordenado = "Vetor ordenado: ";
        for (double num : v) {
            ordenado += num + " ";
        }
        JOptionPane.showMessageDialog(null, ordenado);
    }
}
