package yu;

import java.util.LinkedList;
import java.util.Queue;

public class ISCBT {
    public static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(head);
        TreeNode l = null;
        TreeNode r = null;
        boolean flag = false;//有没有遇到过儿女不双全的节点
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
