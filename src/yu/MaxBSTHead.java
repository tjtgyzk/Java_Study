package yu;

import java.util.ArrayList;

public class MaxBSTHead {
    public static class Info {
        public boolean isBST;
        public int max;
        public int min;
        public int maxBSTSize;
        //public int size;
        public TreeNode maxBSTHead;

        public Info(boolean isBST, int max, int min, int maxBSTSize, TreeNode maxBSTHead) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.maxBSTSize = maxBSTSize;
            this.maxBSTHead = maxBSTHead;
        }
    }

    public static TreeNode getHead(TreeNode head) {
        return process(head).maxBSTHead;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, null);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.value;
        max = Math.max(max, leftInfo.max);
        max = Math.max(max, rightInfo.max);
        int min = x.value;
        min = Math.min(min, leftInfo.min);
        min = Math.min(min, rightInfo.min);
        boolean isBST = (leftInfo.isBST && rightInfo.isBST) ? ((leftInfo.max < x.value) && (rightInfo.min > x.value)) : false;
        TreeNode maxBSTHead;
        int maxBSTSize;
        if (isBST) {
            maxBSTHead = x;
            maxBSTSize = leftInfo.maxBSTSize + rightInfo.maxBSTSize + 1;
        } else {
            maxBSTSize = (leftInfo.maxBSTSize >= rightInfo.maxBSTSize) ? leftInfo.maxBSTSize : rightInfo.maxBSTSize;
            maxBSTHead = (leftInfo.maxBSTSize >= rightInfo.maxBSTSize) ? leftInfo.maxBSTHead : rightInfo.maxBSTHead;
        }
        return new Info(isBST, max, min, maxBSTSize, maxBSTHead);
    }

    //对数器
    public static int getBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static TreeNode maxSubBSTHead1(TreeNode head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        TreeNode leftAns = maxSubBSTHead1(head.left);
        TreeNode rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != getHead(head)) {
                PrintTree.print(head);
                TreeNode a1 = maxSubBSTHead1(head);
                TreeNode a2 = getHead(head);
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
