package LeetCode.String.ToNum;

public class L640 {
    public String solveEquation(String equation) {
        //体力题, 找到x前系数和常数,做计算即可,注意等号两边移动需要翻转正负
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        int xNum = 0;
        int num = 0;
        //处理左侧数
        for (String sub : left.split("\\+|-")) {
            if (sub.length() == 0) {
                continue;
            }
            //找到对应该表达式的符号
            //由于可能出现重复,而indexOf返回的是第一次出现的值,故可以在拆分时带上加减号,也可以将重复值替换掉
            int index = left.indexOf(sub);
            left = left.replaceFirst(sub, "null");
            int calculate = -1;
            if (index == 0 || left.charAt(index - 1) == '+') {
                calculate = 1;
            }
            if (sub.charAt(sub.length() - 1) == 'x') {
                //包含x的项
                //考虑到系数为1时不会显示
                if (sub.length() == 1) {
                    xNum += calculate;
                } else {
                    xNum += calculate * Integer.parseInt(sub.substring(0, sub.length() - 1));
                }
            } else {
                //数字项
                num -= calculate * Integer.parseInt(sub);
            }
        }
        //处理右侧数
        for (String sub : right.split("\\+|-")) {
            if (sub.length() == 0) {
                continue;
            }
            //找到对应该表达式的符号
            int index = right.indexOf(sub);
            right = right.replaceFirst(sub, "null");
            int calculate = -1;
            if (index == 0 || right.charAt(index - 1) == '+') {
                calculate = 1;
            }
            if (sub.charAt(sub.length() - 1) == 'x') {
                //包含x的项
                //考虑到系数为1时不会显示
                if (sub.length() == 1) {
                    xNum -= calculate;
                } else {
                    xNum -= calculate * Integer.parseInt(sub.substring(0, sub.length() - 1));
                }
            } else {
                //数字项
                num += calculate * Integer.parseInt(sub);
            }
        }
        if (xNum == 0) {
            if (num != 0) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        }
        return "x=" + num / xNum;
    }

    public static void main(String[] args) {
        System.out.println(new L640().solveEquation("2+2-x+x+3x=x+2x-x+x+4"));
    }
}
