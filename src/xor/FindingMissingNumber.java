package xor;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 in an array of size (n-1) one number from 1 to n missing. find that number
 * addition operation not allowed.
 * additional storage not allowed
 */
public class FindingMissingNumber {

    public static void main(String[] args) {
        int start = 1, n, numRemoved;
        Set<Integer> set;

        n = 100;
        set = IntStream.rangeClosed(start, n).boxed().collect(Collectors.toSet());
        numRemoved = (int)(Math.random()*n)+1;
        System.out.println("Num removed = "+numRemoved);
        set.remove(numRemoved);
        System.out.println(getMissing(set.stream().mapToInt(Integer::intValue).toArray(), n));


        n = 5;
        set = IntStream.rangeClosed(start, n).boxed().collect(Collectors.toSet());
        numRemoved = (int)(Math.random()*n)+1;
        System.out.println("Num removed = "+numRemoved);
        set.remove(numRemoved);
        System.out.println(getMissing(set.stream().mapToInt(Integer::intValue).toArray(), n));

    }

    private static int getMissing(int[] arr, int n) {
        int xor = 0;
        for (int i=1; i<=n; i++) xor ^= i;
        for (int num: arr) xor ^= num;
        return xor;
    }
}
