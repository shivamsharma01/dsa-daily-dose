package strivers.arrays.hard;

import java.util.Arrays;

public class RepeatingAndMissingNumber {

    public static void main(String[] args) {
        int[] ar = new int[]{3,1,2,5,3};
        System.out.println(Arrays.toString(getMissing(ar)));

        int[] ax = new int[]{3,1,2,5,4,6,7,5};
        System.out.println(Arrays.toString(getMissing(ax)));
    }

    public static int[] getMissing(int[] arr) {
        int[] res = new int[2];
        int h = 0;

        while(h < arr.length - 1) {
            if(arr[h] != h + 1 && arr[arr[h] - 1] == arr[h]) {
                res[0] = arr[h];
                h++;
            }
            if(arr[h] != h + 1) {
                int temp = arr[h];
                arr[h] = arr[temp - 1];
                arr[temp - 1] = temp;
            } if(arr[h] == h + 1) {
                h++;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1) {
                res[1] = i + 1;
                if(i == arr.length - 1 && arr[arr[i] - 1] == arr[i]) {
                    res[0] = arr[i];
                }
            }
        }
        return res;
    }
}