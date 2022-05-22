package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.*;

public class Offer32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //用一个符号标记这一行是从左到右遍历还是从右到左
        //如果是从右到左,则把答案逆序再加入结果
        boolean leftToRight = true;
        TreeNode thisEnd = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        que.add(root);
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
                if (!leftToRight) {
                    Collections.reverse(curList);
                }
                ans.add(curList);
                curList = new ArrayList<>();
                thisEnd = nextEnd;
                leftToRight = !leftToRight;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        new Offer32_III().levelOrder(root);
    }
}
