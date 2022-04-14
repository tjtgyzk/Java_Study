package com;

import java.util.Scanner;

public class PrintU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        //取子序列，使得子序列是9的倍数，可以包含前导0
        //返回有多少种取法
        char[] chars = n.toCharArray();
        long ans = function(chars);
        System.out.println(ans);
    }

    public static long function(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        //减掉都不选的情况
        long ans = process(chars, 0, 0) - 1;
        return ans % ((int) Math.pow(10, 9) + 7);
    }

    //传入 char数组，当前选择的位置，当前选择的子序列对应的数，
    public static int process(char[] chars, int index, int nowInt) {
        if (index == chars.length) {
            return (nowInt % 9 == 0) ? 1 : 0;
        }
        //对于每一个数，可以选择要或者不要
        int yes = process(chars, index + 1, nowInt * 10 + (chars[index] - '0'));
        int no = process(chars, index + 1, nowInt);
        return yes + no;

    }
}
