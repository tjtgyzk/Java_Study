package LeetCode.SwardOffer.II;

public class OfferII_17 {
    public String minWindow(String s, String t) {
        //滑动窗口,使用count记录距离满足含有t中所有字符还差几种字母
        //先将s1的字母加入cnt,记为正数,然后对于每一个滑动窗口,加入的数字为in,移除的数字为out,
        //对于in,cnt[in]--,如果减掉后cnt[in]==0,则count-1,如果减为负数不用管,代表该种字母多了几个而已,对于不需要的字母一开始cnt[notNeed]就为0,减成负数无所谓不影响结果
        //对于out,cnt[out]++,如果加完后cnt[out]==1,说明原本是满足的,现在有1个该字母的缺口,count+1
        if (s.length() < t.length()) {
            return "";
        }
        int l = 0, r = 0;
        int[] cnt = new int[58];
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i) - 'A']++;
        }
        while (l < s.length() && cnt[s.charAt(l) - 'A'] == 0) {
            l++;
        }
        r = l;
        if (s.length() - l + 1 < t.length()) {
            return "";
        }
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";
        for (int i : cnt) {
            if (i != 0) {
                count++;
            }
        }
        while (r < s.length()) {
            //右边界右移直到窗口内满足要求
            while (r < s.length() && count != 0) {
                int in = s.charAt(r) - 'A';
                cnt[in]--;
                if (cnt[in] == 0) {
                    count--;
                }
                //这里去了下一个r
                r++;
            }
            //如果走到最后都没有满足count==0,则返回ans,如果之前有结果的话则为之前的结果,如果没有的话则是初始值空字符串
            if (count != 0) {
                return ans;
            }
            //左边界右移直到窗口内不满足要求
            while (l < r && count == 0) {
                int out = s.charAt(l) - 'A';
                cnt[out]++;
                if (cnt[out] == 1) {
                    count++;
                }
                l++;
            }
            //此时窗口边界为[l-1,r-1]
            minLength = Math.min(minLength, r - l + 1);
            if (minLength == r - l + 1) {
                ans = s.substring(l - 1, r);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_17().minWindow("ab", "a"));
    }
}
