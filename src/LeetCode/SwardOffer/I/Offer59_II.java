package LeetCode.SwardOffer.I;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59_II {
    Deque<Integer> que;
    Deque<Integer> max;

    public Offer59_II() {
        que = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return !max.isEmpty() ? max.peekFirst() : -1;
    }

    public void push_back(int value) {
        que.add(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        int ans = que.isEmpty() ? -1 : que.pollFirst();
        if (!max.isEmpty() && ans == max.peekFirst()) {
            max.pollFirst();
        }
        return ans;
    }
}
