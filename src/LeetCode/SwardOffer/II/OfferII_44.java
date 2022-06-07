package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OfferII_44 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        int curMax = Integer.MIN_VALUE;
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            curMax = Math.max(curMax, cur.val);
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                ans.add(curMax);
                curMax = Integer.MIN_VALUE;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }
        return ans;
    }
}
