package LeetCode.SwardOffer.I;

import java.util.HashMap;

public class Offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //使用哈希表快速定位中序遍历中的头节点位置
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序遍历:头-左-右
        //中序遍历:左-头-右
        //故可以通过前序遍历,获取当前树的头节点,通过在中序遍历中定位头节点,可以得到左子树和右子树的大小,进而可以在前序遍历中区分出左右子树
        //对于左右子树,也是同样的操作,所以可以通过递归实现
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int n = preorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return process(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    public TreeNode process(int[] preorder, int[] inorder, int beginPre, int endPre, int beginIn, int endIn) {
        if (beginPre > endPre) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[beginPre]);
        int headIndex = map.get(head.val);
        int leftLenth = headIndex - beginIn;
        int rightLenth = endIn - headIndex;
        head.left = process(preorder, inorder, beginPre + 1, beginPre + leftLenth, beginIn, headIndex - 1);
        head.right = process(preorder, inorder, beginPre + leftLenth + 1, endPre, headIndex + 1, endIn);
        return head;
    }
}
