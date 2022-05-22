package LeetCode.SwardOffer.I;

public class Offer66 {
    public int[] constructArr(int[] a) {
        //对于每个位置,它的值 = 它左侧所有数之积*它右侧所有数之积
        //可以两次遍历,第一次从左到右,在b[i]位置+它左侧所有数之积
        //第二次从右到左,在b[i]位置*它右侧所有数之积
        int left = 1;
        int right = 1;
        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] += left;
            left *= a[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= a[i];
        }
        return ans;
    }
}
