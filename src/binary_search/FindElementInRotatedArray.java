package binary_search;

import util.ArrayUtil;

import java.util.Arrays;

/*
    https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class FindElementInRotatedArray {
    public static void main(String[] args) {
        //runner(15, 100, 2);
        //runner(5, 10, 4);
        System.out.println(findElementInRotatedArray(new int[]{3, 1}, 2, 1));
        System.out.println(findElementInRotatedArray(new int[]{5, 1, 3}, 3, 5));
    }

    private static void runner(int n, int maxArrayVal, int numRotations) {
        int arr[] = ArrayUtil.generateArray(maxArrayVal, n, false);
        ArrayUtil.rotateArrayClockwise(arr, n, numRotations);
        System.out.println("Rotated Sorted Array is: " + Arrays.toString(arr));
        int randomElementFromTheArray = ArrayUtil.getRandomElementFromArray(arr, n);
        System.out.println(String.format("Element %d is present at index: %d ", randomElementFromTheArray, findElementInRotatedArray(arr, n, randomElementFromTheArray)));
        System.out.println("\n\n");
    }

    private static int findElementInRotatedArray(int arr[], int len, int x) {
        int l = 0, h = len - 1, m;
        while (l <= h) {
            m = l + (h - l) / 2;
            if (x == arr[m]) {
                return m;
            } else if (arr[l] <= arr[m]) {
                if (x <= arr[m] && x >= arr[l]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (arr[h] >= x && x >= arr[m]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }
}
