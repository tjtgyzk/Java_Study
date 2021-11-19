package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Le299 {
    public static void main(String[] args) {
        System.out.println(getHint("110", "110"));
    }

    public static String getHint(String secret, String guess) {
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
        Cow -= Bull;
        return Bull + "A" + Cow + "B";
    }

}
