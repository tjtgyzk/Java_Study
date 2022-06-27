package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            //存放pattern中的字母(下标)映射到word中的同样位置的字母(值)
            boolean match = true;
            int[] map = new int[26];
            boolean[] matched = new boolean[26];
            Arrays.fill(map, -1);
            for (int i = 0; i < pattern.length(); i++) {
                int index = pattern.charAt(i) - 'a';
                int wordIndex = word.charAt(i) - 'a';
                if (map[index] != -1 && map[index] != wordIndex) {
                    match = false;
                    break;
                }
                if (map[index] == -1) {
                    if (matched[wordIndex]) {
                        match = false;
                        break;
                    }
                    map[index] = wordIndex;
                    matched[wordIndex] = true;
                }
            }
            if (match) {
                ans.add(word);
            }
        }
        return ans;
    }
}
