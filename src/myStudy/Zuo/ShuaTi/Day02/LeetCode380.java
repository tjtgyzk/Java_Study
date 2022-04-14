package myStudy.Zuo.ShuaTi.Day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LeetCode380 {
    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private int i;
    Random r;

    public LeetCode380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
        i = 0;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, i++);
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            //将最后一个元素移到该位置
            list.set(index, last);
            //更新最后一个元素的位置!
            map.put(last, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        int index = r.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        LeetCode380 test = new LeetCode380();
//        System.out.println(test.remove(0));
//        System.out.println(test.remove(0));
//        System.out.println(test.insert(0));
//        System.out.println(test.getRandom());
//        System.out.println(test.remove(0));
//        System.out.println(test.insert(0));
        //["RandomizedSet","insert","insert","getRandom","getRandom","insert","remove","getRandom","getRandom","insert","remove"]
        //[[],[3],[3],[],[],[1],[3],[],[],[0],[0]]
        System.out.println(test.insert(3));
        System.out.println(test.insert(3));
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.insert(1));
        System.out.println(test.remove(3));
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.insert(0));
        System.out.println(test.remove(0));
    }
}
