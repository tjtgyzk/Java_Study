package LeetCode.SwardOffer.II;

import java.util.HashSet;

public class OfferII_16 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < s.length()) {
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans, r - l);
            set.remove(s.charAt(l++));
        }
        return ans;
    }
}
