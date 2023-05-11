package strivers.arrays.curated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MurderMystery {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int n;
        int[] arr;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getSum(arr, 0, n - 1));
        }
    }

    private static long getSum(int[] arr, int s, int e) {
        if (s < e) {
            int mid = s + (e - s) / 2;
            long leftSum = getSum(arr, s, mid);
            long rightSum = getSum(arr, mid + 1, e);
            return leftSum + rightSum + merge(arr, s, mid, e);
        }
        return 0;
    }

    private static long merge(int[] arr, int s, int mid, int e) {
        int[] arr1 = new int[mid - s + 1];
        int[] arr2 = new int[e - mid];
        System.arraycopy(arr, s, arr1, 0, mid - s + 1);
        System.arraycopy(arr, mid + 1, arr2, 0, e - mid);

        int i1 = 0, i2 = 0, i3 = s;
        long totalSum = 0, runningSum = 0;
        while (i1 != arr1.length && i2 != arr2.length) {
            if (arr1[i1] < arr2[i2]) {
                arr[i3] = arr1[i1];
                runningSum += arr1[i1];
                i1++;
            } else {
                arr[i3] = arr2[i2];
                totalSum += runningSum;
                i2++;
            }
            i3++;
        }

        while (i1 != arr1.length) {
            arr[i3++] = arr1[i1++];
        }

        while (i2 != arr2.length) {
            arr[i3++] = arr2[i2++];
            totalSum += runningSum;
        }

        return totalSum;
    }

}
