package strivers.arrays;

import java.util.ArrayList;

public class IntersectionTwoArrays {

    public static ArrayList<Integer> findIntersection(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i1 = 0, i2 = 0, len = 0;
        while (i1 != n && i2 != m) {
            if (arr1[i1] < arr2[i2]) {
                i1++;
            } else if (arr1[i1] > arr2[i2]) {
                i2++;
            } else {
                int num = arr1[i1];
                ans.add(num);
                while (i1 != n && arr1[i1] == num) i1++;
                while (i2 != m && arr2[i2] == num) i2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = new int[]{1, 1, 1, 4, 4, 4, 6, 6, 8, 9};
        int arr2[] = new int[]{2, 3, 3, 4, 4, 7, 9, 9};
        ArrayList<Integer> ans = findIntersection(arr1, arr2, arr1.length, arr2.length);
        System.out.println(ans);
    }

}
