package LeetCode.SwardOffer.II;

public class OfferII_20 {
    public int countSubstrings(String s) {
        //dp[i][j]表示字符串从i到j的子串是不是回文串
        //i:0--n-1
        //j:0--n-1
        //如果i==j,是一个回文子串,置为1
        //dp[i][j] = (s[i]==s[j]) && dp[i + 1][j - 1]
        //这里要满足(j-1)-(i+1) >= 0 即 j-i >= 2,即子串长度j-i+1>=3时,才判断砍掉头尾后的子串,如果长度为2或者1(其实不会为1),只判断头尾即可
        //只填上半矩阵,依赖左下,按列填即可
        //初始答案至少为每个单独的字符数
        int ans = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstrings1(String s) {
        //马拉车算法
        //https://www.cxyxiaowu.com/2665.html
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        s = sb.toString();
        int[] p = new int[s.length()];
        //(p[i]+1)/2即为该点对应的回文子串个数,如果该点为#,则为左右两个字符位中心的情况
        int ans = 0, center = 0, maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                if (p[mirror] < maxRight - i) {
                    p[i] = p[mirror];
                } else if (p[mirror] == maxRight - i) {
                    p[i] = p[mirror];
                    int left = i - p[i] - 1;
                    int right = i + p[i] + 1;
                    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                        left--;
                        right++;
                        p[i]++;
                    }
                    if (i + p[i] > maxRight) {
                        center = i;
                        maxRight = i + p[i];
                    }
                } else {
                    p[i] = maxRight - i;
                }
            } else {
                int left = i - 1, right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    p[i]++;
                }
                center = i;
                maxRight = i + p[i];
            }
            ans += (p[i] + 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_20().countSubstrings1("aa"));
    }
}
