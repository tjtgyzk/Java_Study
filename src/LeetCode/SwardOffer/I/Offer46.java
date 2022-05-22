package LeetCode.SwardOffer.I;

public class Offer46 {
    public int translateNum(int num) {
        //dp[i]表示数组中从第i个数开始翻译,有多少种翻译方式
        //dp[n] = 1 之前的都成功翻译完,算1种
        //每个位置可以选择自己或者带着自己的下一个数一起翻译,注意如果两个数一起翻译,需要满足1.没有前导0,2.两个数拼起来小26
        String s = Integer.toString(num);
        char[] chars = Integer.toString(num).toCharArray();
//        int[] dp = new int[chars.length + 1];
//        dp[chars.length] = 1;
//        for (int i = chars.length - 1; i >= 0; i--) {
//            dp[i] += dp[i + 1];
//            if (i + 2 <= chars.length && chars[i] != '0' && (chars[i] - '0') * 10 + (chars[i + 1] - '0') < 26) {
//                dp[i] += dp[i + 2];
//            }
//        }
//        return dp[0];
        //使用滚动数组优化空间复杂度
        //dp[n+2]
        int two = 0;
        //dp[n+1]
        int one = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int ans = one;
            if (i + 2 <= s.length() && s.charAt(i) != '0' && (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') < 26) {
                ans += two;
            }
            two = one;
            one = ans;
        }
        return one;
    }

    public int process(int index, char[] chars) {
        if (index == chars.length) {
            return 1;
        }
        int one = process(index + 1, chars);
        int two = 0;
        if (index < chars.length - 1 && chars[index] != '0' && (chars[index] - '0') * 10 + (chars[index + 1] - '0') < 26) {
            two = process(index + 2, chars);
        }
        return one + two;
    }
}
