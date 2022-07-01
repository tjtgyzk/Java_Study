package LeetCode;

import java.util.Random;

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        //倒数第k个下标的下标应为nums.length-k;
        int target = nums.length - k;
        return partition(nums, 0, nums.length - 1, target);
    }

    public int partition(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        Random random = new Random();
        int x = nums[l + random.nextInt(r - l)];
        int less = l;//小于区的下一个位置
        int more = r;//大于区的下一个位置
        int index = l;
        while (index <= more) {
            if (nums[index] < x) {
                swap(nums, index++, less++);
            } else if (nums[index] > x) {
                swap(nums, index, more--);
            } else {
                index++;
            }
        }
        if (less == k) {
            return nums[k];
        }
        if (less < k) {
            return partition(nums, less + 1, r, k);
        }
        if (less > k) {
            return partition(nums, l, less - 1, k);
        }
        return -1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        new L215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

}
