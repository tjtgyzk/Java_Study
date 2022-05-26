package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_41 {
    class MovingAverage {
        Deque<Integer> que;
        int maxSize;
        int sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            que = new LinkedList<>();
            maxSize = size;
            sum = 0;
        }

        public double next(int val) {
            if (que.size() < maxSize) {
                sum += val;
                que.add(val);
            } else {
                sum -= que.pollFirst();
                sum += val;
                que.add(val);
            }
            return (double) sum / que.size();
        }
    }

}
