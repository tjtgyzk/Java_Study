package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_38 {
    public int[] dailyTemperatures(int[] temperatures) {
        //找右侧第一个比它大的数
        //模拟
//        int[] ans = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            int r = i + 1;
//            while (r < temperatures.length && temperatures[r] <= temperatures[i]) {
//                r++;
//            }
//            if (r == temperatures.length) {
//                ans[i] = 0;
//            } else {
//                ans[i] = r - i;
//            }
//        }
//        return ans;
        //单调栈(从大到小)
        //弹出的时候设置结果
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer curIndex = stack.pop();
                ans[curIndex] = i - curIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
