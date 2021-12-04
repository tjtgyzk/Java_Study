package myStudy.Zuo.DynamicProgramming;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Coffee {
    //比较器
    public static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0] + o1[1]) - (o2[0] + o2[1]);
        }
    }

    public static int function1(int[] arr, int N, int wash, int air) {
        //先不考虑洗杯子的过程，求出每个人喝完咖啡的时间
        int[] drinks = new int[N];
        //[可用时间，使用一次所需等待时间]
        int[][] coffeeMachine = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            coffeeMachine[i][0] = 0;
            coffeeMachine[i][1] = arr[i];
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new MyComparator());
        for (int[] ar : coffeeMachine) {
            heap.add(ar);
        }
        for (int i = 0; i < N; i++) {
            int[] cm = heap.poll();
            drinks[i] = cm[0] + cm[1];
            cm[0] += cm[1];
            heap.add(cm);
        }
        //drinks[]即为每个人喝完咖啡的时间
        return process(drinks, 0, 0, wash, air);
    }

    //index为目前到几号被子选了，freeTime表示洗机下次可用的时间，wash表示洗的时间，air表示挥发的时间
    //该函数返回从index杯子开始，所有杯子都干净的时间
    public static int process(int[] drinks, int index, int freeTime, int wash, int air) {
        if (index == drinks.length) {
            return 0;
        }
        //index号杯子决定洗
        int selfClean1 = Math.max(drinks[index], freeTime) + wash;
        int otherClean1 = process(drinks, index + 1, selfClean1, wash, air);
        int p1 = Math.max(selfClean1, otherClean1);
        //index号杯子决定挥发
        int selfClean2 = drinks[index] + air;
        int otherClean2 = process(drinks, index + 1, freeTime, wash, air);
        int p2 = Math.max(selfClean2, otherClean2);

        int ans = Math.min(p1, p2);
        return ans;
    }

    public static int function2(int[] arr, int N, int wash, int air) {
        //先不考虑洗杯子的过程，求出每个人喝完咖啡的时间
        int[] drinks = new int[N];
        //[可用时间，使用一次所需等待时间]
        int[][] coffeeMachine = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            coffeeMachine[i][0] = 0;
            coffeeMachine[i][1] = arr[i];
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new MyComparator());
        for (int[] ar : coffeeMachine) {
            heap.add(ar);
        }
        for (int i = 0; i < N; i++) {
            int[] cm = heap.poll();
            drinks[i] = cm[0] + cm[1];
            cm[0] += cm[1];
            heap.add(cm);
        }
        //drinks[]即为每个人喝完咖啡的时间
        //index：0-N
        //freeTime:范围不确定，所以求一个能求的最大的且最不会比最好情况小的
        //所有杯子都拿去洗
        int maxTime = 0;
        for (int i = 0; i < drinks.length; i++) {
            maxTime = Math.max(maxTime, drinks[i]) + wash;
        }
        int[][] dp = new int[N + 1][maxTime + 1];
        //index==0,dp==0
        //从下往上填
        for (int index = N - 1; index >= 0; index--) {
            for (int freeTime = 0; freeTime <= maxTime; freeTime++) {
                //洗
                int selfClean1 = Math.max(freeTime, drinks[index]) + wash;
                if (selfClean1 > maxTime) {
                    //如果越界，则这种方法一定被淘汰，可以不看
                    break;
                }
                int otherClean1 = dp[index + 1][selfClean1];
                int p1 = Math.max(selfClean1, otherClean1);
                //晾干
                int selfClean2 = drinks[index] + air;
                int otherClean2 = dp[index + 1][freeTime];
                int p2 = Math.max(selfClean2, otherClean2);
                dp[index][freeTime] = Math.min(p1, p2);
            }
        }
        return dp[0][0];
    }

    //对数器
    // 验证的方法
    // 彻底的暴力
    // 很慢但是绝对正确
    public static int right(int[] arr, int n, int a, int b) {
        int[] times = new int[arr.length];
        int[] drink = new int[n];
        return forceMake(arr, times, 0, drink, n, a, b);
    }

    // 每个人暴力尝试用每一个咖啡机给自己做咖啡
    public static int forceMake(int[] arr, int[] times, int kth, int[] drink, int n, int a, int b) {
        if (kth == n) {
            int[] drinkSorted = Arrays.copyOf(drink, kth);
            Arrays.sort(drinkSorted);
            return forceWash(drinkSorted, a, b, 0, 0, 0);
        }
        int time = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int work = arr[i];
            int pre = times[i];
            drink[kth] = pre + work;
            times[i] = pre + work;
            time = Math.min(time, forceMake(arr, times, kth + 1, drink, n, a, b));
            drink[kth] = 0;
            times[i] = pre;
        }
        return time;
    }

    public static int forceWash(int[] drinks, int a, int b, int index, int washLine, int time) {
        if (index == drinks.length) {
            return time;
        }
        // 选择一：当前index号咖啡杯，选择用洗咖啡机刷干净
        int wash = Math.max(drinks[index], washLine) + a;
        int ans1 = forceWash(drinks, a, b, index + 1, wash, Math.max(wash, time));

        // 选择二：当前index号咖啡杯，选择自然挥发
        int dry = drinks[index] + b;
        int ans2 = forceWash(drinks, a, b, index + 1, washLine, Math.max(dry, time));
        return Math.min(ans1, ans2);
    }

    // for test
    public static int[] randomArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        System.out.print("arr : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(len, max);
            int n = (int) (Math.random() * 7) + 1;
            int a = (int) (Math.random() * 7) + 1;
            int b = (int) (Math.random() * 10) + 1;
            int ans1 = right(arr, n, a, b);
            int ans2 = function1(arr, n, a, b);
            int ans3 = function2(arr, n, a, b);
            if (ans1 != ans2 || ans2 != ans3) {
                printArray(arr);
                System.out.println("n : " + n);
                System.out.println("a : " + a);
                System.out.println("b : " + b);
                System.out.println(ans1 + " , " + ans2 + " , " + ans3);
                System.out.println("===============");
                break;
            }
        }
        System.out.println("测试结束");

    }

}
