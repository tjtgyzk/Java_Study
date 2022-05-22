package LeetCode.SwardOffer.II;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_02 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String longOne = a.length() > b.length() ? a : b;
        String shortOne = longOne.equals(a) ? b : a;
        LinkedList<Character> longList = new LinkedList<Character>();
        LinkedList<Character> shortList = new LinkedList<Character>();
        for (int i = longOne.length() - 1; i >= 0; i--) {
            longList.add(longOne.charAt(i));
        }
        for (int i = shortOne.length() - 1; i >= 0; i--) {
            shortList.add(shortOne.charAt(i));
        }
        while (longList.size() > shortList.size()) {
            shortList.add('0');
        }
        int over = 0;
        while (!longList.isEmpty()) {
            int p = Integer.parseInt(longList.pollFirst().toString());
            int q = Integer.parseInt(shortList.pollFirst().toString());
            if (p + q + over == 2) {
                sb.append(0);
                over = 1;
            } else if (p + q + over == 3) {
                sb.append(1);
                over = 1;
            } else {
                sb.append(p + q + over);
                over = 0;
            }
        }
        if (over == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new OfferII_02().addBinary("1010", "1011");
    }
}
