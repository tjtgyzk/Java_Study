package LeetCode;

public class l905 {
    public int[] sortArrayByParity(int[] nums) {
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[next];
                nums[next++] = temp;
            }
        }
        return nums;
    }
}
