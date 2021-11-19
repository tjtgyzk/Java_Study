package yu;

import static yu.ISCBT.isCBT;

public class IsCBT2 {
    public static class Info {
        public boolean isCBT;
        public boolean isFull;
        public int height;

        public Info(boolean isCBT, boolean isFull, int height) {
            this.isCBT = isCBT;
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isCBT2(TreeNode head) {
        return process(head).isCBT;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && (leftInfo.height == rightInfo.height);
        boolean isCBT = false;
        if ((leftInfo.height == rightInfo.height) && (leftInfo.isFull && (rightInfo.isFull || rightInfo.isCBT))) {
            isCBT = true;
        }
        if ((leftInfo.height - rightInfo.height == 1) && (rightInfo.isFull && (leftInfo.isFull || leftInfo.isCBT))) {
            isCBT = true;
        }
        return new Info(isCBT, isFull, height);


    }

    //对数器
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
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 10000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isCBT(head) != isCBT2(head)) {
                PrintTree.print(head);
                boolean p1 = isCBT(head);
                boolean p2 = isCBT2(head);
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
