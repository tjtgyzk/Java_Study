package myStudy.dataStructure.Stack;

import java.util.Stack;

public class ComputeMiddle {
    public static void main(String[] args) {
        int level = -1;
        Stack<Integer> num = new Stack<Integer>();
        Stack<Character> oper = new Stack<Character>();
        String s = "10+4/2-8";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {//如果是符号
                if (oper.empty()) {//符号栈为空，则直接入栈
                    oper.push(s.charAt(i));
                } else {//符号栈不为空
                    if (s.charAt(i) == '+' || s.charAt(i) == '-') {//如果是加减，进行计算（因为加减必然小于等于上一个符号）
                        int num1 = num.pop();
                        int num2 = num.pop();
                        int re = compute(num1, num2, oper.pop());
                        num.push(re);
                        oper.push(s.charAt(i));
                    } else {//如果是乘除
                        if (oper.peek() == '+' || oper.peek() == '-') {//如果上一个是加减，则入栈
                            oper.push(s.charAt(i));
                        } else {//上一个是乘除，进行计算
                            int num1 = num.pop();
                            int num2 = num.pop();
                            int re = compute(num1, num2, oper.peek());
                            num.push(re);
                            oper.push(s.charAt(i));
                        }
                    }
                }
            } else {//如果是数字
                String sn = "" + s.charAt(i);
                if (i == s.length() - 1) {//如果是最后一位数字
                    num.push(Integer.valueOf(sn));
                    break;
                }
                for (int t = i; t < s.length(); t++) {
                    if (s.charAt(t + 1) == '+' || s.charAt(t + 1) == '-' || s.charAt(t + 1) == '*' || s.charAt(t + 1) == '/') {
                        break;
                    } else {
                        sn = sn + s.charAt(t + 1);
                        i++;//下一位已经算做数字，所以不用参与大循环了
                    }
                }
                num.push(Integer.valueOf(sn));
            }
        }
        while (!oper.empty()) {
            int num1 = num.pop();
            int num2 = num.pop();
            int re = compute(num1, num2, oper.pop());
            num.push(re);
        }
        System.out.println(num.pop());
    }

    public static int compute(int num1, int num2, char c) {
        int re = 0;
        switch (c) {
            case '+':
                re = num2 + num1;
                break;
            case '-':
                re = num2 - num1;
                break;
            case '*':
                re = num2 * num1;
                break;
            case '/':
                re = num2 / num1;
                break;
        }
        return re;
    }

}

