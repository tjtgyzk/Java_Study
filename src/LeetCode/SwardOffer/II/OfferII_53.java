package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

public class OfferII_53 {
    boolean findP = false;
    TreeNode ans;
    boolean getAns = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (getAns) {
            return null;
        }
        inorderSuccessor(root.left, p);
        if (findP && !getAns) {
            ans = root;
            getAns = true;
        }
        if (root == p) {
            findP = true;
        }
        inorderSuccessor(root.right, p);
        return ans;
    }
}
