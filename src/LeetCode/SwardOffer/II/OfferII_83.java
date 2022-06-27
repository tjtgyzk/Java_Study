package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.List;

public class OfferII_83 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        dfs(nums, used);
        return ans;
    }

    public void dfs(int[] nums, int[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = 1;
            dfs(nums, used);
            used[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

}
