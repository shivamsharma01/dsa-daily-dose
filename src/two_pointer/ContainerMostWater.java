package two_pointer;

/**
 * We have to form the largest rectangle possible such that while selecting a rectangle:
 * 1. its width is the gap between the towers we are considering and
 * 2. its height is the min of both the towers we are considering
 *
 * TRICK: in case both the towers have the same height we are moving in from both the sides because there can be no tower between these two towers
 * which can give a better answer with any of these towers.
 *
**/
public class ContainerMostWater {
    public static void main(String[] args) {
        int arr[];
        arr = new int[] {2, 8, 4, 6, 11, 1};
        System.out.println(getMostWaterForContainer(arr, arr.length));
    }

    private static int getMostWaterForContainer(int[] arr, int length) {
        int maxVal = Integer.MIN_VALUE;
        int i = 0, j = length - 1;
        while(i < j) {
            if(arr[i] < arr[j]) {
                if(arr[i] * (j-i) > maxVal) maxVal = arr[i] * (j-i);
                i++;
            } else if(arr[i] > arr[j]) {
                if(arr[j] * (j-i) > maxVal) maxVal = arr[j] * (j-i);
                j--;
            } else {
                if(arr[i] * (j-i) > maxVal) maxVal = arr[i] * (j-i);
                i++;
                j--;
            }
        }
        return maxVal;
    }
}
