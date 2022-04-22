package LeetCode.Arrays.Matrix;

import java.util.LinkedList;
import java.util.List;

public class L118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(1);
        if (numRows == 1) {
            list.add(list1);
            return list;
        }
        if (numRows == 2) {
            list.add(list1);
            list.add(list2);
            return list;
        }
        list.add(list1);
        list.add(list2);
        for (int i = 3; i <= numRows; i++) {
            LinkedList<Integer> listI = new LinkedList<>();
            listI.add(1);
            List<Integer> last = list.get(list.size() - 1);
            for (int j = 0; j < list.size() - 1; j++) {
                listI.add(last.get(j) + last.get(j + 1));
            }
            listI.add(1);
            list.add(listI);
        }
        return list;
    }
}
