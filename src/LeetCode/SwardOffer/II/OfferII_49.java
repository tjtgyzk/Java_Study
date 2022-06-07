package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.*;

public class OfferII_49 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        Map<TreeNode, String> map = new HashMap<>();
        que.add(root);
        map.put(root, String.valueOf(root.val));
        int ans = 0;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.left != null) {
                que.add(cur.left);
                map.put(cur.left, map.get(cur) + cur.left.val);
            }
            if (cur.right != null) {
                que.add(cur.right);
                map.put(cur.right, map.get(cur) + cur.right.val);
            }
            if (cur.left == null && cur.right == null) {
                ans += Integer.parseInt(map.get(cur));
            }
        }
        return ans;
    }
}
