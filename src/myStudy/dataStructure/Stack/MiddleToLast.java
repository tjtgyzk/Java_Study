package myStudy.dataStructure.Stack;

import java.util.*;

public class MiddleToLast {
    public static void main(String[] args) {
        Deque res = new LinkedList();//结果栈
        Deque oper = new LinkedList();//符号栈
        //String s = "((30-22)+(2*4))*2";//= 30 22 - 2 4 * + 2 *
        String s = "3+2*5";//3 2 5 * +
        ArrayList<String> a = toArrayList(s);
        for (String s1 : a) {//遍历a
            if (s1.matches("\\d+")) {//如果是数字，压入结果栈
                res.push(s1);
            } else {//如果是运算符，进行判断
                doOper(s1, oper, res);
            }
        }
        while (!oper.isEmpty()) {
            res.push(oper.pop());
        }
        Deque reverseRes = new LinkedList();
        while (!res.isEmpty()) {//逆序
            reverseRes.push(res.pop());
        }
        System.out.println(reverseRes);


    }

    public static ArrayList<String> toArrayList(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {//遍历字符串,指针在循环中递增，此处不递增，否则会跳过数字后的第一个字符
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {//如果不是数字，添加进List
                res.add("" + s.charAt(i));
                i++;
            } else {//如果是数字，要判断是否为多位数
                String temp = "";//用于拼接数字
                while (i < s.length()) {
                    if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                        temp = temp + s.charAt(i);
                        i++;
                    } else {
                        break;
                    }
                }
                res.add(temp);
            }
        }
        return res;
    }

    public static void kuoHao(String kuohao, Deque oper, Deque res) {
        if (kuohao.equals("(")) {
            oper.addFirst(kuohao);
        } else {
            while (!oper.peekFirst().equals("(")) {//直到遇到左括号为止，弹出符号栈的符号，压入结果栈
                res.push(oper.pop());
            }
            oper.pop();//弹出左括号，丢弃掉这一对括号
        }
    }

    public static void doOper(String operate, Deque oper, Deque res) {
        if (operate.equals("(") || operate.equals(")")) {//如果是括号
            kuoHao(operate, oper, res);
        } else {//如果是加减乘除，进行判断
            if (oper.isEmpty() || oper.peek().equals("(")) {//如果符号栈为空,压入符号栈
                oper.push(operate);
            } else {//如果符号栈不为空
                if ((operate.equals("*") || operate.equals("/") && (oper.peek().equals("+") || oper.peek().equals("-")))) {//如果该元素优先级大于符号栈顶元素
                    oper.push(operate);//压入符号栈
                } else {
                    res.push(oper.pop());//将符号栈的栈顶元素弹出，压入结果栈
                    doOper(operate, oper, res);//继续与下一个符号栈的栈顶元素比较
                }
            }
        }
    }

}
