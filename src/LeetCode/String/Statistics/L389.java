package LeetCode.String.Statistics;

public class L389 {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return ' ';
    }

}
