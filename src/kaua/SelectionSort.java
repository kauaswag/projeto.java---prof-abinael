package kaua;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void imprimirArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] numeros = { 64, 25, 12, 22, 11 };

        System.out.println("Array original:");
        imprimirArray(numeros);

        selectionSort(numeros);

        System.out.println("Array ordenado:");
        imprimirArray(numeros);
    }
}

