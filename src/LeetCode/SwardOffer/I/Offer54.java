package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

public class Offer54 {
    int times;
    int res;

    public int kthLargest(TreeNode root, int k) {
        //按照右头左的顺序遍历,得到一个从大到小的数组,第k个即为所求
        times = k;
        process(root);
        return res;
    }

    public void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.right);
        if (times-- > 0) {
            res = root.val;
        } else {
            return;
        }
        process(root.left);
    }
}
