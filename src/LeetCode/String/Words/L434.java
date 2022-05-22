package LeetCode.String.Words;

public class L434 {
    public int countSegments(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int nums = 0;
        //找到单词起始字符的个数
        //起始字符: 它不是空格且它前一个是空格
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                nums++;
            }
        }
        return nums;
    }
}
