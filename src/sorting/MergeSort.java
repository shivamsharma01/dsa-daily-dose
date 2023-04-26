package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] a1 = new int[mid - low + 1], a2 = new int[high - mid];

        for (int i = 0; i < a1.length; i++)
            a1[i] = arr[i + low];

        for (int i = 0; i < a2.length; i++)
            a2[i] = arr[i + mid + 1];

        int i1 = 0, i2 = 0, idx = low;
        while (i1 != a1.length && i2 != a2.length) {
            if (a1[i1] <= a2[i2])
                arr[idx++] = a1[i1++];
            else
                arr[idx++] = a2[i2++];
        }
        while (i1 != a1.length) arr[idx++] = a1[i1++];
        while (i2 != a2.length) arr[idx++] = a2[i2++];
    }
}

class MergeSortRunner {
    public static void main(String[] args) {
        int[] arr = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        MergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
