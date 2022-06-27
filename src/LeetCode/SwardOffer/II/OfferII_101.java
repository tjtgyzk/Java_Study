package LeetCode.SwardOffer.II;

public class OfferII_101 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int aim = sum / 2;
        //从 index 开始选, 要凑的数是 aim, dp[index][aim]表示从index开始选,凑到的离aim最近的数
        int[][] dp = new int[nums.length + 1][aim + 1];
        for (int index = nums.length - 1; index >= 0; index--) {
            for (int curAim = 1; curAim <= aim; curAim++) {
                if (curAim - nums[index] < 0) {
                    dp[index][curAim] = dp[index + 1][curAim];
                } else {
                    dp[index][curAim] = Math.max(dp[index + 1][curAim], nums[index] + dp[index + 1][curAim - nums[index]]);
                }
            }
        }
        return dp[0][aim] == aim;
    }
}
