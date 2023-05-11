package strivers.arrays.easy;

public class RemoveDuplicatesFromSorted {

    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[uniqueIndex] != nums[i]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

}
