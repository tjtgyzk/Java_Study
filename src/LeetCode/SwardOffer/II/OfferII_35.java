package LeetCode.SwardOffer.II;

import java.util.Collections;
import java.util.List;

public class OfferII_35 {
    public int findMinDifference(List<String> timePoints) {
        //排序,这样最小时间差存在于相邻的两个时间之间或者头尾之间
        //一天中最大时间差为24*60 = 1440
        int ans = 1440;
        Collections.sort(timePoints);
        for (int i = 1; i < timePoints.size(); i++) {
            ans = Math.min(ans, getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)));
        }
        ans = Math.min(ans, getMinutes(timePoints.get(0)) + 1440 - getMinutes(timePoints.get(timePoints.size() - 1)));
        return ans;
    }

    public int getMinutes(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("05"));
    }
}
