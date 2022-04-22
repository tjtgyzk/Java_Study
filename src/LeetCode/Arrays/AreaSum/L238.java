package LeetCode.Arrays.AreaSum;

public class L238 {
    public int[] productExceptSelf(int[] nums) {
        //除自己外所有数的乘积=自己左侧所有数之积*自己右侧所有数之积
        //从左到右遍历数组,每个位置都等于自己左侧数之积(类似于前缀积),0位置左侧数之积为1
        //在上一步的基础上,从右到左遍历原数组,每个位置再乘上自己右侧数之积(后缀积?),n-1位置右侧数之积为1
        //此时数组每个位置都是左侧数之积*右侧数之积,符合题目要求,返回即可
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = 1;
            } else {
                ans[i] = ans[i - 1] * nums[i - 1];
            }
        }
        int R = 1;
        for (int index = n - 1; index >= 0; index--) {
            ans[index] *= R;
            //下一步要用的右侧数之积
            R *= nums[index];
        }
        return ans;
    }
}
