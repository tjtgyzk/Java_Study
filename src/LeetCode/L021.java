package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class L021 {
    public String removeOuterParentheses(String s) {
        //遇到左括号，进栈，右括号则弹出栈中的左括号
        //如果入栈后栈大小为1，说明是最外层左括号，不加入结果，如果出栈后栈空，则说明是最外层右阔号，不加入结果
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                if (stack.size() != 1) {
                    sb.append("(");
                }
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(")");
                }
            }
        }
        return sb.toString();
    }
}
