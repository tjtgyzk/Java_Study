package LeetCode.SwardOffer.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class OfferII_30 {
    class RandomizedSet {
        Random ran;
        HashMap<Integer, Integer> mapIndex;
        ArrayList<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            ran = new Random();
            mapIndex = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (mapIndex.containsKey(val)) {
                return false;
            } else {
                list.add(val);
                mapIndex.put(val, list.size() - 1);
                return true;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (mapIndex.containsKey(val)) {
                //不能用remove(index),会将该元素后所有元素左移,改变下标
                //将最后一个元素与该元素交换位置,删除最后一个元素即可
                int index = mapIndex.get(val);
                int last = list.get(list.size() - 1);
                list.set(index, last);
                mapIndex.put(last, index);
                mapIndex.remove(val);
                list.remove(list.size() - 1);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(ran.nextInt(list.size()));
        }
    }
}
