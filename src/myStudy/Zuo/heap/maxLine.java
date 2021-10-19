package myStudy.Zuo.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class maxLine {
    public static int findMaxLine(int[][] linearr) {
        line[] lines = new line[linearr.length];
        for (int i = 0; i < linearr.length; i++) {
            lines[i] = new line(linearr[i][0], linearr[i][1]);
        }
        Arrays.sort(lines, new StartComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            while (heap.peek() <= lines[i].start && !heap.isEmpty()) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class StartComparator implements Comparator<line> {

        @Override
        public int compare(line o1, line o2) {
            return o1.start - o2.start;
        }
    }

    public static class line {
        int start;
        int end;

        public line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
