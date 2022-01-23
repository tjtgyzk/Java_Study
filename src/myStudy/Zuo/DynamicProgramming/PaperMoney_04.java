package myStudy.Zuo.DynamicProgramming;

public class PaperMoney_04 {
    //返回组成aim的最少货币数
    public static int function1(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    //index当前要选择的货币
    //rest剩余要组成的钱数
    public static int process(int[] arr, int index, int rest) {
        if (rest == 0) {
            //需要组成的钱为0，所以一张都不需要
            return 0;
        }
        if (index == arr.length) {
            //没有钱可以选择，返回一个错误值
            return Integer.MAX_VALUE;
        }
        //先设置成为错误值
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; rest - zhang * arr[index] >= 0; zhang++) {
            int next = process(arr, index + 1, rest - zhang * arr[index]);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + zhang);
            }
        }
        return ans;
    }


    public static int function2(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        //index:0-N
        //rest:0-aim
        int[][] dp = new int[N + 1][aim + 1];
        for (int j = 1; j <= aim; j++) {
            //除了N，0位置外，第N行都是无效值
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhang = 0; rest - zhang * arr[index] >= 0; zhang++) {
                    int next = dp[index + 1][rest - zhang * arr[index]];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(ans, next + zhang);
                    }
                }
                dp[index][rest] = ans;
            }
        }
        return dp[0][aim];
    }

    //观察依赖关系，进一步优化，可以发现每个位置是其下面和下面左边的格子们的最小值，所以只需要拿到该位置左侧格子+1的值与该位置下侧位置的值相比即可
    public static int function3(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        //index:0-N
        //rest:0-aim
        int[][] dp = new int[N + 1][aim + 1];
        for (int j = 1; j <= aim; j++) {
            //除了N，0位置外，第N行都是无效值
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                //先让它等于下面的值
                dp[index][rest] = dp[index + 1][rest];
                //首先保证有左边的值
                if (rest - arr[index] >= 0 && dp[index][rest - arr[index]] != Integer.MAX_VALUE) {
                    //左侧位置为有效值
                    dp[index][rest] = Math.min(dp[index][rest - arr[index]] + 1, dp[index][rest]);
                }
            }
        }
        return dp[0][aim];
    }


    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        boolean[] has = new boolean[maxValue + 1];
        for (int i = 0; i < N; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) + 1;
            } while (has[arr[i]]);
            has[arr[i]] = true;
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
        int maxLen = 20;
        int maxValue = 30;
        int testTime = 300000;
        System.out.println("功能测试开始");
        for (int i = 0; i < testTime; i++) {
            int N = (int) (Math.random() * maxLen);
            int[] arr = randomArray(N, maxValue);
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
                break;
            }
        }
        System.out.println("功能测试结束");
    }
}
