package strivers.arrays.medium;

public class MajorityElement {

    public static void main(String[] args) {
        printMajority(new int[]{1, 1, 2, 2, 3});
        printMajority(new int[]{1, 1, 2, 2, 1});
        printMajority(new int[]{1, 2, 3, 4, 3});
        printMajority(new int[]{1, 2, 3, 4, 5});
    }

    private static void printMajority(int[] arr) {
        int n = arr.length;

        int count = 1, element = arr[0];

        for (int i = 1; i < n; i++) {
            if (count == 0) element = arr[i];
            if (element != arr[i]) count--;
            else count++;
        }
        if (count <= 0) {
            System.out.println("There is no majority element");
            return;
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) count++;
        }
        if (count > Math.floorDiv(n, 2)) {
            System.out.println(element + " is the majority element in the array.");
        } else {
            System.out.println("There is no majority element");
        }
    }

}
