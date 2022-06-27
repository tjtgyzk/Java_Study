package LeetCode;

import java.util.Arrays;

public class L1051 {
    public int heightChecker(int[] heights) {
        int[] standard = Arrays.copyOf(heights, heights.length);
        Arrays.sort(standard);
        int ans = 0;
        for (int i = 0; i < standard.length; i++) {
            if (standard[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}
