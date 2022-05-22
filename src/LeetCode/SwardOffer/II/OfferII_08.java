package LeetCode.SwardOffer.II;

public class OfferII_08 {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        //学习一下滑动窗口的写法!!
        int l = 0, r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
