package LeetCode;

public class L17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int ans = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
                if (word2Index != -1) {
                    ans = Math.min(ans, i - word2Index);
                }
            }
            if (words[i].equals(word2)) {
                word2Index = i;
                if (word1Index != -1) {
                    ans = Math.min(ans, i - word1Index);
                }
            }
        }
        return ans;
    }
}
