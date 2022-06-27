package LeetCode.SwardOffer.II;

public class OfferII_104 {
    public int combinationSum4(int[] nums, int target) {
        //以下是去重答案
//        int n = nums.length;
//        int[][] dp = new int[n + 1][target + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
//        for (int index = n - 1; index >= 0; index--) {
//            for (int rest = 1; rest <= target; rest++) {
////                for (int pieces = 0; pieces * nums[index] <= rest; pieces++) {
////                    dp[index][rest] += dp[index + 1][rest - pieces * nums[index]];
////                }
//                //观察上面for循环,发现依赖其下方左侧数之和,所以可以用其左侧数+下方数求得
//                dp[index][rest] = dp[index + 1][rest];
//                if (rest >= nums[index]) {
//                    dp[index][rest] += dp[index][rest - nums[index]];
//                }
//            }
//        }
//        return dp[0][target];
        //此题不需要去重,以下是原答案
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int rest = 1; rest <= target; rest++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > rest) {
                    continue;
                }
                dp[rest] += dp[rest - nums[i]];
            }
        }
        return dp[target];
    }
}
