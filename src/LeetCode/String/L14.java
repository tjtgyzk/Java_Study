package LeetCode.String;

public class L14 {
    public static String longestCommonPrefix(String[] strs) {
        //分别对比前一个和后一个的最长公共前缀,遍历完即得到结果
        String both = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(strs[i].length(), both.length());
            if (length == 0) {
                return "";
            }
            //更新成更短的那个长度,注意这里若长度为4,想留0-4不能用length-1,要用length
            both = both.substring(0, length);
            for (int j = 0; j < length; j++) {
                if (both.charAt(j) != strs[i].charAt(j)) {
                    both = both.substring(0, j);
                    break;
                }
            }
        }
        return both;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }
}
