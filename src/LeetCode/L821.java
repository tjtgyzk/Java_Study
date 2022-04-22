package LeetCode;

public class L821 {
    public int[] shortestToChar(String s, char c) {
//        给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
//        返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
//        两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
        //先从左到右,找到其左侧最近的c
        //再从右到左,找到其右侧最近的c,与左侧的取最小
        int leftC = -1;
        int rightC = -1;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (chars[i] == c) {
                leftC = i;
            }
            if (leftC == -1) {
                ans[i] = n + 1;
            } else {
                ans[i] = i - leftC;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == c) {
                rightC = i;
            }
            if (rightC == -1) {
                ans[i] = Math.min(ans[i], n + 1);
            } else {
                ans[i] = Math.min(ans[i], rightC - i);
            }
        }
        return ans;
    }
}
