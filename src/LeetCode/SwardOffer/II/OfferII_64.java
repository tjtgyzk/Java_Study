package LeetCode.SwardOffer.II;

public class OfferII_64 {
    public MagicDictionary get() {
        return new MagicDictionary();
    }

    class MagicDictionary {
        String[] dic;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
        }

        public void buildDict(String[] dictionary) {
            dic = dictionary;
        }

        public boolean search(String searchWord) {
            for (String s : dic) {
                int dif = 0;
                if (s.length() == searchWord.length()) {
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) != searchWord.charAt(i)) {
                            dif++;
                        }
                    }
                    if (dif == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
