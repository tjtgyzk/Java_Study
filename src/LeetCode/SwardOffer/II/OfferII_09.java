package LeetCode.SwardOffer.II;

public class OfferII_09 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //滑动窗口,计算以nums[r]为结尾的子数组个数
        int l = 0, r = 0;
        int sum = 1;
        int ans = 0;
        while (r < nums.length) {
            sum *= nums[r];
            while (l <= r && sum >= k) {
                sum /= nums[l++];
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
