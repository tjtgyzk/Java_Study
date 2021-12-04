package yu;

import java.util.Arrays;
import java.util.Comparator;

public class TanXinLow {
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String getLower(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        String ans = sb.toString();
        return ans;
    }
}
