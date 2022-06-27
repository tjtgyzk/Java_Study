package LeetCode.SwardOffer.II;

public class OfferII_98 {
    public int uniquePaths(int m, int n) {
        //dp(i,j)表示从i,j开始走到右下角的不同路径
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n - 1] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}
