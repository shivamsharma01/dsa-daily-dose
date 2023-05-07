package hackerearth.array_1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/*
    https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/array-queries-again-7948f256/
 */
public class ArrayQueries {
    final static int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()), n, m;
        String[] line;
        while (t-- != 0) {
            n = Integer.parseInt(br.readLine().trim());
            m = Integer.parseInt(br.readLine().trim());
            line = br.readLine().split(" ");
            int[] A = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            line = br.readLine().split(" ");
            int[] B = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            int Q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[Q][];
            for (int i = 0; i < Q; i++) {
                line = br.readLine().split(" ");
                queries[i] = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
            }
            int[] out = array_queries(n, m, A, B, Q, queries);
            System.out.print(out[0]);
            for (int i = 1; i < out.length; i++) {
                System.out.print(" " + out[i]);
            }
            System.out.println();
        }

        wr.close();
        br.close();
    }

    private static long add(long x, long y) {
        x += y;
        while (x >= MOD) x -= MOD;
        while (x < 0) x += MOD;
        return x;
    }

    private static long mul(long x, long y) {
        return (x * y) % MOD;
    }

    private static void swap(int[] A, int[] B, int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = B[idx2];
        B[idx2] = temp;
    }

    static int[] array_queries(int N, int M, int[] A, int[] B, int Q, int[][] queries) {
        int[] result = new int[Q + 1];
        int count = 0;

        long sumA = 0, sumB = 0, sumC = 0, sumD = 0;
        for (int i = 0; i < N; i++) {
            sumA = add(sumA, A[i]);
            sumC = add(sumC, mul(i + 1, A[i]));
        }
        for (int i = 0; i < M; i++) {
            sumB = add(sumB, B[i]);
            sumD = add(sumD, mul(i + 1, B[i]));
        }
        long op = add(mul(sumA, sumD), mul(sumB, sumC));
        result[count++] = (int) op;
        for (int[] query : queries) {
            int x = query[0], y = query[1] - 1, z = query[2] - 1;
            if (x == 1) {
                sumA = add(sumA, -A[y]);
                sumB = add(sumB, -B[z]);
                sumC = add(sumC, -mul((y + 1), A[y]));
                sumD = add(sumD, -mul((z + 1), B[z]));
                swap(A, B, y, z);
                sumA = add(sumA, A[y]);
                sumB = add(sumB, B[z]);
                sumC = add(sumC, mul((y + 1), A[y]));
                sumD = add(sumD, mul((z + 1), B[z]));
            } else if (x == 2) {
                sumC = add(sumC, -mul((y + 1), A[y]));
                sumC = add(sumC, -mul((z + 1), A[z]));
                swap(A, A, y, z);
                sumC = add(sumC, mul((y + 1), A[y]));
                sumC = add(sumC, mul((z + 1), A[z]));
            } else if (x == 3) {
                sumD = add(sumD, -mul((y + 1), B[y]));
                sumD = add(sumD, -mul((z + 1), B[z]));
                swap(B, B, y, z);
                sumD = add(sumD, mul((y + 1), B[y]));
                sumD = add(sumD, mul((z + 1), B[z]));
            }
            result[count++] = (int) add(mul(sumA, sumD), mul(sumB, sumC));
        }
        return result;
    }

}