package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        //此题为求头节点的两个子树是否为镜像对称
        //镜像对称:第一个节点的左子树与第二个节点的右子树镜像对称,同理节点1的右子树与节点2的左子树镜像对称,且这两个节点值相等
        if (root == null) {
            return true;
        }
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && mirror(root1.left, root2.right) && mirror(root1.right, root2.left);
    }

    public boolean function(TreeNode root) {
        //迭代版:每次弹出两个节点,先放入第一个节点的左和第二个节点的右,再放入第一个节点的右和第二个节点的左
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        while (!que.isEmpty()) {
            TreeNode cur1 = que.poll();
            TreeNode cur2 = que.poll();
            if (cur1 == null && cur2 == null) {
                continue;
            }
            if (cur1 == null || cur2 == null) {
                return false;
            }
            if (cur1.val != cur2.val) {
                return false;
            }
            que.add(cur1.left);
            que.add(cur2.right);
            que.add(cur1.right);
            que.add(cur2.left);
        }
        return true;
    }
}
