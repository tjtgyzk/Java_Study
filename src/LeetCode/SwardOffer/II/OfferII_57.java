package LeetCode.SwardOffer.II;

import java.util.HashMap;
import java.util.Map;

public class OfferII_57 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //每个桶的大小为t+1,    -1号桶[-(t+1),-1]  0号桶[0, t]  1号桶[t+1,2t+1]
        //map存(桶号,桶中数字)
        //如果要加入的桶中已经有数字,则说明有两个数字处于同一个桶,直接返回true
        //否则要判断相邻桶中的数字与当前数字之差,是否小于等于t
        //滑动窗口大小为k,[i-k+1,i]
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long id = getId((long) nums[i], (long) t);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && nums[i] - map.get(id - 1) <= t) {
                return true;
            }
            if (map.containsKey(id + 1) && map.get(id + 1) - nums[i] <= t) {
                return true;
            }
            map.put((long) id, (long) nums[i]);
            //剔除过期数据
            if (i >= k) {
                map.remove(getId(nums[i - k], t));
            }
        }
        return false;
    }

    //获取桶编号
    public long getId(long num, long t) {
        if (num >= 0) {
            return num / (t + 1);
        }
        return (num + 1) / (t + 1) - 1;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_57().containsNearbyAlmostDuplicate(new int[]{2, 0, -2, 2}, 2, 1));
    }
}
