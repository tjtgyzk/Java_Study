package LeetCode.SwardOffer.II;

public class OfferII_18 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while (l < r) {
            while (l < r && (s.charAt(l) < 'a' || s.charAt(l) > 'z') && (s.charAt(l) < '0' || s.charAt(l) > '9')) {
                l++;
            }
            while (l < r && (s.charAt(r) < 'a' || s.charAt(r) > 'z') && (s.charAt(r) < '0' || s.charAt(r) > '9')) {
                r--;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_18().isPalindrome("ab2a"));
    }
}
