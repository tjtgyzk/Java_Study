package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

public class OfferII_51 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }

    //返回以该节点为头结点的最大链(不作为拐点)
    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(0, process(root.left));
        int rightGain = Math.max(0, process(root.right));
        int curGain = root.val + Math.max(leftGain, rightGain);
        //以当前节点为拐点的最大值
        max = Math.max(max, leftGain + root.val + rightGain);
        return curGain;
    }
}
