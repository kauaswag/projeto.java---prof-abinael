package kaua;

public class RadixSort {

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; 
        int[] count = new int[10]; 

        for (int i = 0; i < n; i++) {
            int digito = (array[i] / exp) % 10;
            count[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digito = (array[i] / exp) % 10;
            output[count[digito] - 1] = array[i];
            count[digito]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    public static void radixSort(int[] array) {
        int max = getMax(array); // encontra o maior número


        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void imprimirArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numeros = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("Array original:");
        imprimirArray(numeros);

        radixSort(numeros);

        System.out.println("Array ordenado:");
        imprimirArray(numeros);
    }
}

