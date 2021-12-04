package yu.DynamicProgramming;

public class Num2ZiMu {
    public static int function(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0);
    }

    public static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            //之前的决策有问题，不应该有单独的0出现
            return 0;
        }
        //自己玩
        int p1 = process(str, index + 1);
        //带着后面的玩
        int p2 = 0;
        if (index + 1 < str.length && (str[index] - '0') * 10 + (str[index + 1] - '0') < 27) {
            p2 = process(str, index + 2);
        }
        return p1 + p2;
    }

    public static int function2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //index：0-N
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) {
            if (str[index] != '0') {
                int p1 = dp[index + 1];
                int p2 = 0;
                if (index + 1 < str.length && (str[index] - '0') * 10 + (str[index + 1] - '0') < 27) {
                    p2 = dp[index + 2];
                }
                dp[index] = p1 + p2;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "111231235";
        System.out.println(function(s));
        System.out.println(function2(s));
    }
}
