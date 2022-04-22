package LeetCode.Arrays.MoveChange;

public class L283 {
    public void moveZeroes(int[] nums) {
        //记录每一个非零数字应该在的位置
        //把遇到的非零数字放到对应的位置上去
        int nextPlace = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nextPlace];
                nums[nextPlace++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
