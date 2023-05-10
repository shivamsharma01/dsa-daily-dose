package strivers.arrays.curated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KthIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken()), num, l, r, p, k, s, e, mid, ans, start, end;

        st = new StringTokenizer(br.readLine());
        List<Integer> list;
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            if (!indexMap.containsKey(num))
                list = new ArrayList<>();
            else
                list = indexMap.get(num);
            list.add(i);
            indexMap.put(num, list);
        }

        while (q-- != 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            list = indexMap.get(p);
            if (list == null || list.size() < k) {
                System.out.println(-1);
                continue;
            }

            if (list.get(0) >= l) {
                start = 0;
            } else {
                s = 0;
                e = list.size() - 1;
                ans = -1;
                while (s <= e) {
                    mid = s + (e - s) / 2;
                    if (list.get(mid) < l) {
                        s = mid + 1;
                    } else {
                        ans = mid;
                        e = mid - 1;
                    }
                }
                if (ans == -1) {
                    System.out.println(-1);
                    continue;
                }
                start = ans;
            }

            if (list.get(list.size() - 1) <= r) {
                end = list.size() - 1;
            } else {
                s = 0;
                e = list.size() - 1;
                ans = -1;
                while (s <= e) {
                    mid = s + (e - s) / 2;
                    if (list.get(mid) <= r) {
                        ans = mid;
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                if (ans == -1) {
                    System.out.println(-1);
                    continue;
                }
                end = ans;
            }

            if (end - start + 1 < k) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(start + k - 1) + 1);
            }
        }
    }

}