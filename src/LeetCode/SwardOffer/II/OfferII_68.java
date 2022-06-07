package LeetCode.SwardOffer.II;

public class OfferII_68 {
    public int searchInsert(int[] nums, int target) {
        //二分查找,找到这个数或者第一个大于等于这个数的位置
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[l] > target ? l : l + 1;
    }

    public static void main(String[] args) {
        new OfferII_68().searchInsert(new int[]{1, 3, 5, 6}, 2);
    }

}
