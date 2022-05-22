package LeetCode;

import java.util.*;

public class L1305 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root1 != null) {
            queue.add(root1);
        }
        if (root2 != null) {
            queue.add(root2);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        Collections.sort(result);
        return result;
    }
}
