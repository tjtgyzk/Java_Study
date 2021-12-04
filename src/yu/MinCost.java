package yu;

import java.util.PriorityQueue;

public class MinCost {
    public static int getMinCost(int[] golds) {
        if (golds.length == 0 || golds == null) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int ans = 0;
        for (int gold : golds) {
            queue.add(gold);
        }
        while (queue.size() > 1) {
            int mid = queue.poll() + queue.poll();
            ans += mid;
            queue.add(mid);
        }
        return ans;
    }
}
