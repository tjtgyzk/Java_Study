package yu.Recursion;

import java.util.Stack;

public class Stck {
    public static int f(Stack<Integer> stack) {
        int thisPop = stack.pop();
        if (stack.isEmpty()) {
            return thisPop;
        }
        int last = f(stack);
        stack.push(thisPop);
        return last;
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int bottom = f(stack);
        reverse(stack);
        stack.push(bottom);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
