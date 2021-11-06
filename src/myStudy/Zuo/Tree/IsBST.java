package myStudy.Zuo.Tree;

import java.util.ArrayList;

public class IsBST {
    public static class Info {
        public boolean isBSTree;
        public int max;
        public int min;

        public Info(boolean isBSTree, int max, int min) {
            this.isBSTree = isBSTree;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isBST(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isBSTree;
    }

    public static Info process(TreeNode x) {
        if (x == null) {//不知道如何设置，就先返回空，在上游设置
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        //接下来要考虑Info是空的情况
        int max = x.value;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
        }
        int min = x.value;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
        }
        boolean isBSTree = true;//假设它成立，设置不成立的条件。记得考虑Info为null的情况
        if (leftInfo != null && leftInfo.isBSTree == false) {
            isBSTree = false;
        }
        if (rightInfo != null && rightInfo.isBSTree == false) {
            isBSTree = false;
        }
        if (leftInfo != null && leftInfo.max >= x.value) {
            isBSTree = false;
        }
        if (rightInfo != null && rightInfo.min <= x.value) {
            isBSTree = false;
        }
        return new Info(isBSTree, max, min);
    }

//    //对数器部分
//    public static boolean isBST1(TreeNode head) {
//        if (head == null) {
//            return true;
//        }
//        ArrayList<TreeNode> arr = new ArrayList<>();
//        in(head, arr);
//        for (int i = 1; i < arr.size(); i++) {
//            if (arr.get(i).value <= arr.get(i - 1).value) {
//                return false;
//            }
//        }
//        return true;
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
//        int testTimes = 1000000;
//        for (int i = 0; i < testTimes; i++) {
//            TreeNode head = generateRandomBST(maxLevel, maxValue);
//            if (isBST1(head) != isBST(head)) {
//                System.out.println("Oops!");
//            }
//        }
//        System.out.println("finish!");
//    }

}
