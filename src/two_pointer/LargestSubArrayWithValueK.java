package two_pointer;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithValueK {
    public static void main(String[] args) {
        int arr[], k;
        arr = new int[]{1, 4, 5, 6, 10, -10};
        k = 15;
        System.out.println(getLargestSubArrayWithValueK(arr, k));

    }

    private static int getLargestSubArrayWithValueK(int[] arr, int k) {
        int maxSubArray = 0;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) maxSubArray = i + 1;
            if (map.containsKey(sum - k)) maxSubArray = Math.max(maxSubArray, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return maxSubArray;
    }
}
