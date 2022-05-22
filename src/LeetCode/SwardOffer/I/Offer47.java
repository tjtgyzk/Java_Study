package LeetCode.SwardOffer.I;

public class Offer47 {
    public int maxValue(int[][] grid) {
        //dp[i][j]表示从i,j开始走,走到最右下角能拿到的最大礼物
        //dp[i][j] = grid[i][j] + max(dp[i+1][j],dp[i][j+1])
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        //最后一列
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
        }
        //最后一行
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = grid[m - 1][i] + dp[m - 1][i + 1];
        }
        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = grid[row][col] + Math.max(dp[row + 1][col], dp[row][col + 1]);
            }
        }
        return dp[0][0];
    }
}
