package yu;

import java.util.Arrays;
import java.util.Comparator;

public class ProgramTimesMax {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class MyComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int getMax(Program[] programs) {
        int timeline = 0;
        int ans = 0;
        Arrays.sort(programs, new MyComparator());
        for (Program cur : programs) {
            if (cur.start >= timeline) {
                ans++;
                timeline = cur.end;
            }
        }
        return ans;
    }
}
