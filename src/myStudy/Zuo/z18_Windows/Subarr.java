package myStudy.Zuo.z18_Windows;

import java.util.LinkedList;

public class Subarr {
    public static int function(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        //维护两个窗口
        LinkedList<Integer> qmax = new LinkedList();
        LinkedList<Integer> qmin = new LinkedList();
        int L = 0, R = 0, ans = 0;
        while (L < arr.length) {
            //清除下标过期的数据
            if (!qmax.isEmpty() && (qmax.peekFirst() == L - 1)) {
                qmax.pollFirst();
            }
            if (!qmin.isEmpty() && (qmin.peekFirst() == L - 1)) {
                qmin.pollFirst();
            }
            //R右扩，同时更新最大值最小值队列
            while (R < arr.length) {
                //弹出不满足的数据
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                //放入当前数据的下标
                qmax.addLast(R);
                qmin.addLast(R);
                //如果不满足要求，则停止右扩，停留在不满足的第一个数
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break;
                }
                R++;

            }
            //此时以L为开头的达标子数组有R-L个
            ans += R - L;
            L++;
        }
        return ans;
    }

    //对数器
    // 暴力的对数器方法
    public static int right(int[] arr, int sum) {
        if (arr == null || arr.length == 0 || sum < 0) {
            return 0;
        }
        int N = arr.length;
        int count = 0;
        for (int L = 0; L < N; L++) {
            for (int R = L; R < N; R++) {
                int max = arr[L];
                int min = arr[L];
                for (int i = L + 1; i <= R; i++) {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i]);
                }
                if (max - min <= sum) {
                    count++;
                }
            }
        }
        return count;
    }

    // for test
    public static int[] generateRandomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * (maxLen + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxLen, maxValue);
            int sum = (int) (Math.random() * (maxValue + 1));
            int ans1 = right(arr, sum);
            int ans2 = function(arr, sum);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(sum);
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("测试结束");

    }
}