package strivers.arrays.curated;

import java.util.Arrays;
import java.util.Scanner;

public class ArrangeArrayNum {
    /*
    5
    90 87 94 9 819
    [9, 94, 90, 87, 819]

    4
    54 546 548 60
    [60, 548, 546, 54]

    8
    1 34 3 98 9 76 45 4
    [9, 98, 76, 45, 4, 34, 3, 1]
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(sc.nextInt());
        }
        Arrays.sort(arr, (str1, str2) -> {
            int n1 = str1.length(), n2 = str2.length();
            if (n1 < n2) {
                int i = 0;
                while (i != n1) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        return str2.charAt(i) - str1.charAt(i);
                    }
                    i++;
                }
                int j = 0;
                while (i != n2) {
                    if (str2.charAt(j) != str2.charAt(i)) {
                        return str2.charAt(i) - str2.charAt(j);
                    }
                    i++;
                    j++;
                }
                i = 0;
                while (j != n2) {
                    if (str1.charAt(i) != str2.charAt(j)) {
                        return str2.charAt(j) - str1.charAt(i);
                    }
                    i++;
                    j++;
                }
            } else if (n2 < n1) {
                int i = 0;
                while (i != n2) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        return str2.charAt(i) - str1.charAt(i);
                    }
                    i++;
                }
                int j = 0;
                while (i != n1) {
                    if (str1.charAt(j) != str1.charAt(i)) {
                        return str1.charAt(j) - str1.charAt(i);
                    }
                    i++;
                    j++;
                }
                i = 0;
                while (j != n1) {
                    if (str2.charAt(i) != str1.charAt(j)) {
                        return str2.charAt(i) - str1.charAt(j);
                    }
                    i++;
                    j++;
                }
            } else {
                int i = 0;
                while (i != n2) {
                    if (str1.charAt(i) != str2.charAt(i)) {
                        return str2.charAt(i) - str1.charAt(i);
                    }
                    i++;
                }
            }
            return -1;
        });
        // 6054854654
        System.out.println(Arrays.toString(arr));
    }
}
