package strivers.arrays.curated;

import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {
    /*
    input:
    4
    1 3
    2 4
    6 8
    9 10
    output:
    {{1,4},{6,8},{9,10}}


    input:
    4
    6 8
    1 9
    2 4
    4 7
    output:
    {{1,9}}
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr[i][0] = start;
            arr[i][1] = end;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int i1 = 0, i2 = 0, i = 0;
        int[][] out = new int[n][2];
        while (i2 != n) {
            if (arr[i1][1] >= arr[i2][0]) {
                arr[i1][1] = Math.max(arr[i1][1], arr[i2][1]);
                i2++;
                if (i2 == n)
                    out[i++] = arr[i1];
            } else {
                out[i++] = arr[i1];
                i1 = i2;
            }
        }
        int j = 0;
        while (j != i) {
            if (j == 0) {
                System.out.print("{");
            }
            System.out.printf("{%d,%d}", out[j][0], out[j][1]);
            if (j != i - 1) {
                System.out.print(",");
            } else {
                System.out.print("}");
            }
            j++;
        }
    }

}
