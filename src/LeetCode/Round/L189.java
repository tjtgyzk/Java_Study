package LeetCode.Round;

import java.util.Arrays;
import java.util.Collections;

public class L189 {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            //注意这里!!如果长度为2,右移三次,相当于右移一次,因为右移长度等于没变,有些坑数据会k>长度QwQ
            k %= nums.length;
        }
        //整个数组翻转
        //前k个翻转
        //后n-k个翻转
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (j > i) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
