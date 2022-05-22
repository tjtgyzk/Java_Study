package LeetCode.Arrays.StatisticalElement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> function(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        function(nums);
    }
}
