package LeetCode.Arrays.AreaSum;

public class L303 {
    //此题简单:构造前缀和数组sum,nums[i]到nums[j]上的数之和即为sum[j]-sum[i-1]
    class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sum[right];
            }
            return sum[right] - sum[left - 1];
        }
    }

}
