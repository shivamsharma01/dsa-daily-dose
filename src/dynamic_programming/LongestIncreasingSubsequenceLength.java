package dynamic_programming;

/*
    https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequenceLength {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length, dp[] = new int[n], ans = 0;
        for (int i = 0; i < n; i++) {
            int low = 0, high = ans;
            while (low != high) {
                int mid = low + (high - low) / 2;
                if (nums[i] <= dp[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            dp[low] = nums[i];
            if (low == ans) ans++;
        }
        return ans;
    }
}
