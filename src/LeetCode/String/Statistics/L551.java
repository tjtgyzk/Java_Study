package LeetCode.String.Statistics;

public class L551 {
    public boolean checkRecord(String s) {
        int ATimes = s.charAt(0) == 'A' ? 1 : 0;
        int LConstant = s.charAt(0) == 'L' ? 1 : 0;
        int maxL = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                ATimes++;
            } else if (c == 'L') {
                LConstant++;
                continue;
            }
            maxL = Math.max(maxL, LConstant);
            LConstant = 0;
        }
        maxL = Math.max(maxL, LConstant);
        return (ATimes < 2) && (maxL < 3);
    }
}
