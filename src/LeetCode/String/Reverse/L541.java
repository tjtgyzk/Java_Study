package LeetCode.String.Reverse;

public class L541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            //每次取到每组的第一个点
            //如果该组长度小于k,则全部翻转,如果该组长度大于k,则翻转前k个
            int l = i;
            int r = l + Math.min(k, n - 1 - i) - 1;
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
}
