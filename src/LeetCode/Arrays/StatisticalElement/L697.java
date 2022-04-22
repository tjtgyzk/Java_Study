package LeetCode.Arrays.StatisticalElement;

import java.util.HashMap;
import java.util.Map;

public class L697 {

    public static int findShortestSubArray(int[] nums) {
        //Map记录数字的值,以及数字出现的次数,第一次出现的位置,最后一次出现的位置
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{1, i, i});
            } else {
                Integer[] info = map.get(nums[i]);
                info[0] += 1;
                info[2] = i;
            }
        }
        int max = 0;
        int minLength = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            if (entry.getValue()[0] > max) {
                max = entry.getValue()[0];
                minLength = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (entry.getValue()[0] == max) {
                minLength = Math.min(minLength, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }
}
