package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class OfferII_45 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode curEnd = root;
        TreeNode nextEnd = root;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            //先右后左,最后的curEnd即为所求
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur == curEnd) {
                curEnd = nextEnd;
            }
        }
        return curEnd.val;
    }
}
