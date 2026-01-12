package assignment1;

public class Question2 {
    /*
    Implement Merge sort for the given array int arr[] = {12, 11, 13, 5, 6, 7}.
    After implementing Merge Sort,
    apply the same implementation to sort another array:
    int arr2[] = {38, 27, 43, 3, 9, 82, 10}.
     */

    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    private static void merge(int[] A, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[low + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = A[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void print(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] arr2 = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array 1 before Sorting (merge sort) : ");
        print(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Array 1 after Sorting (merge sort) : ");
        print(arr);

        System.out.println();

        System.out.println("Array 2 before Sorting (merge sort) : ");
        print(arr2);
        mergeSort(arr2, 0, arr2.length - 1);
        System.out.println("Array 2 after Sorting (merge sort) : ");
        print(arr2);
    }
}