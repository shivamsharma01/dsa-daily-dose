package strivers.arrays.curated;

import java.util.Scanner;

public class MinimumPages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getMin(arr, n, m));
    }

    private static int getMin(int[] arr, int n, int m) {
        if (n < m)
            return -1;

        int max = arr[0], sum = 0;
        for (int i : arr) {
            if (i > max) max = i;
            sum += i;
        }

        int start = max, end = sum, result = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, m, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPossible(int[] arr, int m, int minSum) {
        int curSum = 0;
        int numStudents = 1;
        for (int i : arr) {
            curSum += i;
            if (curSum > minSum) {
                numStudents++;
                curSum = i;
            }
        }
        return numStudents <= m;
    }

}
