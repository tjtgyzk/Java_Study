package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_37 {
    public int[] asteroidCollision(int[] asteroids) {
        //什么时候一定入栈?
        //1.栈顶元素为负数,当前元素如果同为负,则一起向左,如果为正,则分别向两边
        //2.当前元素为正数,栈顶元素如果为正,则一起向右,栈顶元素若为负数,则向两边
        //3.栈为空
        //所以需要比较时一定有:
        //栈顶元素为正数,当前元素为负数
        //若栈顶元素大于当前元素绝对值,则当前元素被撞毁,继续看下一个
        //若栈顶元素等于当前元素绝对值,则两个一起被撞毁,弹出栈顶元素,继续看下一个
        //若栈顶元素小于当前元素绝对值,则弹出栈顶元素,继续与下一个栈顶比较
        int p = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (p < asteroids.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[p] > 0) {
                stack.push(asteroids[p++]);
                continue;
            }
            int last = stack.peek();
            int cur = Math.abs(asteroids[p]);
            if (last > cur) {
                p++;
            } else if (last == cur) {
                stack.pop();
                p++;
            } else {
                stack.pop();
            }
        }
        int[] ans = new int[stack.size()];
        p = ans.length - 1;
        while (!stack.isEmpty()) {
            ans[p--] = stack.pop();
        }
        return ans;
    }
}
