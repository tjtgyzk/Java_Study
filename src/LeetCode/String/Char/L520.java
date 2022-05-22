package LeetCode.String.Char;

public class L520 {
    public boolean detectCapitalUse(String word) {
        //如果第一个是大写,如果后面存在小写,则必须都是小写
        //如果第一个是小写,则必须全是小写
        char[] words = word.toCharArray();
        boolean containsSmall = isSmall(words[0]) ? true : false;
        boolean containsBigExceptFirst = false;
        for (int i = 1; i < words.length; i++) {
            if (isBig(words[i])) {
                containsBigExceptFirst = true;
            }
            if (isSmall(words[i])) {
                containsSmall = true;
            }
            if (isBig(words[0]) && containsSmall && containsBigExceptFirst) {
                return false;
            } else if (isSmall(words[0]) && containsBigExceptFirst) {
                return false;
            }
        }
        return true;
    }

    boolean isBig(char word) {
        if (word >= 'A' && word <= 'Z') {
            return true;
        }
        return false;
    }

    boolean isSmall(char word) {
        if (word >= 'a' && word <= 'z') {
            return true;
        }
        return false;
    }
}
