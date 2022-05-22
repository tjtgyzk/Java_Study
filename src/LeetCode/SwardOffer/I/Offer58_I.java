package LeetCode.SwardOffer.I;

public class Offer58_I {
    public String reverseWords(String s) {
        s = s.strip();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() > 0 && s1[i] != " ") {
                sb.append(s1[i] + " ");
            }
        }
        return sb.toString().strip();
    }
}
