package LeetCode;

public class L944 {
    public int minDeletionSize(String[] strs) {
        int num = strs.length;
        int charNum = strs[0].length();
        int ans = 0;
        for (int i = 0; i < charNum; i++) {
            for (int j = 0; j < num - 1; j++) {
                if (strs[j].charAt(i) - strs[j + 1].charAt(i) > 0) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
