package hackerearth.array_1d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
    https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/array-queries-again-7948f256/
 */
public class ArrayQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            String[] arr_B = br.readLine().split(" ");
            int[] B = new int[M];
            for(int i_B = 0; i_B < arr_B.length; i_B++)
            {
                B[i_B] = Integer.parseInt(arr_B[i_B]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[Q][3];
            for(int i_queries = 0; i_queries < Q; i_queries++)
            {
                String[] arr_queries = br.readLine().split(" ");
                for(int j_queries = 0; j_queries < arr_queries.length; j_queries++)
                {
                    queries[i_queries][j_queries] = Integer.parseInt(arr_queries[j_queries]);
                }
            }

            int[] out_ = array_queries(N, M, A, B, Q, queries);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }

            System.out.println();

        }

        wr.close();
        br.close();
    }

    final static int MOD = 998244353;

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

    static int[] array_queries(int N, int M, int[] A, int[] B, int Q, int[][] queries){
        int[] result = new int[Q+1];
        int count = 0;

        long sumA = 0, sumB = 0, sumC = 0, sumD = 0;
        for (int i = 0; i < N; i++) {
            sumA = add(sumA, A[i]);
            sumC = add(sumC, mul(i + 1, A[i]));
        }
        for (int i = 0 ; i < M; i++) {
            sumB = add(sumB, B[i]);
            sumD = add(sumD, mul(i + 1, B[i]));
        }
        long op = add(mul(sumA, sumD), mul(sumB, sumC));
        result[count++] = (int)op;
        for (int[] query: queries) {
            int x = query[0], y = query[1]-1, z = query[2]-1;
            if (x == 1) {
                sumA  = add(sumA, -A[y]);
                sumB  = add(sumB, -B[z]);
                sumC  = add(sumC, - mul((y + 1), A[y]));
                sumD = add(sumD, -mul((z + 1), B[z]));
                swap(A, B, y, z);
                sumA  = add(sumA, A[y]);
                sumB  = add(sumB, B[z]);
                sumC  = add(sumC, mul((y + 1), A[y]));
                sumD = add(sumD, mul((z + 1), B[z]));
            } else if (x == 2) {
                sumC  = add(sumC, - mul((y + 1), A[y]));
                sumC = add(sumC, -mul((z + 1), A[z]));
                swap(A, A, y, z);
                sumC  = add(sumC, mul((y + 1), A[y]));
                sumC = add(sumC, mul((z + 1), A[z]));
            } else if (x == 3) {
                sumD  = add(sumD, - mul((y + 1), B[y]));
                sumD = add(sumD, -mul((z + 1), B[z]));
                swap(B, B, y, z);
                sumD  = add(sumD, mul((y + 1), B[y]));
                sumD = add(sumD, mul((z + 1), B[z]));
            }
            result[count++] = (int)add(mul(sumA, sumD), mul(sumB, sumC));
        }
        return result;
    }

}