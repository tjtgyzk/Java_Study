package yu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MaxDis {
    public static class Info {
        public int height;
        public int maxDis;

        public Info(int height, int maxDis) {
            this.height = height;
            this.maxDis = maxDis;
        }
    }

    public static int getMaxDis(TreeNode head) {
        return process(head).maxDis;
    }

    public static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        int p1 = leftInfo.height + rightInfo.height + 1;
        int p2 = leftInfo.maxDis;
        int p3 = rightInfo.maxDis;
        int maxDis = p1;
        maxDis = Math.max(maxDis, p2);
        maxDis = Math.max(maxDis, p3);
        return new Info(height, maxDis);
    }

    //对数器
    public static int maxDistance1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = getPrelist(head);
        HashMap<TreeNode, TreeNode> parentMap = getParentMap(head);
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                max = Math.max(max, distance(parentMap, arr.get(i), arr.get(j)));
            }
        }
        return max;
    }

    public static ArrayList<TreeNode> getPrelist(TreeNode head) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        fillPrelist(head, arr);
        return arr;
    }

    public static void fillPrelist(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        arr.add(head);
        fillPrelist(head.left, arr);
        fillPrelist(head.right, arr);
    }

    public static HashMap<TreeNode, TreeNode> getParentMap(TreeNode head) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        map.put(head, null);
        fillParentMap(head, map);
        return map;
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

    public static int distance(HashMap<TreeNode, TreeNode> parentMap, TreeNode o1, TreeNode o2) {
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
        TreeNode lowestAncestor = cur;
        cur = o1;
        int distance1 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance1++;
        }
        cur = o2;
        int distance2 = 1;
        while (cur != lowestAncestor) {
            cur = parentMap.get(cur);
            distance2++;
        }
        return distance1 + distance2 - 1;
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
            if (maxDistance1(head) != getMaxDis(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
