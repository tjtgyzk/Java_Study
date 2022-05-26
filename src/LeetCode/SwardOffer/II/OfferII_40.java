package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_40 {
    public int maximalRectangle(String[] matrix) {
        //从第一行开始不断更新高度数组
        //对于每一次更新后而言,都是39题的复刻
        if (matrix.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] heights = new int[matrix[0].length()];
        for (String s : matrix) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        //单调栈(从小到大)
        //找出左右第一个比它小的下标l,r,对应该位置高度的矩形最大底边为r-l-1,高度为heights[curIndex]
        //弹出时设置结果
        //相等时可以先弹出,只要最右侧的算对即可
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                Integer curIndex = stack.pop();
                int r = i;
                int l = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (r - l - 1) * heights[curIndex]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer curIndex = stack.pop();
            int r = heights.length;
            int l = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (r - l - 1) * heights[curIndex]);
        }
        return ans;
    }
}
