package LeetCode;

import java.util.Arrays;

public class L473 {
    public boolean makesquare(int[] matchsticks) {
        //数据处理
        int sum = 0;
        for (int i : matchsticks) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = sum / 4;
        //球视角
        //数据降序以更好命中剪枝条件
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int[] bucket = new int[4];
        return process(matchsticks, 0, bucket, target);
    }

    public boolean process(int[] nums, int index, int[] bucket, int target) {
        //basecase,如果放到最后一个球,必为成功解
        if (index == nums.length) {
            return true;
        }
        //开始选择放入哪个桶
        for (int i = 0; i < 4; i++) {
            //如果放入后超过target,直接尝试下一个桶
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 如果当前桶和上一个桶内的元素和相等，则跳过
            // 原因：如果元素和相等，那么 nums[index] 选择上一个桶和选择当前桶可以得到的结果是一致的
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }

            //放入桶,进行后续尝试
            bucket[i] += nums[index];
            if (process(nums, index + 1, bucket, target)) {
                return true;
            }
            //恢复现场
            bucket[i] -= nums[index];
        }

        //走到这里说明不符合要求
        return false;
    }
}
