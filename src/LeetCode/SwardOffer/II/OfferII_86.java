package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_86 {
    List<String> temp = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();

    public String[][] partition(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < chars.length; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = (chars[i] == chars[j]) && (j - i < 2 || dp[i + 1][j - 1]);
            }
        }
        dfs(chars, 0, dp);
        String[][] res = new String[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i).toArray(new String[ans.get(i).size()]);
        }
        return res;
    }

    public void dfs(char[] chars, int index, boolean[][] dp) {
        if (index == chars.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = index; j < chars.length; j++) {
            if (dp[index][j]) {
                temp.add(String.valueOf(chars, index, j - index + 1));
                dfs(chars, j + 1, dp);
                temp.remove(temp.size() - 1);
            } else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_86().partition("google"));
    }
}
