package myStudy.Zuo.Tree;

import java.util.ArrayList;

public class MaxSubBSTSize {
    public static class Info {
        public boolean isBST;
        public int size;
        public int max;
        public int min;
        public int maxSubBSTSize;

        public Info(boolean isBST, int size, int max, int min, int maxSubBSTSize) {
            this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
            this.maxSubBSTSize = maxSubBSTSize;
        }
    }

    public static int getMax(TreeNode head) {
        return process(head).maxSubBSTSize;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int max = x.value;
        max = Math.max(max, leftInfo.max);
        max = Math.max(max, rightInfo.max);
        int min = x.value;
        min = Math.min(min, leftInfo.min);
        min = Math.min(min, rightInfo.min);
        boolean isBST = true;
        if ((leftInfo.isBST == false) || (rightInfo.isBST == false)) {
            isBST = false;
        }
        if ((leftInfo.max >= x.value) || (rightInfo.min <= x.value)) {
            isBST = false;
        }
        int maxSubBSTSize = 0;
        if (isBST) {
            maxSubBSTSize = size;
        } else {
            maxSubBSTSize = Math.max(leftInfo.maxSubBSTSize, rightInfo.maxSubBSTSize);
        }
        return new Info(isBST, size, max, min, maxSubBSTSize);
    }
//    //对数器
//    public static int getBSTSize(TreeNode head) {
//        if (head == null) {
//            return 0;
//        }
//        ArrayList<TreeNode> arr = new ArrayList<>();
//        in(head, arr);
//        for (int i = 1; i < arr.size(); i++) {
//            if (arr.get(i).value <= arr.get(i - 1).value) {
//                return 0;
//            }
//        }
//        return arr.size();
//    }
//
//    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
//        if (head == null) {
//            return;
//        }
//        in(head.left, arr);
//        arr.add(head);
//        in(head.right, arr);
//    }
//
//    public static int maxSubBSTSize1(TreeNode head) {
//        if (head == null) {
//            return 0;
//        }
//        int h = getBSTSize(head);
//        if (h != 0) {
//            return h;
//        }
//        return Math.max(maxSubBSTSize1(head.left), maxSubBSTSize1(head.right));
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
//        int maxLevel = 4;
//        int maxValue = 100;
//        int testTimes = 10000000;
//        for (int i = 0; i < testTimes; i++) {
//            TreeNode head = generateRandomBST(maxLevel, maxValue);
//            if (maxSubBSTSize1(head) != getMax(head)) {
//                System.out.println("Oops!");
//
//            }
//        }
//        System.out.println("finish!");
//    }

}
