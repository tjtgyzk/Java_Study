package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class L933 {
    Deque<Integer> list;

    public L933() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.add(Integer.valueOf(t));
        while (list.peek() < t - 3000) {
            list.pop();
        }
        return list.size();
    }
}
