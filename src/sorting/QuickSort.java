package sorting;

import java.util.Arrays;

public class QuickSort {

    private static int partition(int arr[], int low, int high) {
        int i = -1, val = arr[high], j = 0;

        while (j < high) {
            if (arr[j] <= val) {
                int temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
            j++;
        }

        arr[++i] = val;
        return i;
    }

    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr,p + 1, high);
        }
    }
}


class QuickSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[] {21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        MergeSort.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

