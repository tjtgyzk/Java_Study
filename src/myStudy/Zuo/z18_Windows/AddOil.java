package myStudy.Zuo.z18_Windows;

import java.util.LinkedList;

public class AddOil {
    public static boolean[] function(int[] gas, int[] cost) {
        boolean[] ans = new boolean[gas.length];
        //差值数据
        int[] arr = new int[gas.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gas[i] - cost[i];
        }
        //前缀和数组
        int[] sum = new int[arr.length * 2];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + arr[i % arr.length];
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        //先维护一个从0-N的窗口
        for (int i = 0; i < arr.length; i++) {
            //踢出不合格数据
            while (!qmin.isEmpty() && sum[qmin.peekLast()] >= sum[i]) {
                qmin.pollLast();
            }
            //加入当前数据
            qmin.addLast(i);
        }
        //窗口右移
        for (int L = 0, R = arr.length, offset = 0; L < arr.length; offset = sum[L++], R++) {
            //首先判断前一轮是否满足条件
            //offset为该最小值需要加上的值
            if (sum[qmin.peekFirst()] - offset >= 0) {
                ans[L] = true;
            }
            //左边界右移，踢出过期数据
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            //右边界右移，加入数据
            //踢出不合格数据
            while (!qmin.isEmpty() && sum[qmin.peekLast()] >= sum[R]) {
                qmin.pollLast();
            }
            //加入数据
            qmin.addLast(R);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] gas = {100, 13, 4};
        int[] cost = {3, 4, 3};
        boolean[] ans = function(gas, cost);
        for (boolean a : ans) {
            System.out.println(a);
        }
    }
}
