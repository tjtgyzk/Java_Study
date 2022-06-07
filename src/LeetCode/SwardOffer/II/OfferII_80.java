package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_80 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        //仿照79题,改一下dfs的basecase
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int index, int n, int k) {
        //剪枝:如果剩下的元素全都选择也不够k个,直接放弃这条路线
        if (t.size() + (n - index + 1) < k) {
            return;
        }
        //如果t中已经有k个元素,直接加入结果中
        if (t.size() == k) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(index);
        dfs(index + 1, n, k);
        t.remove(t.size() - 1);
        dfs(index + 1, n, k);
    }
}
