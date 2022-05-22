package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

public class Offer68_I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果都大于,在右子树上
        //如果都小于,在左子树上
        //如果一个大于等于一个小于等于,则就是当前root节点
        TreeNode ans = null;
        TreeNode small = Math.min(p.val, q.val) == p.val ? p : q;
        TreeNode big = small == p ? q : p;
        while (ans == null) {
            if (small.val > root.val) {
                root = root.right;
            } else if (big.val < root.val) {
                root = root.left;
            } else {
                ans = root;
            }
        }
        return ans;
    }
}
