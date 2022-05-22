package LeetCode.SwardOffer.I;

public class Offer53 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;
        while (nums[mid] != target) {
            if (l >= r && nums[l] != target) {
                return 0;
            }
            if (nums[mid] > target) {
                r = mid - 1;
                mid = l + (r - l) / 2;
            }
            if (nums[mid] < target) {
                l = mid + 1;
                mid = l + (r - l) / 2;
            }
        }
        l = r = mid;
        while (l >= 0 && nums[l] == target) {
            l--;
        }
        while (r < nums.length && nums[r] == target) {
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        new Offer53().search(new int[]{2, 2}, 1);
    }
}
