package assignment1;

public class Question4 {
    /*
    You are given a 1D array that may contain both positive and negative integers,
    and find the sum of a contiguous subarray of numbers which has the largest sum.
    For example, if the given array is {-2, -5, 6, -2, -3, 1, 5, -6},
    then the maximum subarray sum is 7.
     */

    private static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return (leftSum + rightSum);
    }

    static int maxSubArraySum(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;

        int leftMax = maxSubArraySum(arr, left, mid);
        int rightMax = maxSubArraySum(arr, mid + 1, right);
        int crossMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};

        int maxSum = maxSubArraySum(arr, 0, arr.length - 1);
        System.out.println("Maximum Subarray Sum = " + maxSum);
    }
}
