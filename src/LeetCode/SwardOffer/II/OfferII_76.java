package LeetCode.SwardOffer.II;

import java.util.Random;

public class OfferII_76 {
    public int findKthLargest(int[] nums, int k) {
        //快速选择算法,再练一次
        int tarIndex = nums.length - k;
        return quickSort(nums, tarIndex);
    }

    public int quickSort(int[] nums, int tarIndex) {
        int l = 0, r = nums.length - 1;
        while (true) {
            int[] curIndex = partition(nums, l, r);
            int curLeft = curIndex[0];
            int curRight = curIndex[1];
            if (tarIndex <= curRight && tarIndex >= curLeft) {
                return nums[tarIndex];
            } else if (tarIndex > curRight) {
                l = curRight + 1;
            } else {
                r = curLeft - 1;
            }
        }
    }

    //返回等于区左右边界
    public int[] partition(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{l, r};
        }
        int index = l;
        Random rand = new Random();
        int standard = nums[rand.nextInt(r - l) + l];
        int less = l - 1;
        int big = r + 1;
        while (index < big) {
            if (nums[index] < standard) {
                swap(nums, index++, ++less);
            } else if (nums[index] > standard) {
                swap(nums, index, --big);
            } else {
                index++;
            }
        }
        return new int[]{less + 1, big - 1};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_76().findKthLargest(new int[]{-1, -1}, 2));
    }
}
