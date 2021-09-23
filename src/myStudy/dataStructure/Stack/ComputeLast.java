package myStudy.dataStructure.Stack;

import java.util.List;
import java.util.Stack;

public class ComputeLast {
    public static void main(String[] args) {
        String s = "30 4 + 5 * 6 -";
        String[] s1 = s.split(" ");
        System.out.println(calculate(s1));
    }

    public static int calculate(String[] strings) {
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                Integer re = 0;
                switch (s) {
                    case "+":
                        re = num2 + num1;
                        break;
                    case "-":
                        re = num2 - num1;
                        break;
                    case "*":
                        re = num2 * num1;
                        break;
                    case "/":
                        re = num2 / num1;
                        break;
                }
                stack.push(re.toString());
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
