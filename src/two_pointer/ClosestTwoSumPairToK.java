package two_pointer;

public class ClosestTwoSumPairToK {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int k = 70;
        arr1 = new int[]{1, 4, 9, 25, 40};
        arr2 = new int[]{15, 22, 34, 40, 49, 60};
        findClosestPair(arr1, arr2, k);
        k = 80;
        findClosestPair(arr1, arr2, k);
    }

    private static void findClosestPair(int[] arr1, int[] arr2, int k) {
        int n = arr1.length, m = arr2.length, i = 0, j = m - 1;
        int diff = Integer.MAX_VALUE, lVal = -1, rVal = -1, curSum;
        while (i != n && j != -1) {
            curSum = arr1[i] + arr2[j];
            if (curSum == k) {
                System.out.println(String.format("%d + %d = %d", arr1[i], arr2[j], k));
                return;
            }
            if (Math.abs(curSum - k) < diff) {
                diff = Math.abs(curSum - k);
                lVal = arr1[i];
                rVal = arr2[j];
            } else if (curSum < k) {
                i++;
            } else {
                j--;
            }
        }
        if (diff != Integer.MAX_VALUE)
            System.out.println(String.format("%d and %d form the closest pair to %d with diff %d", lVal, rVal, k, diff));
    }
}
