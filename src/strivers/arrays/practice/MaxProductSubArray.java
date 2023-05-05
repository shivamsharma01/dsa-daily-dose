package strivers.arrays.practice;

import java.util.Scanner;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod = 1;
        for (int i : nums) {
            prod *= i;
            max = Math.max(prod, max);
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Math.max(prod, max);
            if (prod == 0) prod = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(maxProduct(arr));
    }
}
