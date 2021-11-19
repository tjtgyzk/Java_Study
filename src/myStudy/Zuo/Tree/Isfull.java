package myStudy.Zuo.Tree;

public class Isfull {
    public static class Info {
        public int height;
        public int size;

        public Info(int height, int size) {
            this.height = height;
            this.size = size;
        }
    }

    public static boolean isFull(TreeNode head) {
        if (head == null) {
            return true;
        }
        Info all = process(head);
        return (1 << all.height) - 1 == all.size;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int size = leftInfo.size + rightInfo.size + 1;
        return new Info(height, size);

    }
//    //对数器
//    public static boolean isFull1(TreeNode head) {
//        if (head == null) {
//            return true;
//        }
//        int height = h(head);
//        int nodes = n(head);
//        return (1 << height) - 1 == nodes;
//    }
//
//    public static int h(TreeNode head) {
//        if (head == null) {
//            return 0;
//        }
//        return Math.max(h(head.left), h(head.right)) + 1;
//    }
//
//    public static int n(TreeNode head) {
//        if (head == null) {
//            return 0;
//        }
//        return n(head.left) + n(head.right) + 1;
//    }
//    // for test
//    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
//        return generate(1, maxLevel, maxValue);
//    }
//
//    // for test
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
//            if (isFull1(head) != isFull(head)) {
//                System.out.println("Oops!");
//            }
//        }
//        System.out.println("finish!");
//    }
}
