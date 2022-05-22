package LeetCode.SwardOffer.II;

public class OfferII_14 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        //第一个字符串的排列之一是第二个字符串的子串
        //滑动窗口,使用cnt[26]表示窗口内s1与s2不同的字母种类(不是字母数量)!!!!,统计其数量count
        //先将s1的字母加入cnt,记为负数,然后对于每一个滑动窗口,加入的数字为x,移除的数字为y,
        //对于x,如果加入前cnt[x]==0,则加入后多一个x,count+1,如果加入后cnt[x]==0,则证明刚好补充了这个x,count-1;
        //对于y,如果减掉前cnt[y]==0,则减掉后少一个y,count+1,如果减掉后cnt[y]==0,则证明刚好移除了多余的y,count-1;
        int count = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        for (int c : cnt) {
            if (c != 0) {
                count++;
            }
        }
        int r = 0;
        while (r < s2.length()) {
            int x = s2.charAt(r) - 'a';
            int y = -1;
            if (r >= s1.length()) {
                y = s2.charAt(r - s1.length()) - 'a';
            }
            if (cnt[x] == 0) {
                count++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                count--;
            }
            if (y != -1) {
                if (cnt[y] == 0) {
                    count++;
                }
                cnt[y]--;
                if (cnt[y] == 0) {
                    count--;
                }
            }
            if (count == 0) {
                return true;
            }
            r++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new OfferII_14().checkInclusion("abb", "cdeaabbb"));
    }
}
