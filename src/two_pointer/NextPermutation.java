
/*
  number will not start with 0
  number will be non-empty and positive
 */
public class NextPermutation {
    public static void main(String[] args) {
        System.out.println(getNextPermutation("2154300"));
        System.out.println(getNextPermutation("2"));
        System.out.println(getNextPermutation("9"));
        System.out.println(getNextPermutation("99"));
        System.out.println(getNextPermutation("123"));
        System.out.println(getNextPermutation("321"));
        System.out.println(getNextPermutation("1023"));
        System.out.println(getNextPermutation("3201"));
        System.out.println(getNextPermutation("10243"));
    }

    private static String getNextPermutation(String str) {
        int len = str.length();
        if(len <= 1) return str;

        char[] arr = str.toCharArray();
        Integer firstSmallerIndex = null;
        for(int i=len-1; i>0; i--) {
            if(arr[i-1] < arr[i]) {
                firstSmallerIndex = i-1;
                break;
            }
        }
        if (firstSmallerIndex == null) {
            // this case means that this is the largest permutation with the available digits therefore just reverse it.
            StringBuilder sb = new StringBuilder("");
            for(int i=len-1; i>=0; i--)
                sb.append(arr[i]);
            return sb.toString();
        } else {
            // this case means there is a possible next larger permutation available by interchanging digit stored in firstSmaller
            Integer nextSmallestLargerIndex = null, idx = firstSmallerIndex + 1;
            while(idx != len) {
                if(arr[firstSmallerIndex] < arr[idx] && (nextSmallestLargerIndex == null || arr[nextSmallestLargerIndex] > arr[idx])) {
                    nextSmallestLargerIndex = idx;
                }
                idx++;
            }
            char temp = arr[firstSmallerIndex];
            arr[firstSmallerIndex] = arr[nextSmallestLargerIndex];
            arr[nextSmallestLargerIndex] = temp;

            for(int i=firstSmallerIndex+1, j = len-1; i<j; i++, j--) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        }
    }
}