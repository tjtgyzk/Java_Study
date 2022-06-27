package LeetCode.SwardOffer.II;

public class OfferII_90 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(subRob(nums, 0, nums.length - 2), subRob(nums, 1, nums.length - 1));
    }

    public int subRob(int[] nums, int l, int r) {
        int[] dp = new int[r - l + 3];
        dp[dp.length - 1] = 0;
        dp[dp.length - 2] = 0;
        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[l + i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_90().rob(new int[]{1, 2, 1, 1}));
    }
}
