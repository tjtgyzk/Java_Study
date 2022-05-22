package LeetCode;

public class L668 {
    public int findKthNumber(int m, int n, int k) {
        // 二分查找,l初始为0,r初始为m*n
        // 每次循环统计矩阵中小于等于mid的元素个数,矩阵中i,j位置的元素值为i*j
        // mid/n = 行数i,小于等于行数i的每行全部元素都小于等于mid,所以可以将count初始为m/n * n,从第m/n + 1行开始计算
        // 对于第i行,mid/i 即可以得到该行小于等于mid的总数(得到j的下标,则小于等于mid的共有j个)
        // 假如count==k,也不代表找到了真正的元素
        // 比如
        // 1  2  3
        // 2  4  6
        // 3  6  9  中,6,7,8均符合k=8,但7和8不在表中
        // 所以此时不应该结束循环,而是将r缩短,直到l==r时取到满足条件的最小数,则一定存在于表中
        int l = 0, r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = mid / n * n;
            for (int i = mid / n + 1; i <= m; i++) {
                count += mid / i;
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
