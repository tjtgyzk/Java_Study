package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_15 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']--;
        }
        for (int c : cnt) {
            if (c != 0) {
                count++;
            }
        }
        int r = 0;
        while (r < s.length()) {
            int x = s.charAt(r) - 'a';
            int y = -1;
            if (r >= p.length()) {
                y = s.charAt(r - p.length()) - 'a';
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
                ans.add(r - p.length() + 1);
            }
            r++;
        }
        return ans;
    }
}
