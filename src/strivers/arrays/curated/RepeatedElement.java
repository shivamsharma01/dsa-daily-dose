package strivers.arrays.curated;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedElement {

    public static void main(String[] args) {
        System.out.println(new RepeatedElement().repeatedNumber(Arrays.asList(1, 2, 3)));
        System.out.println(new RepeatedElement().repeatedNumber(Arrays.asList(1, 2, 2)));
        System.out.println(new RepeatedElement().repeatedNumber(Arrays.asList(3, 1, 4, 1, 4)));
    }

    public int repeatedNumber(final List<Integer> A) {
        Set<Integer> s = new HashSet<>();

        for (int e : A) {
            if (s.contains(e)) return e;
            else s.add(e);
        }
        return -1;
    }

}


