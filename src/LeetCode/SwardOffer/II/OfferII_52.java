package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class OfferII_52 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inner(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }

    public void inner(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inner(root.left, list);
        list.add(root);
        inner(root.right, list);
    }
}
