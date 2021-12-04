package myStudy.Zuo.DynamicProgramming;

public class NumToAlpha {
    public static int function(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        return process(strs, 0);
    }

    public static int process(char[] strs, int index) {
        if (index == strs.length) {
            return 1;
        }
        if (strs[index] == '0') {
            //说明之前做的决策有问题，不应该有单独的0出现
            return 0;
        }
        //index位置单独转化成一个字母
        int p1 = process(strs, index + 1);
        //index位置和下一个位置结合的数字转化成为一个字母
        int p2 = 0;
        if (index + 1 < strs.length && 10 * (strs[index] - '0') + (strs[index + 1] - '0') < 27) {
            p2 = process(strs, index + 2);
        }
        return p1 + p2;
    }

    public static int function2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] strs = str.toCharArray();
        int N = strs.length;
        //index范围：1-N
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (strs[i] != '0') {
                //i位置为0时，dp表中对应的位置应该是0，但是初始值就是0，所以只需要设置不为0的位置
                int p1 = dp[i + 1];
                int p2 = 0;
                if (i + 1 < strs.length && 10 * (strs[i] - '0') + (strs[i + 1] - '0') < 27) {
                    p2 = dp[i + 2];
                }
                dp[i] = p1 + p2;
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
