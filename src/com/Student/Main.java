package com.Student;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    //字符串只有0或者1，最少交换几次，使得相邻字符串不相等（0，1交错）
    //假设第一个是1，则1应该放在0，2，4，...位置上
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        //预处理，出现多的次数必须做头
        int oneTimes = 0;
        int zeroTimes = 0;
        char head = ' ';
        //下一个应该在的位置
        int nextPlace = 0;
        for (char c : chars) {
            if (c == '0') {
                zeroTimes++;
            } else {
                oneTimes++;
            }
        }
        if (zeroTimes == oneTimes) {
            head = chars[0];
        } else {
            head = zeroTimes > oneTimes ? '0' : '1';
        }
        //交换次数
        int ans = 0;

        for (int i = 0; i < chars.length; i++) {
            if (nextPlace >= chars.length) {
                break;
            }
            if (chars[i] == head) {
                ans += Math.abs(i - nextPlace);
                nextPlace += 2;
            }
        }
        PriorityQueue<Integer> arr = new PriorityQueue<>();
        System.out.println(ans);
    }
}

