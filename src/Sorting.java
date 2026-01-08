import java.util.Scanner;

public class Sorting {

    public static int binarySearch(int[] A, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == key)
                return mid;
            else if (A[mid] < key)
                return binarySearch(A, mid + 1, high, key);
            else
                return binarySearch(A, low, mid - 1, key);
        }
        return -1;
    }

    public static int linearSearch(int[] A, int key) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] == key) {
                return i;
            }
        }
        return -1;
    }

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

    public static int[] create(int n, Scanner sc) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void print(int[] arr) {
        System.out.println("Sorted Array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int number;

        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Enter array elements: ");
        int[] arr = create(n, sc);

        do {
            System.out.println("\n--MENU--");
            System.out.println("1. BINARY SEARCH");
            System.out.println("2. LINEAR SEARCH");
            System.out.println("3. MERGE SORT");
            System.out.println("4. QUICK SORT");
            System.out.println("5. EXIT");
            System.out.print("Enter a number: ");
            number = sc.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("Enter the number to be searched : ");
                    int x = sc.nextInt();
                    mergeSort(arr, 0, arr.length - 1);
                    int ans = binarySearch(arr, 0, n - 1, x);
                    if (ans == -1) {
                        System.out.println("Element not found.");
                    } else {
                        System.out.println("The number is found at index " + ans);
                    }
                }

                case 2 -> {
                    System.out.println("Enter the number to be searched : ");
                    int x = sc.nextInt();
                    int ans = linearSearch(arr, x);
                    if (ans == -1) {
                        System.out.println("Element not found.");
                    } else {
                        System.out.println("The number is found at index " + ans);
                    }
                }

                case 3 -> {
                    mergeSort(arr, 0, arr.length - 1);
                    print(arr);
                }

                case 4 -> {
                    quickSort(arr, 0, arr.length - 1);
                    print(arr);
                }

                case 5 -> System.out.println("EXIT");

                default -> System.out.println("Choose a valid number.");
            }
        } while (number != 5);

        sc.close();
    }
}
