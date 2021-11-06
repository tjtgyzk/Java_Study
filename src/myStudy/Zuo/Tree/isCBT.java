package myStudy.Zuo.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class isCBT {
    public static boolean isWanTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(head);
        TreeNode l = null;
        TreeNode r = null;
        boolean flag = false;
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            l = cur.left;
            r = cur.right;
            if ((l == null && r != null) || (flag && (l != null || r != null))) {
                return false;
            }
            if (l != null) {
                que.add(l);
            }
            if (r != null) {
                que.add(r);
            }
            if (l == null || r == null) {
                flag = true;
            }
        }
        return true;
    }
}
