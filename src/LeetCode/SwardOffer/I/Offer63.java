package LeetCode.SwardOffer.I;

public class Offer63 {
    public int maxProfit(int[] prices) {
        //dp[i]表示第i天能获得的最高利润
        //dp[i] = max(dp[i-1],prices[i]-历史最低值)
        //dp[0] = 0;
        if (prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
