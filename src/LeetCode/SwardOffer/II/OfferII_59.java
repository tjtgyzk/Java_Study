package LeetCode.SwardOffer.II;

import java.util.PriorityQueue;

public class OfferII_59 {
    class KthLargest {
        //使用优先级队列,只保留前k大的元素,堆顶为前k大的元素中最小的
        PriorityQueue<Integer> que;
        int num;

        public KthLargest(int k, int[] nums) {
            que = new PriorityQueue<>();
            num = k;
            for (int i : nums) {
                que.add(i);
            }
        }

        public int add(int val) {
            que.add(val);
            while (que.size() > num) {
                que.poll();
            }
            return que.peek();
        }
    }
}
