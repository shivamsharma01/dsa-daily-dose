package sorting;

import util.ArrayUtil;

import java.util.Arrays;

public class HeapSort {

    public static void sort(int arr[]) {
        int n = arr.length;

        // build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, i, n);

        // heap sort
        for (int i = n - 1; i >= 0; i--) {
            ArrayUtil.swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int arr[], int i, int n) {
        int indexWithLargestValue = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] > arr[indexWithLargestValue])
            indexWithLargestValue = left;

        if (right < n && arr[right] > arr[indexWithLargestValue])
            indexWithLargestValue = right;

        if (i != indexWithLargestValue) {
            ArrayUtil.swap(arr, i, indexWithLargestValue);
            heapify(arr, indexWithLargestValue, n);
        }
    }

}

class HeapSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}