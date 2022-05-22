package LeetCode.String.Reverse;

public class L557 {
    public String reverseWords(String s) {
        int begin = 0, end = 0;
        char[] chars = s.toCharArray();
        while (end < chars.length - 1) {
            while (end != chars.length - 1 && chars[end + 1] != ' ') {
                end++;
            }
            int r = end;
            int l = begin;
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            begin = end + 2;
            end += 2;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new L557().reverseWords("Let's take LeetCode contest");
    }
}
