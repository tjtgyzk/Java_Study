package LeetCode;

import java.util.Random;

public class L324 {
    public void wiggleSort(int[] nums) {
        findMid(nums, 0, nums.length - 1);
        int[] clone = nums.clone();
        int index = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = clone[index--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = clone[index--];
        }
    }

    //找到数组的中位数并使得中位数左侧的数都比它小，右侧的数都比它大
    public void findMid(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        Random ran = new Random();
        int ranIndex = ran.nextInt(r - l) + l;
        int x = nums[ranIndex];
        int less = l;
        int more = r;
        int index = l;
        while (index <= more) {
            if (nums[index] < x) {
                swap(nums, less++, index++);
            } else if (nums[index] > x) {
                swap(nums, more--, index);
            } else {
                index++;
            }
        }
        if (less == nums.length / 2) {
            return;
        }
        if (less < nums.length / 2) {
            findMid(nums, less + 1, r);
        } else {
            findMid(nums, l, less - 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        new L324().findMid(new int[]{1, 5, 1, 1, 6, 4}, 0, 5);
    }
}
