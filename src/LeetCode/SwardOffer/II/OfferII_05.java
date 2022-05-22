package LeetCode.SwardOffer.II;

public class OfferII_05 {
    public int maxProduct(String[] words) {
        //字符串掩码:使用一个int类型的数,a-z分别对应数字的0-25位,如果出现该字母,将该位置为1
        //如果两个字符串掩码 codeA & codeB == 0,则说明两个字符串没有相同字母
        int[] code = new int[words.length];
        for (int i = 0; i < code.length; i++) {
            int codeI = 0;
            for (int j = 0; j < words[i].length(); j++) {
                codeI |= 1 << (words[i].charAt(j) - 'a');
            }
            code[i] = codeI;
        }
        int ans = 0;
        for (int i = 0; i < code.length; i++) {
            for (int j = i + 1; j < code.length; j++) {
                if ((code[i] & code[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
