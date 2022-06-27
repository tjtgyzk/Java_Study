package LeetCode.SwardOffer.II;

public class OfferII_103 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < amount; i++) {
            dp[n][i] = Integer.MAX_VALUE;
        }
        for (int index = n - 1; index >= 0; index--) {
            for (int cur = amount - 1; cur >= 0; cur--) {
                dp[index][cur] = Integer.MAX_VALUE;
                for (int nums = 0; nums * coins[index] <= amount - cur; nums++) {
                    int next = dp[index + 1][cur + nums * coins[index]];
                    if (next != Integer.MAX_VALUE) {
                        dp[index][cur] = Math.min(dp[index][cur], next + nums);
                    }
                }
            }
        }
        return dp[0][0] == Integer.MAX_VALUE ? -1 : dp[0][0];

    }

    public int process(int[] coins, int cur, int amount, int index) {
        if (index == coins.length) {
            return cur == amount ? 0 : Integer.MAX_VALUE;
        }
        if (cur == amount) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; cur + zhang * coins[index] <= amount; zhang++) {
            int next = process(coins, cur + zhang * coins[index], amount, index + 1);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + zhang);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_103().coinChange(new int[]{1, 2, 5}, 11));
    }
}
