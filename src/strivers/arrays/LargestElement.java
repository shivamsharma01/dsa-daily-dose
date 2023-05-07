package strivers.arrays;

public class LargestElement {

    public int largest(int[] arr, int n) {
        int max = arr[0];
        for (int elm : arr) max = Math.max(max, elm);
        return max;
    }

}
