package yu.DynamicProgramming;

public class LongestSubArr {
    public static int function1(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        return process(str1, str2, str1.length - 1, str2.length - 1);
    }

    public static int process(char[] str1, char[] str2, int len1, int len2) {
        if (len1 == 0 && len2 == 0) {
            return str1[0] == str2[0] ? 1 : 0;
        }
        if (len1 == 0) {
            if (str1[0] == str2[len2]) {
                return 1;
            } else {
                return process(str1, str2, 0, len2 - 1);
            }
        }
        if (len2 == 0) {
            return str1[len1] == str2[0] ? 1 : process(str1, str2, len1 - 1, 0);
        }
        //都不止一位
        //如果他俩最后一位相等，返回pro（len1-1,len2-1）+1
        int p1 = str1[len1] == str2[len2] ? (1 + process(str1, str2, len1 - 1, len2 - 1)) : 0;
        //其中的一个减一位
        int p2 = process(str1, str2, len1 - 1, len2);
        int p3 = process(str1, str2, len1, len2 - 1);
        return Math.max(p1, Math.max(p2, p3));
    }

    public static int function2(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //len1:0->N-1
        //len2:0->M-1
        int N = str1.length;
        int M = str2.length;
        int[][] dp = new int[N][M];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int len2 = 1; len2 < M; len2++) {
            dp[0][len2] = str1[0] == str2[len2] ? 1 : dp[0][len2 - 1];
        }
        for (int len1 = 1; len1 < N; len1++) {
            dp[len1][0] = str1[len1] == str2[0] ? 1 : dp[len1 - 1][0];
        }
        for (int len1 = 1; len1 < N; len1++) {
            for (int len2 = 1; len2 < M; len2++) {
                int p1 = str1[len1] == str2[len2] ? (1 + dp[len1 - 1][len2 - 1]) : 0;
                int p2 = dp[len1 - 1][len2];
                int p3 = dp[len1][len2 - 1];
                dp[len1][len2] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[N - 1][M - 1];
    }
}
