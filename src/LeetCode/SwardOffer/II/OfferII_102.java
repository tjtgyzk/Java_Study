package LeetCode.SwardOffer.II;

public class OfferII_102 {
    public int findTargetSumWays(int[] nums, int target) {
        // 正负无所谓,因为可以选择加减
        target = Math.abs(target);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
            sum += nums[i];
        }
        if (target > sum) {
            return 0;
        }
        if (target % 2 != sum % 2) {
            return 0;
        }
        target = (target + sum) / 2;
        int[][] dp = new int[nums.length + 1][target + 1];

//        for (int i = 0; i <= nums.length; i++) {
//            dp[i][0] = 1;
//        }
        dp[nums.length][0] = 1;
        for (int index = nums.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= target; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                //可以选择要或者不要
                if (rest - nums[index] >= 0) {
                    dp[index][rest] += dp[index + 1][rest - nums[index]];
                }

            }
        }
        return dp[0][target];
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_102().findTargetSumWays(new int[]{0, 0}, 0));
    }
}
