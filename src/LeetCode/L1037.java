package LeetCode;

public class L1037 {
    public boolean isBoomerang(int[][] points) {
        int[] point0 = points[0];
        int[] point1 = points[1];
        int[] point2 = points[2];
        if (isSamePoint(point0, point1) || isSamePoint(point1, point2) || isSamePoint(point0, point2)) {
            return false;
        }
        if ((point1[1] - point0[1]) * (point2[0] - point1[0]) == (point2[1] - point1[1]) * (point1[0] - point0[0])) {
            return false;
        }
        return true;
    }

    public boolean isSamePoint(int[] point1, int[] point2) {
        if (point1[0] == point2[0] && point1[1] == point2[1]) {
            return true;
        }
        return false;
    }
}
