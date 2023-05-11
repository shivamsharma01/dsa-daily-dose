package strivers.arrays.curated;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSubSquare {

    private static ArrayList<Integer> convertToArrayList(int... i) {
        ArrayList<Integer> out = new ArrayList<>();
        for (int e : i) out.add(e);
        return out;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>(
                Arrays.asList(
                        convertToArrayList(1, 1, 1, 1, 1),
                        convertToArrayList(2, 2, 2, 2, 2),
                        convertToArrayList(3, 8, 6, 7, 3),
                        convertToArrayList(4, 4, 4, 4, 4),
                        convertToArrayList(5, 5, 5, 5, 5)
                ));
        System.out.println(new MaximumSumSubSquare().solve(input, 3));
    }

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size(), num;

        for (int i = 1; i < n; i++) {
            num = A.get(0).get(i);
            A.get(0).set(i, num + A.get(0).get(i - 1));
            num = A.get(i).get(0);
            A.get(i).set(0, num + A.get(i - 1).get(0));
        }

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> prev = A.get(i - 1);
            ArrayList<Integer> row = A.get(i);
            for (int j = 1; j < n; j++) {
                row.set(j, row.get(j) + row.get(j - 1) + prev.get(j) - prev.get(j - 1));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = B - 1; i < n; i++) {
            for (int j = B - 1; j < n; j++) {
                int sum = A.get(i).get(j);
                if (j > B - 1) sum -= A.get(i).get(j - B);
                if (i > B - 1) sum -= A.get(i - B).get(j);
                if (j > B - 1 && i > B - 1) sum += A.get(i - B).get(j - B);
                max = Math.max(max, sum);
            }
        }

        return max;
    }

}
