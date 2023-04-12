package util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayUtil {

    private final static Random random = new Random();

    /*
    *
    * Can have duplicate values
    *
     */
    public static int[] generateArray(int maxVal, int len, boolean isZeroAllowed) {
        int arr[] = new int[len];
        int minVal = isZeroAllowed ? 0 : 1;
        for(int i=0; i<len; i++) {
            arr[i] = random.nextInt(maxVal+1) + minVal;
        }
        return arr;
    }

    public static int[] generateArrayUnique(int maxVal, int len, boolean isZeroAllowed) {
        int minVal = isZeroAllowed ? 0 : 1;
        if ((maxVal+minVal) < len) throw new IllegalArgumentException(String.format("Cannot Generate %d unique values between (0 and %d)", len, maxVal));
        int count = 0, num;
        Set<Integer> set = new HashSet<>();

        while (count != len) {
            num = random.nextInt(maxVal+1) + minVal;
            if(!set.contains(num)) {
                set.add(num);
                count++;
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void rotateArrayClockwise(int[] arr, int len, int numRotations) {
        numRotations = numRotations%len;
        if (numRotations == 0) return;

        int newArr[] = new int[len];
        Arrays.sort(arr);
        System.arraycopy(arr, len-numRotations, newArr, 0, numRotations);
        System.arraycopy(arr, 0, newArr, numRotations, len-numRotations);
        System.arraycopy(newArr, 0, arr, 0, len);
    }

    public static void rotateArrayAntiClockwise(int[] arr, int len, int numRotations) {
        numRotations = numRotations%len;
        if (numRotations == 0) return;

        int newArr[] = new int[len];
        Arrays.sort(arr);
        System.arraycopy(arr, numRotations, newArr, 0, len-numRotations);
        System.arraycopy(arr, 0, newArr, len-numRotations, numRotations);
        System.arraycopy(newArr, 0, arr, 0, len);
    }

    public static void swap(int arr[], int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static int getRandomElementFromArray(int arr[], int len) {
        return arr[random.nextInt(len)];
    }
}
