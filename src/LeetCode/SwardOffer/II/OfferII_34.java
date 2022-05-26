package LeetCode.SwardOffer.II;

public class OfferII_34 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 0 || words.length == 1) {
            return true;
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < 20; j++) {
                if (words[i].length() == j || words[i - 1].length() == j) {
                    //有一个遍历完了
                    if (words[i - 1].length() > words[i].length()) {
                        return false;
                    }
                    //继续比较下一个String
                    break;
                }
                int lastIndex = order.indexOf(words[i - 1].charAt(j));
                int thisIndex = order.indexOf(words[i].charAt(j));
                if (lastIndex > thisIndex) {
                    //如果第j个字母不符合字典序
                    return false;
                } else if (lastIndex < thisIndex) {
                    //第j个字母符合字典序(前面的都相同),则当前两个String符合字典序,继续比较下一个String
                    break;
                }
            }
        }
        return true;
    }
}
