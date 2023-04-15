package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void sort(int arr[]) {
        int n = arr.length;
        int maxValue = Arrays.stream(arr).max().getAsInt();

        int freqArray[] = new int[maxValue + 1];

        // count freq of each number
        for (int i : arr) freqArray[i]++;

        // freq as prefix sum will ensure where that element needs to be placed
        for (int i = 1; i <= maxValue; i++) freqArray[i] += freqArray[i - 1];

        int out[] = new int[n];
        // in an auxiliary array place the elements based on their index in the prefix array
        for (int i = 0; i < n; i++) out[--freqArray[arr[i]]] = arr[i];

        // copy the values in the original array
        System.arraycopy(out, 0, arr, 0, n);
    }

}

class CountingSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        CountingSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}