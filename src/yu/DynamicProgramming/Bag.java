package yu.DynamicProgramming;

public class Bag {
    //index选到第几号货物了
    //rest剩余的背包承重
    public static int function1(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        return process(w, v, 0, bag);
    }

    //index之后的货选或者不选，返回value最大值
    public static int process(int[] w, int[] v, int index, int rest) {
        if (index == w.length) {
            return 0;
        }
        if (rest - w[index] < 0) {
            return 0;
        }
        //不要index
        int p1 = process(w, v, index + 1, rest);
        //要index
        int p2 = v[index] + process(w, v, index + 1, rest - w[index]);
        return Math.max(p1, p2);
    }

    public static int function2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        //index：0-N
        //rest：负数-bag
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                boolean next = rest - w[index] < 0 ? false : true;
//              int p2 = v[index] + dp[index + 1][rest - w[index]];
                if (next) {
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
