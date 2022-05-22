package LeetCode.SwardOffer.I;

import java.util.Deque;
import java.util.LinkedList;

public class Offer09 {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public Offer09() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.isEmpty() ? -1 : outStack.pop();
    }
}
