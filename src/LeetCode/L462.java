package LeetCode;

import java.util.Random;

public class L462 {
    Random ran = new Random();

    public int minMoves2(int[] nums) {
        //中位数是最优解
        //通过partition找到中位数
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int ans = 0;
        int x = partition(nums, 0, n - 1, n / 2);
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - x);
        }
        return ans;
    }

    public int findMidNum(int[] nums, int targetIndex) {
        return 0;
    }

    //minArea等于区的第一个下标
    //返回targetIndex位置的值
    public int partition(int[] nums, int l, int r, int targetIndex) {
        if (l == r) {
            return nums[l];
        }
        int index = ran.nextInt(r - l + 1) + l;
        int x = nums[index];
        //小于区右边界的下一个位置
        int minArea = l;
        //大于区左边界的下一个位置
        int maxArea = r;
        int i = l;
        while (i <= maxArea) {
            if (nums[i] < x) {
                swap(nums, i++, minArea++);
            } else if (nums[i] > x) {
                swap(nums, i, maxArea--);
            } else {
                i++;
            }
        }
        if (minArea == targetIndex) {
            return nums[minArea];
        }
        return minArea < targetIndex ? partition(nums, minArea + 1, r, targetIndex) : partition(nums, l, minArea, targetIndex);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new L462().minMoves2(new int[]{1, 10, 2, 9}));
    }
}
