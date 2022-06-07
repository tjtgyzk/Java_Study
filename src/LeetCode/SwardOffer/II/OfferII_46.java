package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OfferII_46 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }
        TreeNode curEnd = root;
        TreeNode nextEnd = root;
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                ans.add(curEnd.val);
                curEnd = nextEnd;
            }
        }
        return ans;
    }
}
