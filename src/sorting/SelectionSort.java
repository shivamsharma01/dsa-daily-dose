package sorting;

import util.ArrayUtil;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            ArrayUtil.swap(arr, i, min);
        }
    }

}

class SelectionSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
