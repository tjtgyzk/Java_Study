package myStudy.Zuo.z19_upperStack;

import java.util.Deque;
import java.util.LinkedList;

public class ReturnMaxSquare {
    public static int getMax(int[] heights) {
        if (heights.length == 0 || heights == null) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int now = stack.pop();
                int L = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, L * heights[now]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int now = stack.pop();
            int L = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, L * heights[now]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(getMax(arr));
    }
}
