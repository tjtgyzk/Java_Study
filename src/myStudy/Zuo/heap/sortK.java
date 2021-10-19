package myStudy.Zuo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class sortK {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 4};
        sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            heap.add(arr[i]);
        }
        int i = 0, j = k + 1;
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
            while (j < arr.length) {
                heap.add(arr[j++]);
            }
        }
    }
}
