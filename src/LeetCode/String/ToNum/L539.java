package LeetCode.String.ToNum;

import java.util.Collections;
import java.util.List;

public class L539 {
    //将数组排序,最短时间一定出现在相邻时间or头尾时间,如果出现在头尾时间则用头时间加上一天的分钟数-尾时间
    //将小时全部换算为分钟计算
    public int findMinDifference(List<String> timePoints) {
        int res = 24 * 60;
        Collections.sort(timePoints);
        int firstTime = getMinutes(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            res = Math.min(res, getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)));
        }
        return Math.min(res, firstTime + 1440 - getMinutes(timePoints.get(timePoints.size() - 1)));
    }

    public int getMinutes(String s) {
        return (s.charAt(0) * 10 + s.charAt(1)) * 60 + s.charAt(3) * 10 + s.charAt(4);
    }
}
