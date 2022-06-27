package LeetCode.SwardOffer.II;

public class OfferII_89 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        dp[nums.length] = 0;
        dp[nums.length + 1] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
