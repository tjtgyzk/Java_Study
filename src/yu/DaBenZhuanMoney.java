package yu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DaBenZhuanMoney {
    public static class Ben {
        public int cost;
        public int profit;

        public Ben(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MinCostComparator implements Comparator<Ben> {
        @Override
        public int compare(Ben o1, Ben o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MaxProfitComparator implements Comparator<Ben> {
        @Override
        public int compare(Ben o1, Ben o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int getMaxProfit(int[] costs, int[] profit, int k, int m) {
        PriorityQueue<Ben> diXiao = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Ben> qian = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < costs.length; i++) {
            diXiao.add(new Ben(costs[i], profit[i]));
        }
        for (int i = 1; i <= k; i++) {
            while (diXiao.peek().cost <= m && !diXiao.isEmpty()) {
                qian.add(diXiao.poll());
            }
            if (qian.isEmpty()) {
                return m;
            }
            m += qian.peek().profit;
        }
        return m;
    }
}
