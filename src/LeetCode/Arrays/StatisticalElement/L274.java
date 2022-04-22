package LeetCode.Arrays.StatisticalElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L274 {
    public int hIndex(int[] citations) {
        //将数组排序,从大到小遍历
        //h初始值为0,表示有h篇引用次数至少h次的论文
        //如果当前arr[i] > h,则说明又找到了一篇引用次数至少h+1次的论文,则h可以+1,表示有h+1篇引用次数至少h+1次的论文
        //由于int数组不能自定义比较器,故从小到大排序后由后向前遍历即可
        //最后返回h
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            }
        }

        return h;


    }
}
