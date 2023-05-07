package sorting;

import util.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean isSorted;
        for (int i = 0; i < n; i++) {
            isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
            if (isSorted) break;
        }
    }

}

class BubbleSortRunner {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
