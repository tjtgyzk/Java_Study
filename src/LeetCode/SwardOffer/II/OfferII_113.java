package LeetCode.SwardOffer.II;

import java.util.*;

public class OfferII_113 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //拓扑排序,key:课程编号,value入度
        Map<Integer, Integer> in = new HashMap<>();
        //保存每门课程对应的,依赖它的课程
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            int cur = prerequisites[i][0];
            int need = prerequisites[i][1];
            List<Integer> dependency = dependencies.getOrDefault(need, new LinkedList<>());
            dependency.add(cur);
            dependencies.put(need, dependency);
            in.put(cur, in.getOrDefault(cur, 0) + 1);
        }
        //保存所有入度为0的点
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!in.containsKey(i)) {
                que.add(i);
            }
        }
        //如果没有入度为0的点,返回空数组
        if (que.isEmpty()) {
            return new int[]{};
        }
        int[] ans = new int[numCourses];
        while (!que.isEmpty()) {
            Integer cur = que.poll();
            ans[index++] = cur;
            List<Integer> dependency = dependencies.get(cur);
            if (dependency != null) {
                for (Integer curD : dependency) {
                    in.put(curD, in.get(curD) - 1);
                    if (in.get(curD) == 0) {
                        que.add(curD);
                    }
                }
            }
        }
        //可能存在循环依赖
        return index == numCourses ? ans : new int[]{};
    }
}
