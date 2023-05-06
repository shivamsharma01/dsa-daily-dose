package strivers.arrays.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PairsWithDiffK {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> freqMap = new HashMap<>();
        String line = br.readLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(parts[0]), k = Integer.parseInt(parts[1]), num, pairs = 0;

        line = br.readLine();
        parts = line.split(" ");
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(parts[i]);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int i : freqMap.keySet()) {
            if (freqMap.containsKey(i + k)) pairs += freqMap.get(i + k);
        }

        System.out.println(pairs);
    }

}