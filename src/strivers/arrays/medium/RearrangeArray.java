package strivers.arrays.medium;

import java.util.Arrays;

public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        int posIdx = 0;
        int negIdx = 1;
        int[] arr = new int[nums.length];

        for (int num : nums) {
            if (num > 0) {
                arr[posIdx] = num;
                posIdx += 2;
            } else {
                arr[negIdx] = num;
                negIdx += 2;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{2, -3, 4, 5, -6, -7, 8, 9, -1, -2, 3, -4, 5, -6, 7, -21};
        System.out.println(Arrays.toString(rearrangeArray(ar)));
    }
}
