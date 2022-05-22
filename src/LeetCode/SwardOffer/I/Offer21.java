package LeetCode.SwardOffer.I;

public class Offer21 {
    public int[] exchange(int[] nums) {
        int aimPlace = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                int temp = nums[i];
                nums[i] = nums[aimPlace];
                nums[aimPlace++] = temp;
            }
        }
        return nums;
    }
}
