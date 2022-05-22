package LeetCode;

import LeetCode.SwardOffer.TreeNode;

public class L04_06 {
    TreeNode p;
    static TreeNode ans;
    boolean findP;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.p = p;
        process(root);
        return ans;
    }

    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        if (findP) {
            ans = root;
            findP = false;
            return;
        }
        process(root.left);
        if (findP) {
            ans = root;
            findP = false;
            return;
        }
        if (root == p) {
            findP = true;
        }
        process(root.right);
    }

    public static void main(String[] args) {
        L04_06 l04_06 = new L04_06();
        TreeNode root = new TreeNode(5);
        TreeNode p = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = p;
        root.right = new TreeNode(6);
        l04_06.inorderSuccessor(root, p);
    }
}
