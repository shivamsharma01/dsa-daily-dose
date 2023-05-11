package strivers.arrays.easy;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;

        for (int i : nums) {
            if (i == 0) {
                if (count != 0) {
                    maxCount = Math.max(count, maxCount);
                }
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(count, maxCount);
    }

}