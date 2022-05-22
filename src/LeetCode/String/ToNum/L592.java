package LeetCode.String.ToNum;

import java.util.ArrayList;
import java.util.List;

public class L592 {
    //最大公因数
    public int gcd(int x, int y) {
        while (y != 0) {
            //辗转相除法,当余数为0时,最大公因数为这一步的除数
            int temp = y;
            //下一步的除数是这一步的余数
            y = x % y;
            //下一步的被除数是这一步的除数
            x = temp;
        }
        return x;
    }

    //最小公倍数
    public int lcm(int x, int y) {
        //两个数相乘除以两个数的最大公因数
        return x * y / gcd(x, y);
    }

    public String fractionAddition(String expression) {
        //找到加减符号
        List<Character> calculate = new ArrayList<Character>();
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                calculate.add(expression.charAt(i));
            }
        }
        //检查第一个数是不是负数
        boolean firstChar = (expression.charAt(0) == '-');
        //拿到所有数的分子和分母
        List<Integer> numerator = new ArrayList<Integer>();
        List<Integer> denominator = new ArrayList<Integer>();
        for (String s : expression.split("\\+")) {
            for (String subS : s.split("-")) {
                if (subS == "") {
                    continue;
                }
                String[] split = subS.split("/");
                numerator.add(Integer.parseInt(split[0]));
                denominator.add(Integer.parseInt(split[1]));
            }
        }
        if (firstChar) {
            numerator.set(0, -numerator.get(0));
        }
        //根据加减设置对应位置分子的正负
        for (int i = 0; i < calculate.size(); i++) {
            if (calculate.get(i) == '-') {
                numerator.set(i + 1, -numerator.get(i + 1));
            }
        }
        //求所有分母的最小公倍数
        int bothDenominator = denominator.get(0);
        for (int i = 1; i < denominator.size(); i++) {
            bothDenominator = lcm(bothDenominator, denominator.get(i));
        }
        //计算分子的结果
        int sum = 0;
        for (int i = 0; i < numerator.size(); i++) {
            int cur = numerator.get(i) * (bothDenominator / denominator.get(i));
            sum += cur;
        }
        //约分
        int both = Math.abs(gcd(sum, bothDenominator));
        sum /= both;
        bothDenominator /= both;
        //输出结果
        return sum + "/" + bothDenominator;
    }

    public static void main(String[] args) {
        System.out.println(new L592().fractionAddition("1/3-1/2"));
    }
}
