package strivers.arrays;

public class MissingNumberInOneToN {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 4, 6, 2, 3}; // 5 is the missing num
        System.out.println(missingNum(arr, arr.length));
    }

    private static int missingNum(int arr[], int n) {
        int xorredNum = 0;

        for (int i = 1; i <= n; i++) xorredNum ^= i;

        for (int num : arr) xorredNum ^= num;

        return xorredNum;
    }

}
