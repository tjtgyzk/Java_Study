package LeetCode.SwardOffer.II;

import java.util.Map;
import java.util.TreeMap;

public class OfferII_58 {
    class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            //第一个起始时间小于等于start的日程
            Map.Entry<Integer, Integer> before = map.floorEntry(start);
            //第一个起始时间大于等于start的日程
            Map.Entry<Integer, Integer> after = map.ceilingEntry(start);
            if ((before == null || before.getValue() <= start) && (after == null || after.getKey() >= end)) {
                map.put(start, end);
                return true;
            }
            return false;
        }
    }
}
