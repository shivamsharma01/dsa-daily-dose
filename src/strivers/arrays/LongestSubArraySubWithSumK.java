package strivers.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySubWithSumK {

    public static int lenOfLongSubArr(int[] A, int N, int K) {
        long prefixSum = A[0];
        Map<Long, Integer> map = new HashMap<>();

        int lengthOfLongestSubArrayWithSumK = A[0] == K ? 1 : 0;

        map.put(prefixSum, 0);

        for (int i = 1; i < N; i++) {
            prefixSum += A[i];
            if (!map.containsKey(prefixSum)) map.put(prefixSum, i);
            if (prefixSum == K) lengthOfLongestSubArrayWithSumK = i + 1;
            else if (map.containsKey(prefixSum - K)) {
                lengthOfLongestSubArrayWithSumK = Math.max(lengthOfLongestSubArrayWithSumK, i - map.get(prefixSum - K));
            }
        }

        return lengthOfLongestSubArrayWithSumK;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 3, 1, 0, -1};
        System.out.println(lenOfLongSubArr(arr, arr.length, 8));
    }
}
