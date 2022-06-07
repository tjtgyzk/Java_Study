package LeetCode;

import LeetCode.SwardOffer.TreeNode;

public class L1022 {
    int ans;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur = (cur << 1) | root.val;
        if (root.left == null && root.right == null) {
            ans += cur;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
