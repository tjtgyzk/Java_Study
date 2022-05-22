package LeetCode.SwardOffer.I;

import java.util.HashSet;

public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] < target - nums[r]) {
                l++;
            } else if (nums[l] > target - nums[r]) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[]{};
    }

}
