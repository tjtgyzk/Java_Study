package yu;

import java.util.Comparator;

public class comparatorYu implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        //返回负数的时候，第一个值在前面
        //返回正数的时候，第二个值在前面
        //返回0的时候，谁在前面无所谓

        return o2 - o1;


    }
}
