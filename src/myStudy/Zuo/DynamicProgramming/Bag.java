package myStudy.Zuo.DynamicProgramming;

public class Bag {
    //选第index个要或者不要
    //rest为剩余背包承重
    public static int process(int[] w, int[] v, int index, int rest) {
        if (index == w.length) {
            return 0;
        }
        if (rest - w[index] < 0) {
            return 0;
        }
        int p1 = process(w, v, index + 1, rest);
        int p2 = v[index] + process(w, v, index + 1, rest - w[index]);
        return Math.max(p1, p2);
    }

    public static int function1(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        return process(w, v, 0, bag);
    }

    public static int function2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        //index：0-N
        //rest：负数-bag
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int next = rest - w[index] < 0 ? -1 : rest - w[index];
                int p2 = 0;
                if (next != -1) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(function1(weights, values, 15));
        System.out.println(function2(weights, values, 15));
    }
}
