package strivers.arrays.medium;

public class StockBuyAndSell {
    /*
      You are given an array of prices where prices[i] is the price of a given stock on an ith day.
      You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
      in the future to sell that stock. Return the maximum profit you can achieve from this transaction.
      If you cannot achieve any profit, return 0.
     */

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }

    public static int maxProfit(int[] arr) {
        int l = arr[0];
        int max = 0;

        for (int j : arr) {
            max = Math.max(j - l, max);
            l = Math.min(l, j);
        }
        return max;
    }
}
