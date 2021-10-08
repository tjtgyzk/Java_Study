package yu;

import java.util.Arrays;
import java.util.Random;

public class Queue_Array {
    int[] arr;
    int maxSize;
    private int begin = 0;
    private int end = 0;
    int size = 0;

    public Queue_Array(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("SB");
        } else {
            arr[end] = n;
            end = (++end) % maxSize;
            size++;
        }
    }

    public int out() {
        if (isEmpty()) {
            throw new RuntimeException("SBSBSB");
        } else {
            int ans = arr[begin];
            begin = (++begin) % maxSize;
            size--;
            return ans;
        }
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }


}
