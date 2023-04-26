package strivers.arrays;

public class SecondLargest {

    int printSecondLargest(int arr[], int n) {
        int max = arr[0], secMax = -1;
        for (int elm : arr) {
            if (elm > max) {
                secMax = max;
                max = elm;
            } else if (max != elm && elm > secMax) {
                secMax = elm;
            }
        }
        return secMax;
    }

}
