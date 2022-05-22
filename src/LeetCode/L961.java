package LeetCode;

import java.util.Random;

public class L961 {
    public int repeatedNTimes(int[] nums) {
        //随机生成两个下标,如果相等,则返回
        Random random = new Random();
        while (true) {
            int index1 = random.nextInt(nums.length);
            int index2 = random.nextInt(nums.length);
            if (index1 != index2 && nums[index1] == nums[index2]) {
                return nums[index2];
            }
        }
    }
}
