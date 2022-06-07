package LeetCode;

public class L450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //删除需要的节点,重构二叉树,返回根节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // 递归左子树,返回左子树的delete结果
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 递归右子树,返回右子树的delete结果
            root.right = deleteNode(root.right, key);
        } else {
            //如果左子树为空,返回右子树,如果右子树为空,返回左子树
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //找到右子树的最左节点,该节点满足大于左右左子树的节点,且小于其他右子树的节点,将原来的左子树挂在其左子树上即可,返回原来的右子树作为新的根节点
            TreeNode tar = root.right;
            while (tar.left != null) {
                tar = tar.left;
            }
            tar.left = root.left;
            return root.right;
        }
        return root;
    }
}
