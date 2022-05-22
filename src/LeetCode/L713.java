package LeetCode;

public class L713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //维护一个窗口[L,...,R],每次右移R直到不满足条件的第一个为止
        //当前满足条件的以L开头的子数组共有R-L个
        //L从0一直到n-1,累加计算一共有多少个子数组满足
        int R = 0;
        int res = 0;
        int cur = 1;
        for (int L = 0; L < nums.length; L++) {
            while (R < nums.length && cur * nums[R] < k) {
                cur *= nums[R++];
            }
            //如果nums[L]本身大于k,则左右指针一起右移
            if (L == R) {
                R++;
                continue;
            }
            res += R - L;
            cur /= nums[L];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L713().numSubarrayProductLessThanK(new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22}, 18));
    }
}
