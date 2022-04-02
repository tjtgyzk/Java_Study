package myStudy.Zuo.z19_upperStack;

import java.util.Deque;
import java.util.LinkedList;

public class SelectMaxAim {
    public static int getMax(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        //前缀和数组，用于快速计算累加和
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        //单调栈结构
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {//这里可以取等号，只要最右侧的算对即可
                //弹出并计算结果
                int now = stack.pop();
                // int right = i;
                // int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, arr[now] * (stack.isEmpty() ? sum[i - 1] : sum[i - 1] - sum[stack.peek()]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int now = stack.pop();
            max = Math.max(max, arr[now] * (stack.isEmpty() ? sum[arr.length - 1] : sum[arr.length - 1] - sum[stack.peek()]));
        }
        return max;
    }

    //对数器
    public static int max1(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int minNum = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    minNum = Math.min(minNum, arr[k]);
                }
                max = Math.max(max, minNum * sum);
            }
        }
        return max;
    }

    public static int[] gerenareRondomArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 2000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            int[] arr = gerenareRondomArray();
            if (max1(arr) != getMax(arr)) {
                System.out.println("FUCK!");
                break;
            }
        }
        System.out.println("test finish");
    }
}
