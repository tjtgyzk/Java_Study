package LeetCode.SwardOffer.I;

import java.util.Deque;
import java.util.LinkedList;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //使用一个辅助栈模拟此过程,从弹出栈的第一个数字开始,当弹出栈当前指针指向的数字与辅助栈栈顶元素相同时,弹出,否则一直压入
        //如果最后栈为空,则证明合法
        if (pushed.length == 0) {
            return true;
        }
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new Offer31().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
