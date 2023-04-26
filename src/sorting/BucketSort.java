package sorting;

import java.util.Arrays;

public class BucketSort {

    public static void sort(float[] arr) {
        Node[] arrayforEachDigit0to9 = new Node[10];

        for (float f : arr) {
            add(arrayforEachDigit0to9, f);
        }
        collectSortedInArr(arr, arrayforEachDigit0to9);
    }

    private static void add(Node[] arr, float num) {
        int index = (int) (num * 10) % 10;
        Node newNode = new Node(num);
        if (arr[index] == null) {
            // if the bucket is currently empty just create a new node and consider that as the bucket
            arr[index] = newNode;
        } else {
            // find the new node's correct position in the bucket
            placeInSortedLinkedList(arr, index, newNode);
        }
    }

    private static void placeInSortedLinkedList(Node[] arr, int index, Node newNode) {
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

    private static void collectSortedInArr(float[] num, Node[] arr) {
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
        final float num;
        Node next;

        Node(float f) {
            this.num = f;
            this.next = null;
        }

    }

}

class BucketSortRunner {
    public static void main(String[] args) {
        float[] arr = new float[]{0.21f, 0.5f, 0.1f, 0.4f, 0.2f, 0.9f, 0.3f, 0.1f, 0.14f, 0.17f, 0.4f, 0.22f};
        System.out.println(Arrays.toString(arr));
        BucketSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}