package sorting;

import util.ArrayUtil;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int i = low - 1, val = arr[high], j = low;
        while (j < high) {
            if (arr[j] <= val) {
                ArrayUtil.swap(arr, j, ++i);
            }
            j++;
        }
        arr[high] = arr[++i];
        arr[i] = val;
        return i;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }
}


class QuickSortRunner {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 1};
        System.out.println(Arrays.toString(arr));
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

