package myStudy.Zuo.DynamicProgramming;

import java.util.HashMap;
import java.util.Map.Entry;

public class PaperMoney_03 {
    public static int function1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int N = map.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            coins[i] = entry.getKey();
            zhangs[i++] = entry.getValue();
        }
        return process(coins, zhangs, 0, aim);

    }

    public static int process(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang <= zhangs[index] && (rest - zhang * coins[index] >= 0); zhang++) {
            ways += process(coins, zhangs, index + 1, rest - zhang * coins[index]);
        }
        return ways;
    }

    public static int function2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int N = map.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            coins[i] = entry.getKey();
            zhangs[i++] = entry.getValue();
        }
        //index:0-N
        //rest:0-aim
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                for (int zhang = 0; zhang <= zhangs[index] && (rest - zhang * coins[index] >= 0); zhang++) {
                    dp[index][rest] += dp[index + 1][rest - (zhang * coins[index])];
                }
            }
        }
        return dp[0][aim];
    }

    public static int function3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int N = map.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            coins[i] = entry.getKey();
            zhangs[i++] = entry.getValue();
        }
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];
                    if (rest - (zhangs[index] + 1) * coins[index] >= 0) {
                        dp[index][rest] -= dp[index + 1][rest - (zhangs[index] + 1) * coins[index]];
                    }
                }
            }
        }
        return dp[0][aim];
    }


    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 为了测试
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 20;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int aim = (int) (Math.random() * maxValue);
            int ans1 = function1(arr, aim);
            int ans2 = function2(arr, aim);
            int ans3 = function3(arr, aim);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println("Oops!");
                printArray(arr);
                System.out.println(aim);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
