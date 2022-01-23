package myStudy.Zuo.DynamicProgramming;

public class BobDie {
    //走出区域立刻死亡的目的是为了不让他有机会走回来
    //假设可走空间无限大
    public static double function1(int N, int M, int row, int col, int k) {
        return process(N, M, row, col, k) / Math.pow(4, k);
    }

    //process的定义是给定当前位置x,y和剩余步数rest，返回从当前位置到最后一共有多少种存活情况
    public static long process(int N, int M, int x, int y, int rest) {
        if (x < 0 || y < 0 || x == N || y == M) {
            //出棋盘了，给爷死！！！！！
            return 0;
        }
        if (rest == 0) {
            //还在棋盘里,算一种活的情况
            return 1;
        }
        long up = process(N, M, x - 1, y, rest - 1);
        long down = process(N, M, x + 1, y, rest - 1);
        long left = process(N, M, x, y - 1, rest - 1);
        long right = process(N, M, x, y + 1, rest - 1);
        return up + down + left + right;
    }

    public static double function2(int N, int M, int row, int col, int k) {
        //x:0-->N-1
        //y:0-->M-1
        //rest:0-k
        long[][][] dp = new long[N][M][k + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    dp[x][y][rest] += pick(dp, N, M, x - 1, y, rest - 1);
                    dp[x][y][rest] += pick(dp, N, M, x + 1, y, rest - 1);
                    dp[x][y][rest] += pick(dp, N, M, x, y - 1, rest - 1);
                    dp[x][y][rest] += pick(dp, N, M, x, y + 1, rest - 1);

                }
            }
        }
        return dp[row][col][k] / Math.pow(4, k);
    }

    public static long pick(long[][][] dp, int N, int M, int x, int y, int rest) {
        if (x < 0 || y < 0 || x == N || y == M) {
            //出棋盘了，给爷死！！！！！
            return 0;
        }
        return dp[x][y][rest];
    }

    public static void main(String[] args) {
        System.out.println(function1(50, 50, 6, 6, 10));
        System.out.println(function2(50, 50, 6, 6, 10));
    }
}
