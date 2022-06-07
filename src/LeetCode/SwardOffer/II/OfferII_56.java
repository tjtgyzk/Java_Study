package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class OfferII_56 {
    boolean ans = false;
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        inner(root, k);
        return ans;
    }

    public void inner(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (ans == true) {
            return;
        }
        inner(root.left, k);
        if (set.contains(k - root.val)) {
            ans = true;
            return;
        }
        set.add(root.val);
        inner(root.right, k);
    }

}
