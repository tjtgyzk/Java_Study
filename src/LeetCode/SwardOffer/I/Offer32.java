package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            list.add(cur.val);
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
