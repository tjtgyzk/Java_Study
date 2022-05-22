package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //递归:
        if (A == null || B == null) {
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(A);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (process(cur, B)) {
                return true;
            }
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        return false;
    }

    //在A与B相等时.判断B是否是A的子结构
    public boolean process(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return process(A.left, B.left) && process(A.right, B.right);
    }

    public boolean function(TreeNode A, TreeNode B) {
        //迭代
        if (A == null || B == null) {
            return false;
        }
        //按层遍历
        Queue<TreeNode> queA = new LinkedList<>();
        queA.offer(A);
        boolean ans = false;
        while (!queA.isEmpty()) {
            TreeNode curA = queA.poll();
            if (curA.val == B.val) {
                //判断是否为子结构
                Queue<TreeNode> queB = new LinkedList<>();
                queB.offer(B);
                queB.offer(curA);
                boolean curAns = true;
                while (!queB.isEmpty()) {
                    TreeNode curB = queB.poll();
                    TreeNode nowA = queB.poll();
                    if (nowA == null || nowA.val != curB.val) {
                        curAns = false;
                        break;
                    }
                    if (curB.left != null) {
                        queB.offer(curB.left);
                        queB.offer(nowA.left);
                    }
                    if (curB.right != null) {
                        queB.offer(curB.right);
                        queB.offer(nowA.right);
                    }
                }
                ans |= curAns;
            }
            if (curA.left != null) {
                queA.offer(curA.left);
            }
            if (curA.right != null) {
                queA.offer(curA.right);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(10);
        A.left = new TreeNode(12);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);

        TreeNode B = new TreeNode(10);
        B.left = new TreeNode(12);
        B.right = new TreeNode(3);
        B.left.left = new TreeNode(4);

        System.out.println(new Offer26().function(A, B));

    }
}
