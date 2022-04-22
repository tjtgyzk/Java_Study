package LeetCode.Arrays.StatisticalElement;

import java.util.LinkedList;
import java.util.List;

public class L442 {
    public List<Integer> findDuplicates(int[] nums) {
        //利用数组下标来标识数字出现了几次
        //假如nums[i] = k. 则把nums[k-1]位置变为负数.index = k-1
        //因为nums[i]在[1,n],故刚好可以表示数组的[0,N-1]位置
        //所以如果最后nums[i]为正数,则证明i+1出现了偶数次,反之为奇数次
        //为了防止nums[i]在被遍历到之前已经变为负数,故计算下标时使用Math.abs取绝对值
        //鉴于此题只出现一次或两次,则对应nums[index]如果已经为负数了,证明出现了第二次,直接把index+1加入结果列表
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(index + 1);
            } else {
                nums[index] *= -1;
            }
        }
        return ans;
    }
}
