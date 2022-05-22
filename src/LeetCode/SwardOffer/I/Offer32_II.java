package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        que.add(root);
        TreeNode thisEnd = root;
        TreeNode nextEnd = null;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            curList.add(cur.val);
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == thisEnd) {
                ans.add(curList);
                curList = new ArrayList<>();
                thisEnd = nextEnd;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new Offer32_II().levelOrder(root);
    }
}
