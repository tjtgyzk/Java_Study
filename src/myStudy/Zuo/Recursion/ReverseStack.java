package myStudy.Zuo.Recursion;

import java.util.Stack;

public class ReverseStack {
    public static int getBottom(Stack<Integer> stack) {
        int thisPop = stack.pop();
        if (stack.isEmpty()) {
            return thisPop;
        }
        //这个last会一直丢到最高层，就是栈底部的元素
        int last = getBottom(stack);
        //如果不是最后一层，则该弹出元素需要等到最后一层被取出后压回去
        stack.push(thisPop);
        return last;
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        //拿到最下层元素
        int thisBottom = getBottom(stack);
        //剩余部分反转
        reverse(stack);
        //把最下层元素放在最上面
        stack.push(thisBottom);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
    }
}
