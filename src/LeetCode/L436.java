package LeetCode;

import java.util.PriorityQueue;

public class L436 {
    public class Point {
        int start;
        int end;
        int index;

        public Point(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int[] ans = new int[intervals.length];
        PriorityQueue<Point> startQue = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));
        PriorityQueue<Point> endQue = new PriorityQueue<>((o1, o2) -> (o1.end - o2.end));
        for (int i = 0; i < intervals.length; i++) {
            Point point = new Point(intervals[i][0], intervals[i][1], i);
            startQue.add(point);
            endQue.add(point);
        }
        while (!endQue.isEmpty()) {
            Point curPoint = endQue.poll();
            int curAns;
            while (!startQue.isEmpty() && startQue.peek().start < curPoint.end) {
                startQue.poll();
            }
            if (startQue.isEmpty()) {
                curAns = -1;
            } else {
                curAns = startQue.peek().index;
            }
            ans[curPoint.index] = curAns;
        }
        return ans;
    }
}
