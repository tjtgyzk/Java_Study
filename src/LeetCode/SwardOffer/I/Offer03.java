package LeetCode.SwardOffer.I;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        //原地hash
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[nums[i] % n] >= n) {
                return nums[i] % n;
            }
            nums[nums[i] % n] += n;
        }
        return -1;
    }
}
