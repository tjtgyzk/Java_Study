package com.Student;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int ans = 0;

        Point[] points = new Point[arr.length];
        for (int i = 0; i < arr.length; i++) {
            points[i] = new Point(arr[i], chars[i]);
        }
        Arrays.sort(points, new MyComparator());
        HashMap<Point, Integer> pointtimesHashMap = new HashMap();
        for (int i = 0; i < points.length - 1; i++) {
            if (pointtimesHashMap.containsKey(points[i])) {
                pointtimesHashMap.put(points[i], pointtimesHashMap.get(points[i]) + 1);
            } else {
                pointtimesHashMap.put(points[i], 1);
            }
        }
        for (Map.Entry<Point, Integer> entry : pointtimesHashMap.entrySet()) {
            ans += entry.getValue();
        }
        System.out.println(ans);
    }

    public static class MyComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.value - o2.value;
        }
    }

    public static class Point {
        int value;
        char color;

        public Point(int value, char color) {
            this.value = value;
            this.color = color;
        }
    }
}
