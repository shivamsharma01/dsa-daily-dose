package strivers.arrays.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip01 {

    public static void main(String[] args) {
        Flip01 sol = new Flip01();
        sol.getMax("10");
        sol.getMax("0100");
        sol.getMax("1111");
        sol.getMax("1100");
        sol.getMax("1110");
        sol.getMax("1101");
        sol.getMax("0000");
    }

    public ArrayList<Integer> flip(String A) {

        int flipCount = 0, ansFlipCount = 0, start = -1, end = -1, n = A.length();

        for (int tempStart = 0, tempEnd = 0; tempEnd < n; tempEnd++) {
            if (A.charAt(tempEnd) == '1') flipCount--;
            else flipCount++;
            if (flipCount < 0) {
                tempStart = tempEnd + 1;
                flipCount = 0;
            }

            if (flipCount > ansFlipCount) {
                ansFlipCount = flipCount;
                start = tempStart + 1;
                end = tempEnd + 1;
            }
        }

        return end != -1 ? new ArrayList<>(Arrays.asList(start, end)) : new ArrayList<>();
    }

    private void getMax(String a) {
        System.out.println(a);
        ArrayList<Integer> l = flip(a);
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!l.isEmpty() && i >= l.get(0) - 1 && i <= l.get(1)) {
                System.out.print(c == '0' ? '1' : '0');
            } else {
                System.out.print(c);
            }
        }
        System.out.println("\n=================");
    }

}
