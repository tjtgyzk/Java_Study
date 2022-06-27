package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_85 {
    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return ans;
    }

    public void dfs(int restL, int restR) {
        if (restL > restR) {
            return;
        }
        if (restL == 0 && restR == 0) {
            ans.add(sb.toString());
            return;
        }
        if (restL == 0) {
            sb.append(")");
            dfs(restL, restR - 1);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (restL == restR) {
            sb.append("(");
            dfs(restL - 1, restR);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("(");
            dfs(restL - 1, restR);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(")");
            dfs(restL, restR - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_85().generateParenthesis(3));
    }
}
