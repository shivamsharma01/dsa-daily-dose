package binary_search;

import dynamic_programming.LongestIncreasingSubsequenceLength;

import java.util.Arrays;
import java.util.Comparator;

/*
  each pair is of the form [width, height]
  To place an envelope inside another envelope it's width and height should be strictly less than the outer envelope
 */
public class RussianDollEnvelope {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {3, 4}, {2, 5}, {3, 6}};
        System.out.println(getMaxEnvelopes(arr));
    }

    private static int getMaxEnvelopes(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int[] heights = Arrays.asList(arr).stream().map(o -> o[1]).mapToInt(Integer::intValue).toArray();
        return LongestIncreasingSubsequenceLength.lengthOfLIS(heights);
    }


}
