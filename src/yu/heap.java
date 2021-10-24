package yu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Dagendui());
        heap.add(6);
        heap.add(2);
        heap.add(1);
        heap.add(3);
        heap.add(5);
        heap.add(4);
        System.out.println(heap);
    }

    public static class Dagendui implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
