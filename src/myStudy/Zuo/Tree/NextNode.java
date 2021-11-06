package myStudy.Zuo.Tree;

public class NextNode {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        head1.right = new TreeNode(3);
        head1.left.left = new TreeNode(4);
        head1.left.right = new TreeNode(5);
        head1.right.left = new TreeNode(6);
        head1.right.right = new TreeNode(7);
        head1.left.parent = head1;
        head1.right.parent = head1;
        head1.left.left.parent = head1.left;
        head1.left.right.parent = head1.left;
        head1.right.left.parent = head1.right;
        head1.right.right.parent = head1.right;

        myStudy.Zuo.Tree.TreeNode head = new myStudy.Zuo.Tree.TreeNode(1);
        head.left = new myStudy.Zuo.Tree.TreeNode(2);
        head.right = new myStudy.Zuo.Tree.TreeNode(3);
        head.left.left = new myStudy.Zuo.Tree.TreeNode(4);
        head.left.right = new myStudy.Zuo.Tree.TreeNode(5);
        head.right.left = new myStudy.Zuo.Tree.TreeNode(6);
        head.right.right = new myStudy.Zuo.Tree.TreeNode(7);
        TreeBasic.in(head);
        System.out.println();
        System.out.println(getNext(head1).value);
        System.out.println(getNext(head1.left).value);
        System.out.println(getNext(head1.right).value);
        System.out.println(getNext(head1.left.left).value);
        System.out.println(getNext(head1.left.right).value);
        System.out.println(getNext(head1.right.right).value);

    }

    //求中序遍历下的后继节点
    public static TreeNode getNext(TreeNode node) {
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        TreeNode parent = node.parent;
        while (parent != null) {
            if (parent.left == node) {
                return parent;
            }
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    public static TreeNode getLeftMost(TreeNode head) {
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }
}
