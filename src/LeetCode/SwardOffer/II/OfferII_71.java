package LeetCode.SwardOffer.II;

import java.util.Random;

public class OfferII_71 {
    class Solution {
        //按权重生成下标
        //[1,3]即以1/4的概率生成0,3/4的概率生成1
        //也就是说把[1,3]变成[0,1,1,1],以正常概率生成[1,4]的数字index,第index-1位置的数即为要生成的下标
        //可以发现,改变后数组的长度以及落入的区间可以用前缀和表示,前缀和数组为[1,4],生成随机数index如果<=1,则返回0,如果1<index<=4,则返回1
        //即找到前缀和中第一个满足sum[x]>=index的数,可以使用二分查找
        int[] sum;
        Random ran;

        public Solution(int[] w) {
            sum = new int[w.length];
            sum[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sum[i] = sum[i - 1] + w[i];
            }
            ran = new Random();
        }

        public int pickIndex() {
            int index = ran.nextInt(sum[sum.length - 1] + 1);
            int l = 0, r = sum.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (sum[mid] < index) {
                    l = mid + 1;
                } else if (sum[mid] >= index) {
                    r = mid;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        //找到第一个>=k的数
        int k = 5;
        int[] nums = {2, 3, 4, 6, 7, 8, 9};
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < k) {
                l = mid + 1;
            } else if (nums[mid] >= k) {
                r = mid;
            }
        }
        System.out.println(nums[l]);
    }
}
