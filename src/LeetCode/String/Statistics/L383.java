package LeetCode.String.Statistics;

public class L383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            map[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            map[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new L383().canConstruct("aab", "baa");
    }
}
