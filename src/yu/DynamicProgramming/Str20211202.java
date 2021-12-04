package yu.DynamicProgramming;

public class Str20211202 {
    public static int function1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length - 1);
    }

    public static int process(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        }
        if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }
        //不要左边
        int p1 = process(str, L + 1, R);
        //不要右边
        int p2 = process(str, L, R - 1);
        //都不要----两个位置相等
        int p3 = str[L] == str[R] ? (2 + process(str, L + 1, R - 1)) : 0;
        return Math.max(p1, Math.max(p2, p3));
    }

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        dp[N - 1][N - 1] = 1;
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                int p1 = dp[L + 1][R];
                int p2 = dp[L][R - 1];
                int p3 = str[L] == str[R] ? 2 + dp[L + 1][R - 1] : 0;
                dp[L][R] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(longestPalindromeSubseq(s));
    }
}
