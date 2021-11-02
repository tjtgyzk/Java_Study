package myStudy.Zuo.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> midAns = new LinkedList<>();
        que.add(root);
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            midAns.add(cur.value);
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                List<Integer> list = new LinkedList<>();
                for (Integer i : midAns) {
                    list.add(i);
                }
                ans.add(list);
                midAns.clear();
                curEnd = nextEnd;
            }
        }
        return ans;
    }
}
