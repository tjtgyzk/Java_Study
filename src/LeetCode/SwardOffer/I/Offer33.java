package LeetCode.SwardOffer.I;

import java.util.Deque;
import java.util.LinkedList;

public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        //可以定位出左|右|头分别的范围,然后递归解决
        //单调栈解法:
        //后序遍历的逆序->头|右|左, 遍历该数组
        //对于arr[i],它一定是某个祖先节点的左子树,(将整棵树看为根节点为正无穷的树的左子树),故必须有arr[i] < root
        //如果arr[i+1]>arr[i],则arr[i+1]一定是arr[i]的右子树
        //如果arr[i+1]<arr[i],则arr[i+1]是arr[0]到arr[i]中某个节点的左子树,这个节点是arr[0-i]中大于它的节点中最小的那个节点
        //找到这个节点arr[r],则该节点当前状态为某个祖先节点的右子树状态,或者为该树的头节点,之后遍历的节点都为该节点的左子树上的节点,或该节点的祖先节点的左子树上的节点,故将root更新为arr[r]
        //如果整个数组都满足以上条件,则判定为true
        if (postorder.length == 0) {
            return true;
        }
        Deque<Integer> stack = new LinkedList<>();
        int n = postorder.length;
        int root = Integer.MAX_VALUE;
        stack.push(postorder[n - 1]);
        for (int i = n - 1; i >= 1; i--) {
            if (postorder[i - 1] > root) {
                return false;
            }
            if (stack.isEmpty() || postorder[i - 1] > postorder[i]) {
                stack.push(postorder[i - 1]);
            } else {
                while (!stack.isEmpty() && stack.peek() > postorder[i - 1]) {
                    root = stack.pop();
                }
                stack.push(postorder[i - 1]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Offer33().verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61});
    }
}
