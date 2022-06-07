package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_81 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, int rest, int index) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        if (rest < 0 || index == candidates.length) {
            return;
        }
        //跳过当前数字
        dfs(candidates, target, rest, index + 1);
        //选择当前数字
        temp.add(candidates[index]);
        dfs(candidates, target, rest - candidates[index], index);
        temp.remove(temp.size() - 1);
    }
}
