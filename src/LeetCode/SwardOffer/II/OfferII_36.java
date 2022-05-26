package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_36 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_36().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
