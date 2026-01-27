package assignment1;

public class Question4_extra {
    /*
    to find the indexes of the max subarray sums
     */
    public static class Result {
        int sum;
        int start;
        int end;

        Result(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }
    }

    private static Result maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int maxLeft = mid;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid + 1;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new Result(leftSum + rightSum, maxLeft, maxRight);
    }

    public static Result maxSubArray(int[] arr, int left, int right) {
        if (left == right) {
            return new Result(arr[left], left, right);
        }

        int mid = (left + right) / 2;

        Result leftResult = maxSubArray(arr, left, mid);
        Result rightResult = maxSubArray(arr, mid + 1, right);
        Result crossResult = maxCrossingSum(arr, left, mid, right);

        if (leftResult.sum >= rightResult.sum && leftResult.sum >= crossResult.sum) {
            return leftResult;
        } else if (rightResult.sum >= leftResult.sum && rightResult.sum >= crossResult.sum) {
            return rightResult;
        } else {
            return crossResult;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};

        Result res = maxSubArray(arr, 0, arr.length - 1);

        System.out.println("Maximum Sum = " + res.sum);
        System.out.println("Start Index = " + res.start);
        System.out.println("End Index = " + res.end);
    }
}
