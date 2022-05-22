package LeetCode.SwardOffer.I;

import java.util.LinkedList;

public class Offer59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || k > nums.length) {
            return new int[]{};
        }
        int r = 0;
        int[] ans = new int[nums.length - k + 1];
        int ansIndex = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (r < nums.length) {
            //此轮过期下标
            int last = r - k;
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[r]) {
                list.pollLast();
            }
            list.addLast(r);
            //剔除过期数据
            if (list.peekFirst() == last) {
                list.pollFirst();
            }
            //获取窗口内最大值
            if (r - k + 1 >= 0) {
                ans[ansIndex++] = nums[list.peekFirst()];
            }
            r++;
        }
        return ans;
    }
}
