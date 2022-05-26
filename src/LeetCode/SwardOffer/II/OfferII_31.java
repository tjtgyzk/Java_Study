package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.HashMap;

public class OfferII_31 {
    class LRUCache {
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;
        int maxSize;

        public LRUCache(int capacity) {
            list = new ArrayList<>();
            map = new HashMap<>();
            maxSize = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int index = list.indexOf(key);
                list.remove(index);
                list.add(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, value);
                int index = list.indexOf(key);
                list.remove(index);
                list.add(key);
            } else {
                if (list.size() == maxSize) {
                    Integer delete = list.get(0);
                    map.remove(delete);
                    list.remove(0);
                }
                list.add(key);
                map.put(key, value);
            }
        }
    }
}
