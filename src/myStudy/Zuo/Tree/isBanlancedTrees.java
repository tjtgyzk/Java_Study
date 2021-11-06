package myStudy.Zuo.Tree;

public class isBanlancedTrees {
    //判断是否为平衡二叉树
    public static class Info {//返回的信息类
        public boolean isBanlanced;
        public int height;

        public Info(boolean isBanlanced, int height) {
            this.isBanlanced = isBanlanced;
            this.height = height;
        }
    }

    public static boolean isBanlancedTree(TreeNode head) {
        return process(head).isBanlanced;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBanlanced = true;
        if (leftInfo.isBanlanced == false || rightInfo.isBanlanced == false) {
            isBanlanced = false;
        }
        if (Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBanlanced = false;
        }
        return new Info(isBanlanced, height);
    }
//    //对数器部分
//    public static boolean isBalance(TreeNode head) {
//        boolean[] ans = new boolean[1];
//        ans[0] = true;
//        process1(head, ans);
//        return ans[0];
//    }
//
//    public static int process1(TreeNode head, boolean[] ans) {
//        if (!ans[0] || head == null) {
//            return -1;
//        }
//        int leftHeight = process1(head.left, ans);
//        int rightHeight = process1(head.right, ans);
//        if (Math.abs(leftHeight - rightHeight) > 1) {
//            ans[0] = false;
//        }
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
//    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
//        return generate(1, maxLevel, maxValue);
//    }
//    public static TreeNode generate(int level, int maxLevel, int maxValue) {
//        if (level > maxLevel || Math.random() < 0.5) {
//            return null;
//        }
//        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
//        head.left = generate(level + 1, maxLevel, maxValue);
//        head.right = generate(level + 1, maxLevel, maxValue);
//        return head;
//    }
//
//    public static void main(String[] args) {
//        int maxLevel = 5;
//        int maxValue = 100;
//        int testTimes = 1000000;
//        for (int i = 0; i < testTimes; i++) {
//            TreeNode head = generateRandomBST(maxLevel, maxValue);
//            if (isBanlancedTree(head) != isBalance(head)) {
//                System.out.println("Oops!");
//            }
//        }
//        System.out.println("finish!");
//    }
//    //
}
