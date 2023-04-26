package strivers.arrays;

import java.util.ArrayList;

public class UnionTwoArrays {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(Math.min(arr1[0], arr2[0]));
        int i1 = 0, i2 = 0, len = 0;
        while (i1 != n && i2 != m) {
            if (arr1[i1] < arr2[i2]) {
                if (arr1[i1] != ans.get(len)) {
                    ans.add(arr1[i1]);
                    len++;
                }
                i1++;
            } else if (arr1[i1] > arr2[i2]) {
                if (arr2[i2] != ans.get(len)) {
                    ans.add(arr2[i2]);
                    len++;
                }
                i2++;
            } else {
                if (arr1[i1] != ans.get(len)) {
                    ans.add(arr1[i1]);
                    len++;
                }
                i1++;
                i2++;
            }
        }
        while (i1 != n) {
            if (arr1[i1] != ans.get(len)) {
                ans.add(arr1[i1]);
                len++;
            }
            i1++;
        }
        while (i2 != m) {
            if (arr2[i2] != ans.get(len)) {
                ans.add(arr2[i2]);
                len++;
            }
            i2++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 4, 4, 4, 6, 6, 8, 9};
        int[] arr2 = new int[]{2, 3, 3, 4, 4, 7, 9, 9};
        ArrayList<Integer> ans = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println(ans);
    }

}
