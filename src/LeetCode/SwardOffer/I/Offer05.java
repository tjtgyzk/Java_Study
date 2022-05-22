package LeetCode.SwardOffer.I;

import java.util.PriorityQueue;

public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return sb.toString();
    }

    public static class Offer41 {
        //用一个小根堆保存较大的一半数,用一个大根堆保存较小的一半数
        //当两堆总大小为偶数时,即两堆大小相等时,优先往小根堆里放数据
        //放数据时,为了保证有序,先将数据放入另一个堆,再将堆顶元素弹入目标堆
        //当总大小为奇数时,弹出小根堆的头即为中位数,当总大小为偶数时,分别弹出一个数返回均值
        PriorityQueue<Integer> less;
        PriorityQueue<Integer> more;
        int size;

        public Offer41() {
            less = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
            more = new PriorityQueue<>();
            size = 0;
        }

        public void addNum(int num) {
            if (size % 2 == 0) {
                more.add(num);
                less.add(more.poll());
            } else {
                less.add(num);
                more.add(less.poll());
            }
            size++;

        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (double) (less.peek() + more.peek()) / 2;
            } else {
                return (double) less.peek();
            }
        }
    }
}
