package sorting;

import java.util.Arrays;

public class RadixSort {

    public static void sort(int arr[]) {
        int maxNum = Arrays.stream(arr).max().getAsInt();
        int d = 0;

        while (maxNum != 0) {
            maxNum /= 10;
            d++;
        }

        BucketSort.sort(arr, d);
    }

    static class BucketSort {

        public static void sort(int arr[], int maxLengthNum) {
            int n = arr.length, digitPlace = 0;
            while (maxLengthNum-- != 0) {
                Node arrayforEachDigit0to9[] = new Node[10];
                for (int i = 0; i < n; i++) {
                    add(arrayforEachDigit0to9, arr[i], index(arr[i], digitPlace));
                }
                collectSortedInArr(arr, arrayforEachDigit0to9);
                digitPlace++;
            }
        }

        private static int index(int num, int digitPlace) {
            while (num != 0 && digitPlace != 0) {
                num /= 10;
                digitPlace--;
            }
            return num % 10;
        }

        private static void add(Node arr[], int num, int index) {
            Node newNode = new Node(num);
            if (arr[index] == null) {
                // if the bucket is currently empty just create a new node and consider that as the bucket
                arr[index] = newNode;
            } else {
                // find the new node's correct position in the bucket
                placeInSortedLinkedList(arr, index, newNode);
            }
        }

        private static void placeInSortedLinkedList(Node arr[], int index, Node newNode) {
            Node headNode = arr[index];
            Node prevNode = null, curNode = headNode;
            while (curNode != null) {
                if (curNode.num > newNode.num) {
                    if (prevNode != null) {
                        // found the correct place somewhere in the middle
                        prevNode.next = newNode;
                        newNode.next = curNode;
                    } else {
                        // correct place is at the beginning - smallest in the bucket
                        newNode.next = headNode;
                        arr[index] = newNode;
                    }
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
            // correct place is at the end - largest in the bucket
            prevNode.next = newNode;
        }

        private static void collectSortedInArr(int num[], Node arr[]) {
            int idx = 0;
            for (Node node : arr) {
                if (node == null) continue;
                while (node != null) {
                    num[idx++] = node.num;
                    node = node.next;
                }
            }
        }

        static class Node {
            int num;
            Node next;

            Node(int num) {
                this.num = num;
                this.next = null;
            }

        }

    }

}

class RadixSortRunner {
    public static void main(String[] args) {
        int arr[] = new int[]{21, 5, 1, 4, 2, 9, 3, 1, 14, 17, 4, 22};
        System.out.println(Arrays.toString(arr));
        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}