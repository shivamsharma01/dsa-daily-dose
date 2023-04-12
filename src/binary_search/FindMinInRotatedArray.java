package binary_search;

import util.ArrayUtil;

import java.util.Arrays;

/*
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */
public class FindMinInRotatedArray {


    public static void main(String[] args) {
        int n, maxVal, arr[], numRotations;

        n = 15;
        maxVal = 100;
        numRotations = 2;
        arr = ArrayUtil.generateArray(maxVal, n, false);
        ArrayUtil.rotateArrayClockwise(arr, n, numRotations);
        System.out.println("Rotated Sorted Array is: " + Arrays.toString(arr));
        System.out.println("Min element is: " + getMinFromRotatedArray(arr, n));
        System.out.println("\n\n");

        n = 5;
        maxVal = 10;
        numRotations = 4;
        arr = ArrayUtil.generateArray(maxVal, n, false);
        ArrayUtil.rotateArrayClockwise(arr, n, numRotations);
        System.out.println("Rotated Sorted Array is: " + Arrays.toString(arr));
        System.out.println("Min element is: " + getMinFromRotatedArray(arr, n));
        System.out.println("\n\n");
    }

    private static int getMinFromRotatedArray(int arr[], int len) {
        int l = 0, r = len - 1, m;
        if (arr[l] < arr[r]) return arr[l];
        while (l < r) {
            m = l + (r - l) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else if (arr[m] > arr[l]) {
                r = m;
            } else {
                if (arr[l] > arr[r]) {
                    r = m;
                } else {
                    r--;
                }
            }
        }
        return arr[l];
    }
}
