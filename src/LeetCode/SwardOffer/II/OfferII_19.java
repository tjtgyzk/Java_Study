package LeetCode.SwardOffer.II;

public class OfferII_19 {
    boolean chance = true;

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (chance && s.charAt(l) != s.charAt(r)) {
                chance = false;
                return validPalindrome(s.substring(l + 1, r + 1)) || validPalindrome(s.substring(l, r));
            } else if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
