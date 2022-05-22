package LeetCode.SwardOffer.II;

import java.util.HashMap;

public class OfferII_11 {
    public int findMaxLength(int[] nums) {
        //将所有的0变为-1,题目转化为求最长的和为0的子数组长度,使用前缀和
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        //key为sum[i],v为sum[i]出现的最小下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length];
        int ans = 0;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 0) {
                ans = Math.max(ans, i + 1);
            }
            if (map.containsKey(sum[i])) {
                ans = Math.max(ans, i - map.get(sum[i]));
            }
            map.put(sum[i], Math.min(i, map.getOrDefault(sum[i], sum.length)));
        }
        return ans;
    }
}
