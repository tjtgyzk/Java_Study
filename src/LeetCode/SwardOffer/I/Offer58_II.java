package LeetCode.SwardOffer.I;


public class Offer58_II {
    public String reverseLeftWords(String s, int n) {
        //-->---->
        //翻转
        //<----<--
        //分别翻转前n-k个和后k个
        //---->-->
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - n - 1);
        reverse(chars, chars.length - n, chars.length - 1);
        return String.valueOf(chars);

//        //不要脸做法
//        return s.substring(n) + s.substring(0, n);

    }

    public void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
