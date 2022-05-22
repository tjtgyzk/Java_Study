package LeetCode.String.Statistics;

import java.util.ArrayList;
import java.util.List;

public class L467 {
    //找出p中分别的连续的子串长度,形如"abc.."这样的视为连续,注意:"za"也是连续的
    //每个连续的子串长度为l,则每个连续子串对应着l!个s中唯一的连续子串
    //为避免有重复子串,保存以每个连续子串结尾字母对应的最大子串长度,
    //如"zaba" z结尾的长度为1,对应z; a结尾的长度为2, 对应a,za;b结尾的长度为3,对应b,ab,zab,加起来共6个,最后一个a小于之前的2,说明已被包含,不计入
    public int findSubstringInWraproundString(String p) {
        int curLength = 1;
        int n = p.length();
        int[] map = new int[26];
        int ans = 0;
        map[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            if ((p.charAt(i) == 'a' && p.charAt(i - 1) == 'z') || p.charAt(i) - p.charAt(i - 1) == 1) {
                //连续的
                map[p.charAt(i) - 'a'] = Math.max(++curLength, map[p.charAt(i) - 'a']);
            } else {
                //不连续
                map[p.charAt(i) - 'a'] = Math.max(1, map[p.charAt(i) - 'a']);
                curLength = 1;
            }

        }
        //必须加入最后一组连续的字符长度!!!和之前求max时同理,要考虑最后一组!
        map[p.charAt(n - 1) - 'a'] = Math.max(map[p.charAt(n - 1) - 'a'], curLength);
        for (int num : map) {
            ans += num;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new L467().findSubstringInWraproundString("zaba"));
    }
}
