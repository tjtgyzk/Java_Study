package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L691 {
    public int minStickers(String[] stickers, String target) {
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process(stickers, target, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * @param stickers 可选取的贴纸数组
     * @param rest     目标要拼的数组
     * @return
     */
    public int process(String[] stickers, String rest, HashMap<String, Integer> dp) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }
        if (rest.length() == 0 || rest == null) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String afterCut = peekSticker(rest.toCharArray(), sticker.toCharArray());
            if (afterCut.length() != rest.length()) {
                int next = process(stickers, afterCut, dp);
                if (next == Integer.MAX_VALUE) {
                    break;
                }
                ans = Math.min(ans, next + 1);
            }
        }
        dp.put(rest, ans);
        return ans;
    }

    //从target中减去一张贴纸能满足的字母
    public String peekSticker(char[] target, char[] sticker) {
        int[] targetCount = new int[26];
        for (char c : target) {
            targetCount[c - 'a']++;
        }
        for (char c : sticker) {
            targetCount[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetCount.length; i++) {
            while (targetCount[i] > 0) {
                sb.append((char) (i + 'a'));
                targetCount[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


    }
}
