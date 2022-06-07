package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

public class OfferII_54 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        //中序反向遍历,维护sum值,每个节点值变成sum值
        inner(root);
        return root;
    }

    public void inner(TreeNode root) {
        if (root == null) {
            return;
        }
        inner(root.right);
        sum += root.val;
        root.val = sum;
        inner(root.left);
    }
}
