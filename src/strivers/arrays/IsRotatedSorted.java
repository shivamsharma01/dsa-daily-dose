package strivers.arrays;

public class IsRotatedSorted {

    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) count++;
        }
        return count == 0 || count == 1 && nums[0] >= nums[nums.length - 1];
    }

}
