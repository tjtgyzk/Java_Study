package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferII_84 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] used = new int[nums.length];
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 1) {
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
