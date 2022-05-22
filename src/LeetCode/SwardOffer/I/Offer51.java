package LeetCode.SwardOffer.I;

public class Offer51 {
    int ans = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //归并排序思路,如果归并过程中,先复制了右侧数组,则说明左侧剩下的数都比它大
        mergeSorted(nums, 0, nums.length - 1);
        return ans;
    }

    public void mergeSorted(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSorted(nums, l, mid);
        mergeSorted(nums, mid + 1, r);
        merge(nums, l, r);
    }

    public void merge(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        int li = l;
        int ri = mid + 1;
        int index = 0;
        int[] help = new int[r - l + 1];
        while (li <= mid && ri <= r) {
            if (nums[li] <= nums[ri]) {
                help[index++] = nums[li++];
            } else {
                help[index++] = nums[ri++];
                ans += mid - li + 1;
            }
        }
        while (li <= mid) {
            help[index++] = nums[li++];
        }
        while (ri <= r) {
            help[index++] = nums[ri++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        new Offer51().reversePairs(new int[]{});
    }
}
