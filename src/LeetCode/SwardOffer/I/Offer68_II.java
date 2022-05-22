package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

public class Offer68_II {
    public class Info {
        public boolean findP;
        public boolean findQ;
        public TreeNode parent;

        public Info(boolean findP, boolean findQ, TreeNode parent) {
            this.findP = findP;
            this.findQ = findQ;
            this.parent = parent;
        }
    }

    TreeNode p;
    TreeNode q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return process(root).parent;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        TreeNode parent = null;
        boolean findP = false;
        boolean findQ = false;
        if (leftInfo.parent != null) {
            parent = leftInfo.parent;
            return new Info(true, true, parent);
        }
        if (rightInfo.parent != null) {
            parent = rightInfo.parent;
            return new Info(true, true, parent);
        }
        if (leftInfo.findP || rightInfo.findP || root == p) {
            findP = true;
        }
        if ((leftInfo.findQ || rightInfo.findQ || root == q)) {
            findQ = true;
        }
        if (findP && findQ) {
            parent = root;
        }
        return new Info(findP, findQ, parent);
    }
}
