package LeetCode.SwardOffer.II;

public class OfferII_12 {
    public int pivotIndex(int[] nums) {
        //前缀和
        //记i位置之前的所有数之和为sum(i==0则sum==0),数组总和为total
        //则其右侧元素之和为total-sum-nums[i]
        //令左右元素相等即为sum = total - sum - nums[i]即 2sum+nums[i]=total
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
