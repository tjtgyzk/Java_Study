package LeetCode.String.Reverse;

public class L151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        int begin = s.length() - 1;
        //注意s只有一个字母的特殊情况
        while (begin >= 0) {
            //找到单词的最后一个位置,跳过中间的空格
            while (end > 0 && s.charAt(end) == ' ') {
                end--;
            }
            //从单词的最后一个位置向前遍历,直到前一个为空格,确认单词起止点
            begin = end;
            while (begin > 0 && s.charAt(begin - 1) != ' ') {
                begin--;
            }
            //边界判断,begin和end都会停在0,此时需判断0处是空格还是单独一个字母
            if (begin == 0 && s.charAt(0) == ' ') {
                break;
            }
            //删除最后一个多余的空格
            sb.append(s.substring(begin, end + 1) + ' ');
            end = begin - 1;
            //此处必须更新begin,用于最外层while判断
            begin = end;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        new L151().reverseWords("a");
    }
}
