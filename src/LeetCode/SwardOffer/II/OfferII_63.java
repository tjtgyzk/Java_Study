package LeetCode.SwardOffer.II;

import java.util.Collections;
import java.util.List;

public class OfferII_63 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary);
        String[] str = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            for (String s : dictionary) {
                if (str[i].startsWith(s)) {
                    str[i] = s;
                }
            }
            sb.append(str[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
