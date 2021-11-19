package myStudy.Zuo.TanXin;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostMaxProfit {
    public static class Program {
        public int p;
        public int c;

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public static int getMinCostMaxProfit(int[] costs, int[] profits, int k, int m) {
        PriorityQueue<Program> heapCosts = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> heapProfits = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < costs.length; i++) {
            heapCosts.add(new Program(profits[i], costs[i]));
        }
        for (int i = 1; i <= k; i++) {
            while (heapCosts.peek().c <= m && !heapCosts.isEmpty()) {
                heapProfits.add(heapCosts.poll());
            }
            if (heapProfits.isEmpty()) {
                return m;
            }
            m += heapProfits.poll().p;
        }
        return m;
    }
}
