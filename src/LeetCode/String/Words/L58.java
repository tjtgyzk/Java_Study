package LeetCode.String.Words;

public class L58 {
    public int lengthOfLastWord(String s) {
        //倒着遍历字符串,找到第一个字母位置为最后一个单词,从后向前遍历该单词得到长度
        int i = s.length() - 1;
        while (!Character.isLetterOrDigit(s.charAt(i))) {
            i--;
        }
        int num = 0;
        //如果是第一个字母或者前一个字母是空格,则跳出,这里少算了当前字母,所以结果要加一
        while (i > 0 && Character.isLetterOrDigit(s.charAt(i - 1))) {
            num++;
            i--;
        }
        //
        return (i == 0 && Character.isLetterOrDigit(s.charAt(i))) ? num : num + 1;
    }
}
