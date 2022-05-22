package LeetCode.SwardOffer.I;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //此题重点在于想到:计算以第i个位置结尾的所有子数组中的最大值
        //记为dp[i],对于dp[i],其取值可能性为max(nums[i],dp[i-1]+nums[i])
        //dp[0]=nums[0],求dp数组中的最大值
        //由于每次都只依赖dp[i-1],可以优化空间复杂度为O(1)
        int lastDp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastDp = Math.max(nums[i], lastDp + nums[i]);
            ans = Math.max(ans, lastDp);
        }
        return ans;
    }
}
