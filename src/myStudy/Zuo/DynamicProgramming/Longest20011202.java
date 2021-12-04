package myStudy.Zuo.DynamicProgramming;

public class Longest20011202 {
    public static int function1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length - 1);
    }

    public static int process(char[] str, int L, int R) {
        if (L == R) {
            //只有一个数，是回文子序列
            return 1;
        }
        if (L == R - 1) {
            //有两个数，如果他们相等就有长度为2的回文子序列，如果不相等，则分别是长度为1的回文子序列
            return str[L] == str[R] ? 2 : 1;
        }
        //一般情况
        //不要左边，求得的最长回文子序列
        int p1 = process(str, L + 1, R);
        //不要右边
        int p2 = process(str, L, R - 1);
        //都不要，如果左边和右边相等，则它们是回文子序列的一部分，则结果要加2
        int p3 = str[L] == str[R] ? 2 + process(str, L + 1, R - 1) : process(str, L + 1, R - 1);
        return Math.max(p1, Math.max(p2, p3));
    }

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        //L:0--N-1
        //R:0--N-1
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        dp[N - 1][N - 1] = 1;
        //依赖下，左，左下
        //可以按对角线填
        for (int i = 2; i < N; i++) {
            int L = 0;
            int R = i;
            while (R < N) {
                //小优化，因为每个点都依赖左，下，左下，所以左和下不可能比左下小，所以不考虑左下
                dp[L][R] = Math.max(dp[L + 1][R], dp[L][R - 1]);
                if (str[L] == str[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
                L++;
                R++;
            }
        }
        return dp[0][N - 1];

    }

    public static void main(String[] args) {
        String s = "abc123hjk321uio";
        System.out.println(function1(s));
        System.out.println(longestPalindromeSubseq(s));
    }
}
