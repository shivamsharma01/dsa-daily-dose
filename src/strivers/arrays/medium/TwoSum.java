package strivers.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 1, 6, 2, 8, 12, 15};
        int k = 14;
        getTwoSumUsingHashMap(arr, k);
        getTwoSumUsingTwoPointers(arr, k);
    }

    private static void getTwoSumUsingTwoPointers(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left != right) {
            if (arr[left] + arr[right] > target) right--;
            else if (arr[left] + arr[right] < target) left++;
            else {
                System.out.println("Target sum " + target + " can be formed using " + arr[left] + " present at index " + left + " and " + arr[right] + " present at index " + right);
                return;
            }
        }
    }

    private static void getTwoSumUsingHashMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                System.out.println("Target sum " + target + " can be formed using " + map.get(target - arr[i]) + " present at index " + arr[map.get(target - arr[i])] + " and " + arr[i] + " present at index " + i);
                return;
            }
            map.put(arr[i], i);
        }
    }

}
