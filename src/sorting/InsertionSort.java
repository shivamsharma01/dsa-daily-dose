package sorting;

import util.ArrayUtil;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i< n; i++) {
            int key = arr[i], j = i;
            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }

}

class InsertionSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[] {21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}