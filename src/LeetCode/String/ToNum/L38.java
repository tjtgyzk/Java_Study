package LeetCode.String.ToNum;

public class L38 {
    public String countAndSay(int n) {
        //是一个递归,结果每一层都是固定的
        //具体看题解
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                ans.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        return ans.append(count).append(s.charAt(s.length() - 1)).toString();
    }
}
