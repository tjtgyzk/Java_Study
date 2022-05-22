package LeetCode.String.ToNum;

import java.util.HashMap;
import java.util.Map;

public class L299 {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> hash = new HashMap<>();
        int Bull = 0;
        int Cow = 0;
        char[] target = secret.toCharArray();
        char[] users = guess.toCharArray();
        for (int i = 0; i < users.length; i++) {
            if (users[i] == target[i]) {
                Bull++;
            }
        }
        for (char c : target) {
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }
        for (char c : users) {
            if (hash.containsKey(c)) {
                Cow++;
                hash.put(c, hash.get(c) - 1);
                if (hash.get(c) == 0) {
                    hash.remove(c);
                }
            }
        }
        //奶牛数里包含公牛数,所以要减掉对应个数的公牛数
        Cow -= Bull;
        return Bull + "A" + Cow + "B";
    }
}
