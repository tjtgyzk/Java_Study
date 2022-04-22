package LeetCode.Arrays.MoveChange;

public class L453 {
    public static int minMoves(int[] nums) {
        //测试思路:n-1个元素加一,即等于1个元素-1
        //返回每个元素减成最小元素的次数之和
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }
}
