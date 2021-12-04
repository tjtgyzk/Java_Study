package yu.DynamicProgramming;

public class Robot {
    //N 有N个位置
    //start 开始位置
    //K 你一共能走K步
    //aim 目标位置
    //1,只能往右走
    //N,只能往左走
    //返回最终能到aim位置的方法有多少种
    public static int process(int cur, int rest, int N, int aim) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(2, rest - 1, N, aim);
        }
        if (cur == N) {
            return process(N - 1, rest - 1, N, aim);
        }
        return process(cur - 1, rest - 1, N, aim) + process(cur + 1, rest - 1, N, aim);
    }

    public static int function1(int N, int start, int K, int aim) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        return process(start, K, N, aim);
    }

    public static void main(String[] args) {
        System.out.println(function1(5, 4, 6, 2));
        System.out.println(function2(5, 4, 6, 2));
        System.out.println(function3(5, 4, 6, 2));
    }

    public static int function2(int N, int start, int K, int aim) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        //cur:1-N
        //rest:0-K
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        process1(start, K, N, aim, dp);
        return dp[start][K];
    }

    public static int process1(int cur, int rest, int N, int aim, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process1(2, rest - 1, N, aim, dp);
        } else if (cur == N) {
            ans = process1(N - 1, rest - 1, N, aim, dp);
        } else {
            ans = process1(cur - 1, rest - 1, N, aim, dp) + process1(cur + 1, rest - 1, N, aim, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }

    public static int function3(int N, int start, int K, int aim) {
        if (N < 1 || start < 1 || start > N || aim < 1 || aim > N || K < 0) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        //如果rest==0，只有aim位置是1，其他都是0；
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            //cur == 1
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }
}
