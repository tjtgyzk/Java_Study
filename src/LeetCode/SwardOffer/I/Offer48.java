package LeetCode.SwardOffer.I;

import java.util.HashSet;
import java.util.Set;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        //妈的有空格和大写,直接用set吧
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 1;
        set.add(s.charAt(l));
        int ans = 0;
        while (r < s.length()) {
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
            }
            ans = Math.max(ans, r - l);
            set.remove(s.charAt(l++));
        }
        return ans;
    }

    public static void main(String[] args) {
        new Offer48().lengthOfLongestSubstring(" ");
    }
}
