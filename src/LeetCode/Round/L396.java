package LeetCode.Round;

public class L396 {
    public int maxRotateFunction(int[] nums) {
        //方法一:暴力(O(N^2)),别放进去跑,会超时的
        //已知顺时针旋转即为右移
        //所求即为:顺序的让[0,n-1]从不同的位置为头的序列然后求和,结果的最大值
        //所以我们让nums[0]到nums[n-1]分别做头,求最大值即可
        int n = nums.length;
        //ans可能为负,所以取int最小值
        int ans = Integer.MIN_VALUE;
        //从0到n-1做头
        for (int i = 0; i < n; i++) {
            int cursum = 0;
            //也是n-1个数,j对n取余即可得到对应下标
            for (int j = i; j < i + n; j++) {
                //系数为0,1,2...,n-1
                cursum += (j - i) * nums[j % n];
            }
            ans = Math.max(ans, cursum);
        }
        return ans;
    }

    public int maxRotateFunction2(int[] nums) {
        //方法二:又是找规律题,麻了
        /**
         * 把数组逆转跟把乘数逆转是一样的，可以看出有如下规律
         *   4     3     2     6
         *  每一次相比于上一次,多出来n-1个上一次为0的数,其他数都少了1, 也就是F(1) = F(0) - (sum(data) - data[0]) + (n - 1) * data[0];
         *  整理一下: 得到 F(1) = F(0) - SUM(data) + N * data[0];
         *
         *  0*4   1*3   2*2   3*6   F(0)
         *
         *  3*4   0*3   1*2   2*6   F(1) = F(0) - SUM(data) + N * data[0];
         *
         *  2*4   3*3   0*2   1*6   F(2) = F(1) - SUM(data) + N * data[1];
         *
         *  1*4   2*3   3*2   0*6   F(3) = F(2) - SUM(data) + N * data[2];
         *
         *  得到通项公式
         *  F(n) = F(n-1) - SUM(data) + N * data[n-1];
         *
         */
        int n = nums.length;
        int lastF = 0;
        int sum = 0;
        //遍历数组,求出F(0)和sum
        for (int i = 0; i < n; i++) {
            lastF += i * nums[i];
            sum += nums[i];
        }
        int ans = lastF;
        //从F(1)求到F(n),找出最大
        for (int i = 1; i <= n; i++) {
            lastF += n * nums[i - 1] - sum;
            ans = Math.max(ans, lastF);
        }
        return ans;
    }
}
