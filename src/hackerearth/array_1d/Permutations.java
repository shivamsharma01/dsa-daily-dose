package hackerearth.array_1d;

import java.util.Scanner;

/*
    https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/nevedle-and-permutations-c6acb85e/
 */
public class Permutations {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();

        int arr[] = new int[n], leftMax[] = new int[n], rightMax[] = new int[n];
        for (int i=0; i<n; i++) arr[i] = s.nextInt();

        leftMax[0] = -1;
        for (int i=1; i<n; i++) leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);

        rightMax[n-1] = -1;
        for (int i=n-2; i>=0; i--) rightMax[i] = Math.max(rightMax[i+1], arr[i+1]);

        while (q-- != 0) {
            int left = s.nextInt(), right = s.nextInt();
            int leftMaxVal = leftMax[left-1], rightMaxVal = rightMax[right-1];
            System.out.println(Math.max(leftMaxVal, rightMaxVal));
        }
    }

}
