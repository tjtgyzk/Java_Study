package yu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FindBothParent {
    public static class Info {
        public boolean findA;
        public boolean findB;
        public TreeNode ans;

        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

    public static TreeNode getNode(TreeNode head, TreeNode a, TreeNode b) {
        return process(head, a, b).ans;
    }

    public static Info process(TreeNode x, TreeNode a, TreeNode b) {
        if (x == null) {
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);
        boolean findA = false;
        boolean findB = false;
        TreeNode ans = null;
        //不在x上
        //1.在x之前相遇了
        if (leftInfo.ans != null) {
            ans = leftInfo.ans;
            return new Info(true, true, ans);
        }
        if (rightInfo.ans != null) {
            ans = rightInfo.ans;
            return new Info(true, true, ans);
        }
        //在x以前没相遇
        if (leftInfo.findA || rightInfo.findA || (x == a)) {
            findA = true;
        }
        if (leftInfo.findB || rightInfo.findB || (x == b)) {
            findB = true;
        }
        //设置ans
        if (findA && findB) {
            ans = x;
        }
        return new Info(findA, findB, ans);
    }

    //对数器
    public static TreeNode lowestAncestor1(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null) {
            return null;
        }
        // key的父节点是value
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(head, null);
        fillParentMap(head, parentMap);
        HashSet<TreeNode> o1Set = new HashSet<>();
        TreeNode cur = o1;
        o1Set.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            o1Set.add(cur);
        }
        cur = o2;
        while (!o1Set.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void fillParentMap(TreeNode head, HashMap<TreeNode, TreeNode> parentMap) {
        if (head.left != null) {
            parentMap.put(head.left, head);
            fillParentMap(head.left, parentMap);
        }
        if (head.right != null) {
            parentMap.put(head.right, head);
            fillParentMap(head.right, parentMap);
        }
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

    // for test
    public static TreeNode pickRandomOne(TreeNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        fillPrelist(head, arr);
        int randomIndex = (int) (Math.random() * arr.size());
        return arr.get(randomIndex);
    }

    // for test
    public static void fillPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            TreeNode o1 = pickRandomOne(head);
            TreeNode o2 = pickRandomOne(head);
            if (lowestAncestor1(head, o1, o2) != getNode(head, o1, o2)) {
                TreeNode a1 = lowestAncestor1(head, o1, o2);
                TreeNode a2 = getNode(head, o1, o2);
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
