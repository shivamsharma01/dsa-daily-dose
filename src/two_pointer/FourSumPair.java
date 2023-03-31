package two_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumPair {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 5, 6, 7, 16, 12, 55, 70, 19};
        int sum = 41;
        getFourSumPairs(arr, sum);
    }
    static class Pair {
        int sum;
        int first;
        int second;
        public Pair(int sum, int first, int second) {
            this.sum = sum;
            this.first = first;
            this.second = second;
        }
    }
    private static void getFourSumPairs(int[] arr, int x) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        int sum;
        List<Pair> pairList;
        for (int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                sum = arr[i] + arr[j];
                pairList = map.getOrDefault(sum, new ArrayList<>());
                pairList.add(new Pair(sum, i, j));
                map.put(sum, pairList);
            }
        }
        for (int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                sum = x-arr[i]-arr[j];
                if (map.containsKey(sum)) {
                    pairList = map.get(sum);
                    for (Pair pair: pairList) {
                        if(allDiff(pair, i, j) && isUnique(pair, i, j)) {
                            System.out.println(String.format("Sum can be formed with (%d:idx=%d), (%d:idx=%d), (%d:idx=%d), (%d:idx=%d)", arr[i], i, arr[j], j,
                                    arr[pair.first], pair.first, arr[pair.second], pair.second));
                        }
                    }
                }
            }
        }
    }

    private static boolean isUnique(Pair pair, int i, int j) {
        return i < pair.first && j < pair.first;
    }

    private static boolean allDiff(Pair pair, int i, int j) {
        return i != pair.first && i != pair.second && j != pair.first && j != pair.second;
    }
}
