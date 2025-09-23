package kaua;

public class InsertionSort{

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int chave = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = chave;
        }
    }

    public static void imprimirArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numeros = { 9, 5, 1, 4, 3 };

        System.out.println("Array original:");
        imprimirArray(numeros);

        insertionSort(numeros);

        System.out.println("Array ordenado:");
        imprimirArray(numeros);
    }
}

