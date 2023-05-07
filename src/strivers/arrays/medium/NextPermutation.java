package strivers.arrays.medium;

import java.util.*;

public class NextPermutation {
    public static void nextGreaterPermutation(int[] a) {
        int n = a.length;

        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(a, 0, n);
        }

        for (int i = n - 1; i > idx; i--) {
            if (a[i] > a[idx]) {
                int temp = a[i];
                a[i] = a[idx];
                a[idx] = temp;
                break;
            }
        }
        reverse(a, idx + 1, n - 1);
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l <= r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void main(String args[]) {
        int[] arr = new int[]{2, 1, 5, 4, 3, 0, 0};
        nextGreaterPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
