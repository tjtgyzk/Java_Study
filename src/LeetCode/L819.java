package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class L819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<String>();
        for (String s : banned) {
            if (!set.contains(s)) {
                set.add(s);
            }
        }
        String[] strings = paragraph.split("\\W+");
        for (String cur : strings) {
            if (!set.contains(cur)) {
                if (!map.containsKey(cur)) {
                    map.put(cur, 1);
                } else {
                    map.put(cur, map.get(cur) + 1);
                }
            }
        }
        String ans = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
    }
}
