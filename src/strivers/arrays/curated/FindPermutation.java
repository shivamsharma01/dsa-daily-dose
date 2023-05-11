package strivers.arrays.curated;

import java.util.ArrayList;

public class FindPermutation {

    public static void main(String[] args) {
        System.out.println(new FindPermutation().findPerm("DDID", 5));
    }

    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> list = generateList(B);

        int idxString = 0, idxList = 0, n = A.length();

        while (idxString != n && idxList != B) {
            if (A.charAt(idxString++) == 'D') {
                int count = 1;
                while (idxString != n && A.charAt(idxString) == 'D') {
                    idxString++;
                    count++;
                }
                int temp, finalListIdx = idxList + count;
                count = finalListIdx;
                while (idxList < count) {
                    temp = list.get(idxList);
                    list.set(idxList++, list.get(count));
                    list.set(count--, temp);
                }
                idxList = finalListIdx;
            } else {
                idxList++;
            }
        }

        return list;
    }

    private ArrayList<Integer> generateList(int B) {
        ArrayList<Integer> ans = new ArrayList<>(B);

        for (int i = 0; i < B; i++) ans.add(i + 1);

        return ans;
    }

}
