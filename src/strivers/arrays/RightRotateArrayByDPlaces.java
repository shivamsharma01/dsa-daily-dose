package strivers.arrays;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RightRotateArrayByDPlaces {

    private static void rightRotateArrayByD(int arr[], int d) {
        ArrayUtil.rotateArrayClockwise(arr, arr.length, d);
    }

    public static void main(String[] args) {
        for (int d = 1; d <= 3; d++) {
            for (int i = 1; i <= 10; i++) {
                int arr[] = IntStream.rangeClosed(1, i).toArray();
                System.out.println("Original Array");
                System.out.println(Arrays.toString(arr));
                System.out.println("Rotating the array right " + d + " times");
                rightRotateArrayByD(arr, d);
                //leftRotate(arr, d, arr.length);
                System.out.println(Arrays.toString(arr));
                System.out.println("============================");
            }
        }
    }
}