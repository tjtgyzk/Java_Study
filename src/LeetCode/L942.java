package LeetCode;

public class L942 {
    public int[] diStringMatch(String s) {
        //遇到I,说明接下来存在一个递增,则放入可放的最小值min(从0开始)保证递增成立
        //遇到D,说明接下来存在一个递减,则放入可放的最大值max(从n开始)
        //只剩一个位置时,此时min和max相等,都等于还剩的那个数,放入即可
        int n = s.length();
        int min = 0, max = n;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I' ? min++ : max--;
        }
        ans[n] = min;
        return ans;
    }
}
