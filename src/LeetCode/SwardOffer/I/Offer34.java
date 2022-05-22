package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer34 {
    //注意每次递归最后要"恢复现场",即弹出这次递归中加入的节点
    Deque<Integer> que = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        process(root, target);
        return ans;
    }

    public void process(TreeNode root, int rest) {
        if (root == null) {
            return;
        }
        que.addLast(root.val);
        rest -= root.val;
        if (rest == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(que));
        }
        process(root.left, rest);
        process(root.right, rest);
        que.pollLast();
    }
}
