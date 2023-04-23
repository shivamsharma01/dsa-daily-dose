package hackerearth.array_1d;

import java.util.Scanner;

/*
    https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/double-inversions-2-881a7d34/
 */
public class DoubleInversion {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int n = sc.nextInt();
            int A[] = new int[n], R[] = new int[n];
            for (int i = 0; i < n; i++) A[i] = sc.nextInt();
            for (int i = 0; i < n; i++) R[i] = sc.nextInt();
            solve(A, R, n);
        }
    }

    private static void solve(int left[], int right[], int n) {
        for (int i = 0; i < n; i++) {
            if (left[i] >= (i + 1) || right[i] >= (i + 1)) {
                System.out.println(-1);
                return;
            }
        }
        int arr[] = new int[n];
        boolean isPresent[] = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = n - (left[i] + right[n - (i + 1)]);
            isPresent[arr[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (isPresent[i] == false) {
                System.out.println(-1);
                return;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
