package strivers.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySubWithSumK {

    public static int lenOfLongSubarr(int A[], int N, int K) {
        long prefixSum[] = new long[N];
        Map<Long, Integer> map = new HashMap<>();

        int lengthOfLongestSubArrayWithSumK = A[0] == K ? 1 : 0;

        prefixSum[0] = A[0];
        map.put(prefixSum[0], 0);

        for (int i=1; i<N; i++) {
            prefixSum[i] = prefixSum[i-1]+A[i];
            if (!map.containsKey(prefixSum[i])) map.put(prefixSum[i], i);
            if(prefixSum[i] == K) lengthOfLongestSubArrayWithSumK = i+1;
            else if (map.containsKey(prefixSum[i]-K)) {
                lengthOfLongestSubArrayWithSumK = Math.max(lengthOfLongestSubArrayWithSumK, i - map.get(prefixSum[i]-K));
            }
        }

        return lengthOfLongestSubArrayWithSumK;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {4, 2, 5, 3, 1, 0, -1};
        System.out.println(lenOfLongSubarr(arr, arr.length, 8));
    }
}
