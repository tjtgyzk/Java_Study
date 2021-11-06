package myStudy.Zuo.Tree;



import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBasic {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pre1(head);
        System.out.println();
        in1(head);
        System.out.println();
        pos1(head);
        System.out.println();
        level(head);
        PrintTree.print(head);
        System.out.println(levelNumber(head));
    }

    //递归版前序中序后序遍历
    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(TreeNode head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }

    //非递归版前序中序后序遍历
    public static void pre1(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void in1(TreeNode head) {
        TreeNode cur = head;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    public static void pos1(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> res = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop().value + " ");
        }
    }

    //按层遍历
    public static void level(TreeNode head) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(head);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
    }

    //按层遍历，返回最宽层的节点数量
    public static int levelNumber(TreeNode head) {
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        int max = 0;
        int curNum = 0;
        que.add(head);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            curNum++;
            if (cur.left != null) {
                que.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                que.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd) {
                max = Math.max(max, curNum);
                curNum = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }


}
