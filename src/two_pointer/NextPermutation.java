package two_pointer;

import java.util.Arrays;

/*
  number will not start with 0
  number will be non-empty and positive
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr;
        arr = "2154300".chars().toArray();
        System.out.println(Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));


        arr = "2".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "9".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "99".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "123".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "321".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "1023".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "3201".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "10243".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

        arr = "1991".chars().toArray();
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        int i = n - 2, j = -1;
        while (i != -1 && nums[i] >= nums[i + 1]) i--;

        if (i == -1) {
            i = 0;
            for (j = n - 1; i < j; i++, j--) {
                swap(nums, i, j);
            }
        } else {
            j = i + 1;
            int num = 101, idx = -1;
            while (j != n) {
                if (nums[j] > nums[i] && nums[j] <= num) {
                    num = nums[j];
                    idx = j;
                }
                j++;
            }
            swap(nums, i, idx);
            i++;
            for (j = n - 1; i < j; i++, j--) {
                swap(nums, i, j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}