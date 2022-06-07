package LeetCode;

public class L829 {
    public int consecutiveNumbersSum(int n) {
        //连续k个正整数之和最小为(1+k)*k/2,所以n>=(1+k)*k/2,k(k+1)<=2n,遍历这些k即可
        //假设是从[x,y]累加,一共k个数,y=x+k-1,故n = k(x+y)/2 = k(2x+k-1)/2
        //当k为奇数时,k-1为偶数,所以n = k(2x+k-1)/2 = kq,n能被k整除
        //当k为偶数时,n = k(2x+k-1)/2, n/k = (2x+k-1)/2 是个小数,n不能被k整除,但2n可以被k整除
        int k = 1;
        int ans = 0;
        while (k * (k + 1) <= 2 * n) {
            if (k % 2 == 0) {
                if (n % k != 0 && 2 * n % k == 0) {
                    ans++;
                }
            } else {
                if (n % k == 0) {
                    ans++;
                }
            }
            k++;
        }
        return ans;
    }
}
