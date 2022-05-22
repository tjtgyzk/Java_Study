package LeetCode.SwardOffer.I;

import java.util.HashSet;
import java.util.Set;

public class Offer61 {
    public boolean isStraight(int[] nums) {
        //key idea:数组中的 max - min < 5 , 且无重复的牌
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return max - min < 5;
    }
}
