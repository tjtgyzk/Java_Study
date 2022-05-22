package LeetCode.SwardOffer.II;

public class OfferII_06 {
    public int[] twoSum(int[] numbers, int target) {
        //如果最小加最大>target,最大左移一位
        //如果<target,则最小右移一位
        //如果相等,直接返回
        if (numbers.length == 0 || numbers.length == 1) {
            return new int[]{};
        }
        int l = 0;

        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) {
                l++;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{};
    }
}
