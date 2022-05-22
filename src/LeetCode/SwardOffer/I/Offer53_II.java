package LeetCode.SwardOffer.I;

public class Offer53_II {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int l = 0, r = n - 2;
        //取等是为了当l==r是目标数时,l能去缺失的数的位置
        //假如{0,1,2,3,4},则缺失的数为5,最后一步arr[l] = 4,证明数组中是满足递增1的,此时l = mid+1 = 5,缺失的数为5
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] != mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
