package myStudy.Zuo.DynamicProgramming;

public class LongestSubArr {
    //给你两个字符串，找到它们的最长公共子序列
    public static int getLongestSubArr(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        return process(str1, str2, str1.length - 1, str2.length - 1);
    }

    //len1和len2分别代表所求公共子序列的字符串的末尾位置
    public static int process(char[] str1, char[] str2, int len1, int len2) {
        if (len1 == 0 && len2 == 0) {
            //如果都是0，只需要比较这一位是否相等，相等就有一个公共子序列长度为1，否则没有公共子序列
            return str1[0] == str2[0] ? 1 : 0;
        }
        if (len1 == 0) {
            //如果str1只有一个，则判断它与str2的末尾是否相等，如果相等，那么最长就是str1的长度1，否则可以递归调用，去掉str2的末尾
            if (str1[0] == str2[len2]) {
                return 1;
            } else {
                return process(str1, str2, len1, len2 - 1);
            }
        }
        if (len2 == 0) {
            //与上述同理
            if (str1[len1] == str2[0]) {
                return 1;
            } else {
                return process(str1, str2, len1 - 1, len2);
            }
        }
        //此后，str1和str2都不可能只有一位
        //一共三种可能性：
        //1.str1减一位，str2不变，递归调用
        //2.str1不变，str2减一位，递归调用
        //3.最后一位相等，返回str1-1和str2-1的递归调用结果，又因为最后一位相等，所以加上1
        int p1 = process(str1, str2, len1 - 1, len2);
        int p2 = process(str1, str2, len1, len2 - 1);
        int p3 = str1[len1] == str2[len2] ? (process(str1, str2, len1 - 1, len2 - 1) + 1) : 0;
        return Math.max(p1, Math.max(p2, p3));
    }

    public static int getLongestSubArr1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int N = str1.length;
        int M = str2.length;
        //len1范围：0-N-1
        //len2范围：0-M-1
        int[][] dp = new int[N][M];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //第一行：len1==0
        for (int j = 1; j < M; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }
        //第一列：len2==0
        for (int i = 1; i < N; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? (dp[i - 1][j - 1] + 1) : 0;
                int ans = Math.max(p1, Math.max(p2, p3));
                dp[i][j] = ans;
            }
        }
        return dp[N - 1][M - 1];
    }
}
