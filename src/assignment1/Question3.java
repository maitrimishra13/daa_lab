package assignment1;

public class Question3 {
    /*
    Implement Quick Sort for arr[n] = { 4, 2, 6, 9, 2 }
     */

    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high);
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    private static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {4, 2, 6, 9, 2};
        int n = arr.length;

        System.out.println("Array before Sorting (merge sort) : ");
        Question2.print(arr);
        quickSort(arr, 0, n - 1);
        System.out.println("Array after Sorting (merge sort) : ");
        Question2.print(arr);

    }
}
