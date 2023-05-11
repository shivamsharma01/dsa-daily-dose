package strivers.arrays.easy;

public class OnlyNumberThatAppearOnce {

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int i : nums) xor ^= i;

        return xor;
    }

}
