package myStudy.Zuo.DynamicProgramming;

public class SplitNumber {
    public static int function1(int num) {
        if (num <= 0) {
            return 0;
        }
        return process(1, num);
    }

    //给定上一个拆出来的数（用于标记之后的数必须比它大）
    //给定剩余要拆的数
    //返回有多少种可能性
    public static int process(int last, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (last > rest) {
            return 0;
        }
        int ans = 0;
        for (int cur = last; cur <= rest; cur++) {
            ans += process(cur, rest - cur);
        }
        return ans;
    }

    public static int function2(int num) {
        if (num <= 0) {
            return 0;
        }
        //last:0-num
        //rest:0-num
        int[][] dp = new int[num + 1][num + 1];
        //第一列（rest==0）都为1
        //所有下三角区域都为0
        //对角线为1
        for (int i = 0; i <= num; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int last = num - 1; last > 0; last--) {
            for (int rest = last + 1; rest <= num; rest++) {
                dp[last][rest] = 0;
                for (int cur = last; cur <= rest; cur++) {
                    dp[last][rest] += dp[cur][rest - cur];
                }
            }
        }

        return dp[1][num];

    }

    public static int function3(int num) {
        if (num <= 0) {
            return 0;
        }
        //last:0-num
        //rest:0-num
        int[][] dp = new int[num + 1][num + 1];
        //第一列（rest==0）都为1
        //所有下三角区域都为0
        //对角线为1
        for (int i = 0; i <= num; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int last = num - 1; last > 0; last--) {
            for (int rest = last + 1; rest <= num; rest++) {
                dp[last][rest] = dp[last + 1][rest] + dp[last][rest - last];
            }
        }
        return dp[1][num];
    }

    public static void main(String[] args) {
        System.out.println(function1(15));
        System.out.println(function2(15));
        System.out.println(function3(15));
    }
}
