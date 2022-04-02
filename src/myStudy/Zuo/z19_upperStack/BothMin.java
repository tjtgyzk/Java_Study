package myStudy.Zuo.z19_upperStack;

import java.util.*;

public class BothMin {
    public static int[][] getMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[][] res = new int[arr.length][2];
        //单调栈
        Deque<LinkedList<Integer>> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            //当不满足条件，需要弹出数据时(栈顶元素大于要压入元素时)
            while (!stack.isEmpty() && arr[stack.peek().peekLast()] > arr[i]) {
                //需要为弹出元素（们）设置答案
                LinkedList<Integer> now = stack.pop();
                //左边最小即为弹出后当前栈顶元素链表的最后一个,如果没有设置为-1;
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().peekLast();
                //右边最小即为当前元素
                //为now中每一个元素设置结果
                for (Integer j : now) {
                    res[j][0] = leftLessIndex;
                    res[j][1] = i;
                }
            }
            //如果相等，则添加到链表中
            if (!stack.isEmpty() && arr[stack.peek().peekLast()] == arr[i]) {
                stack.peek().addLast(Integer.valueOf(i));
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(Integer.valueOf(i));
                stack.push(list);
            }
        }
        //最后栈中如果扔有元素，则弹出并添加答案，此时右侧最小不存在，为-1
        while (!stack.isEmpty()) {
            LinkedList<Integer> now = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().peekLast();
            for (Integer j : now) {
                res[j][0] = leftLessIndex;
                res[j][1] = -1;
            }
        }
        return res;
    }

    //对数器

    // for test

    // for test
    public static int[] getRandomArray(int size, int max) {
        int[] arr = new int[(int) (Math.random() * size) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[][] res1, int[][] res2) {
        if (res1.length != res2.length) {
            return false;
        }
        for (int i = 0; i < res1.length; i++) {
            if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
                return false;
            }
        }

        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        int max = 20;
        int testTimes = 2000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr2 = getRandomArray(size, max);
            if (!isEqual(getMin(arr2), rightWay(arr2))) {
                System.out.println("Oops!");
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
