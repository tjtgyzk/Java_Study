package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_42 {
    class RecentCounter {
        Deque<Integer> que;

        public RecentCounter() {
            que = new LinkedList<>();
        }

        public int ping(int t) {
            while (!que.isEmpty() && que.peekFirst() < t - 3000) {
                que.pollFirst();
            }
            que.add(t);
            return que.size();
        }
    }
}
