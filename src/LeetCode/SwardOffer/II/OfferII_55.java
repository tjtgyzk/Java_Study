package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class OfferII_55 {
    class BSTIterator {
        Deque<TreeNode> list;

        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            inner(root, list);
        }

        public void inner(TreeNode root, Deque<TreeNode> list) {
            if (root == null) {
                return;
            }
            inner(root.left, list);
            list.add(root);
            inner(root.right, list);
        }

        public int next() {
            return list.pollFirst().val;
        }

        public boolean hasNext() {
            return list.size() > 0;
        }
    }
}
