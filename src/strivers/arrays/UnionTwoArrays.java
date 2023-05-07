package strivers.arrays;

import java.util.ArrayList;

public class UnionTwoArrays {

    private static void add(int arr[], ArrayList<Integer> result, int idx) {
        if (arr[idx] != result.get(result.size() - 1)) {
            result.add(arr[idx]);
        }
    }

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(Math.min(arr1[0], arr2[0]));
        int i1 = 0, i2 = 0;
        while (i1 != n && i2 != m) {
            if (arr1[i1] < arr2[i2]) {
                add(arr1, ans, i1++);
            } else if (arr1[i1] > arr2[i2]) {
                add(arr2, ans, i2++);
            } else {
                add(arr1, ans, i1++);
                i2++;
            }
        }
        while (i1 != n) add(arr1, ans, i1++);
        while (i2 != m) add(arr2, ans, i2++);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 4, 4, 4, 6, 6, 8, 9};
        int[] arr2 = new int[]{2, 3, 3, 4, 4, 7, 9, 9};
        ArrayList<Integer> ans = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println(ans);
    }

}
