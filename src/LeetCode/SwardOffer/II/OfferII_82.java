package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferII_82 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //同层递归中,相同数字得到的结果相同
        Arrays.sort(candidates);

        dfs(candidates, target, 0);
        return ans;
    }

    public void dfs(int[] candidates, int rest, int index) {
        if (rest == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            //剪枝1:如果当前数字就大于rest,后面数字都会大于rest,均不满足
            if (candidates[index] > rest) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            //注意这里是i+1不是index+1
            dfs(candidates, rest - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new OfferII_82().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
