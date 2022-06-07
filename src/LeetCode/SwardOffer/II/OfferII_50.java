package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class OfferII_50 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        //一直走到根节点,初始前缀和为0
        map.put(0, 1);
        return dfs(root, targetSum, 0, map);
    }

    /**
     * @param root
     * @param targetSum
     * @param curSum    当前路径到该节点的前缀和
     * @param map       key:前缀和 value:该key出现的次数
     * @return 以当前节点为头结点的满足条件的路径数
     */
    public int dfs(TreeNode root, int targetSum, int curSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        //不往后遍历,以该节点为终点,之前走过的路径满足的路径个数
        int ans = map.getOrDefault(curSum - targetSum, 0);
        //加上该节点的数据
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        //加上以该节点左子树和右子树为终点的答案
        ans += dfs(root.left, targetSum, curSum, map);
        ans += dfs(root.right, targetSum, curSum, map);
        //恢复现场,防止遍历另一条不相关的路径时有数据干扰
        map.put(curSum, map.get(curSum) - 1);
        return ans;
    }
}
