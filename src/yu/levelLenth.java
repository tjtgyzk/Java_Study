package yu;

import myStudy.Zuo.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class levelLenth {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        System.out.println(getMax(head));
    }

    public static int getMax(TreeNode head) {
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        int max = 0;
        int length = 0;
        que.add(head);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            length++;
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                max = Math.max(max, length);
                length = 0;
                curEnd = nextEnd;
            }
        }
        return max;

    }
}
