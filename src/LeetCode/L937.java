package LeetCode;

import java.util.Arrays;

public class L937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] log1 = o1.split(" ", 2);
            String[] log2 = o2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
            if (isDigit1 && isDigit2) {
                return 0;
            }
            if (!isDigit1 && !isDigit2) {
                return log1[1].compareTo(log2[1]) == 0 ? log1[0].compareTo(log2[0]) : log1[1].compareTo(log2[1]);
            }
            if (!isDigit1 && isDigit2) {
                return -1;
            }
            if (isDigit1 && !isDigit2) {
                return 1;
            }
            return 0;
        });
        return logs;
    }
}
