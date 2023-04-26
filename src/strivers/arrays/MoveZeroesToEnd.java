package strivers.arrays;

import util.ArrayUtil;

import java.util.Arrays;

public class MoveZeroesToEnd {

    private static void moveZero(int[] arr) {
        int n = arr.length;
        int zeroIndex, idx = 0;
        while (idx < n && arr[idx] != 0) idx++;
        if (idx == n) return;
        zeroIndex = idx++;
        while (idx != n) {
            if (arr[idx] != 0)
                ArrayUtil.swap(arr, zeroIndex++, idx);
            idx++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{73348, 66106, -85359, 53996, 18849, -6590, -53381, -86613, -41065, 83457, 0};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }
}
