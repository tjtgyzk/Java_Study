package LeetCode.SwardOffer.II;

public class OfferII_32 {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return false;
        }
        if (s.equals(t)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
