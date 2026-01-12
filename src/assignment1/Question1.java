package assignment1;

public class Question1 {
    /*
    Consider an array arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} and
    use Binary Search to find the target 23.
     */
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

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("The target is 23.");
        int target = 23;
        int n = arr.length;
        int ans = binarySearch(arr, 0, n - 1, target);
        System.out.println("The target is found at index " + ans);
    }
}
