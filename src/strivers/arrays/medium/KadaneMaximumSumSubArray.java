package strivers.arrays.medium;

import java.util.Arrays;

public class KadaneMaximumSumSubArray {
    public static void main(String[] args) {
        getMaxSumSubArray(new int[]{1, -2}, 2);
        getMaxSumSubArray(new int[]{-1, -2}, 2);
        getMaxSumSubArray(new int[]{2, -1}, 2);
        getMaxSumSubArray(new int[]{-2, 1}, 2);
        getMaxSumSubArray(new int[]{1, -2, 3}, 3);
        getMaxSumSubArray(new int[]{3, -2, 3}, 3);
        getMaxSumSubArray(new int[]{-1, -2, -3}, 3);
        getMaxSumSubArray(new int[]{-3, -2, -1}, 3);
        getMaxSumSubArray(new int[]{5, -2, -1, -1, 5}, 5);
        getMaxSumSubArray(new int[]{5, -2, -1, -2, 5}, 5);
        getMaxSumSubArray(new int[]{5, -2, -1, -3, 5}, 5);
    }

    private static void getMaxSumSubArray(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE, sumStart = 0, sumEnd = 0, curSum = 0, curStart = 0;
        for (int i = 0; i < n; i++) {
            curSum += arr[i];
            if (curSum >= maxSum) {
                sumStart = curStart;
                sumEnd = i;
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
                curStart = i + 1;
            }
        }
        System.out.println("for array: " + Arrays.toString(arr) + " maximum subarray sum is " + maxSum);
        System.out.println("Start index = " + sumStart + ", End index = " + sumEnd);
    }

}
