package LeetCode.SwardOffer.I;

import java.util.Deque;
import java.util.LinkedList;

public class Offer30 {
    Deque<Integer> stack;
    Deque<Integer> min;

    public Offer30() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
