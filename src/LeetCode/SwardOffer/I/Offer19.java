package LeetCode.SwardOffer.I;

public class Offer19 {
    public boolean isMatch(String s, String p) {
        //dp[i][j]表示s的前i个(0到i-1)和p的前j个(0到j-1)是否匹配
        //dp[0][0] = true,dp[i][0] = false,dp[0][j] = dp[0][j-2] && p(j-1)=='*',偶数个为*才成立
        //若p(j-1) = . 则一定可以匹配一个字符,dp[i][j] = dp[i-1][j-1]
        //若p(j-1)=s(i-1) 则该位置匹配,dp[i][j] = dp[i-1][j-1]
        //若p(j-1)是字母且p(j-1) != s(i-1) 则dp[i][j] = false;
        //若p(j-1) = *,则与p(j-2)看成一组,
        //若丢掉这一组作废,则dp[i][j] = dp[i][j-2]
        //若p(j-2)=s(i-1)或p(j-2)=='.',则可以匹配一个或多个,则dp[i][j] = dp[i-1][j]
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            dp[0][j] = (dp[0][j - 2]) && (p.charAt(j - 1) == '*');
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Offer19 offer19 = new Offer19();
        offer19.isMatch("ab", ".*");
    }
}
