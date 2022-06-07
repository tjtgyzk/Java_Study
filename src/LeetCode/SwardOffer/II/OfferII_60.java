package LeetCode.SwardOffer.II;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class OfferII_60 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            que.add(entry);
        }
        while (que.size() > k) {
            que.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = que.poll().getKey();
        }
        return ans;
    }
}
