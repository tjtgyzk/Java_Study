package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class le826 {
    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
    }

    public static class program {
        public int difficulty;
        public int profit;

        public program(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }

    public static class MinDifficultyComparator implements Comparator<program> {

        @Override
        public int compare(program o1, program o2) {
            return o1.difficulty - o2.difficulty;
        }
    }

    public static class MaxProfitComparator implements Comparator<program> {
        @Override
        public int compare(program o1, program o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<program> minDifficuty = new PriorityQueue<>(new MinDifficultyComparator());
        PriorityQueue<program> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        int ans = 0;
        Arrays.sort(worker);
        for (int i = 0; i < difficulty.length; i++) {
            minDifficuty.add(new program(difficulty[i], profit[i]));
        }
        for (int man : worker) {
            while (!minDifficuty.isEmpty() && (minDifficuty.peek().difficulty <= man)) {
                maxProfit.add(minDifficuty.poll());
            }
            if (maxProfit.isEmpty()) {
                continue;
            }
            ans += maxProfit.peek().profit;
        }
        return ans;
    }
}
