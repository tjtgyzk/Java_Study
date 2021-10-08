package yu;

import java.util.Arrays;

public class Stack_Array {
    int maxSize = 0;
    int[] arr;
    private int index = 0;

    public Stack_Array(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void push(int n) {
        if (index == maxSize) {
            System.out.println("满了SB");
        } else {
            arr[index] = n;
            index++;
        }
    }

    public int pop() {

        int ans = arr[index - 1];
        index--;
        return ans;
    }

    public void peek() {
        System.out.println(arr[index - 1]);
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
    }

    public void showIndex() {
        System.out.println(index - 1);
    }
}
