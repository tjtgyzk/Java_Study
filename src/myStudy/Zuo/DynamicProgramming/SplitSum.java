package myStudy.Zuo.DynamicProgramming;

public class SplitSum {
    public static int function1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return process(arr, 0, sum / 2);

    }

    //给定arr，index和要凑的目标数,返回最接近目标数的和
    public static int process(int[] arr, int index, int aim) {
        if (index == arr.length) {
            //没有数了，不管目标数是几，最接近目标数的和都是0
            return 0;
        }
        if (aim == 0) {
            //不需要凑了，直接返回0
            return 0;
        }
        if (arr[index] > aim) {
            //选择当前数就会超过aim，所以当前数不能选
            return process(arr, index + 1, aim);
        }
        //当前数小于等于目标数
        //不要当前数
        int p1 = process(arr, index + 1, aim);
        //要当前数
        int p2 = arr[index] + process(arr, index + 1, aim - arr[index]);
        return Math.max(p1, p2);
    }

    public static int function2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        //index:0-N
        //aim:0-aim
        int aim = sum / 2;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = (rest - arr[index] >= 0) ? dp[index + 1][rest - arr[index]] + arr[index] : 0;
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][aim];
    }


    public static int[] randomArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * value);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 20;
        int maxValue = 50;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * maxLen);
            int[] arr = randomArray(len, maxValue);
            int ans1 = function1(arr);
            int ans2 = function2(arr);
            if (ans1 != ans2) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束");
    }
}
