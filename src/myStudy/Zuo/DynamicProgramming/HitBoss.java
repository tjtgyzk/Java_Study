package myStudy.Zuo.DynamicProgramming;

public class HitBoss {
    //Boss有N滴血
    //每次打掉[0-M]的血量
    //一共打K次
    //返回boss被砍死的概率
    public static double function1(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        return process(N, K, M) / Math.pow(M + 1, K);
    }

    //hp剩余血量
    //rest剩余次数
    //返回生存的可能性有几个
    public static long process(int hp, int rest, int M) {
        if (rest == 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            //如果血量提前掉到0以下，那么剩余的砍的次数全部算做生存的可能性之一
            return (long) Math.pow(M + 1, rest);
        }
        long ans = 0;
        for (int i = 0; i <= M; i++) {
            //每一次砍出的血量的可能性
            ans += process(hp - i, rest - 1, M);
        }
        return ans;
    }

    public static double function2(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        //rest：0-K
        //hp：0-N
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            for (int hp = 1; hp <= N; hp++) {
                long ans = 0;
                for (int i = 0; i <= M; i++) {
                    if (hp - i <= 0) {
                        ans += Math.pow(M + 1, rest - 1);
                    } else {
                        ans += dp[rest - 1][hp - i];
                    }
                }
                dp[rest][hp] = ans;
            }
        }
        return dp[K][N] / Math.pow(M + 1, K);
    }

    public static double function3(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        //rest：0-K
        //hp：0-N
        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[rest][0] = (long) Math.pow(M + 1, rest);
            for (int hp = 1; hp <= N; hp++) {
                dp[rest][hp] = dp[rest][hp - 1] + dp[rest - 1][hp];
                if (hp - 1 - M <= 0) {
                    dp[rest][hp] -= Math.pow(M + 1, rest - 1);
                } else {
                    dp[rest][hp] -= dp[rest - 1][hp - M - 1];
                }
            }
        }
        return dp[K][N] / Math.pow(M + 1, K);
    }

    public static void main(String[] args) {
        int NMax = 10;
        int MMax = 10;
        int KMax = 10;
        int testTime = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * NMax);
            int M = (int) (Math.random() * MMax);
            int K = (int) (Math.random() * KMax);
            double ans1 = function1(N, M, K);
            double ans2 = function2(N, M, K);
            double ans3 = function3(N, M, K);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
