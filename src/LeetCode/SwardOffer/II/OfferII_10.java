package LeetCode.SwardOffer.II;

import java.util.HashMap;

public class OfferII_10 {
    public int subarraySum(int[] nums, int k) {
        //前缀和
        //sums[j]-sums[i] = k
        //对于每个sums[j],找Hash表里是否存在sums[i]满足sums[i]==sums[j]-k,或者本身sums[j]==k
        //Hash表k存sums[i]的值,value存出现该值的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == k) {
                ans++;
            }
            ans += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }
}
