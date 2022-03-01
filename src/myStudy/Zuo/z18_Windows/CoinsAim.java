package myStudy.Zuo.z18_Windows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class CoinsAim {
    public static int function(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        //统计每张货币的数量,O(arr长度)
        HashMap<Integer, Integer> info = new HashMap<>();
        for (int c : arr) {
            if (info.containsKey(c)) {
                info.put(c, info.get(c) + 1);
            } else {
                info.put(c, 1);
            }
        }
        int[] costs = new int[info.size()];
        int[] numbers = new int[info.size()];
        int j = 0;
        for (Entry<Integer, Integer> e : info.entrySet()) {
            costs[j] = e.getKey();
            numbers[j++] = e.getValue();
        }
        //dp表建立
        //index：0-N
        //rest：0-aim
        int N = costs.length;
        int[][] dp = new int[N + 1][aim + 1];
        //index为N时，全为无效值（除了rest = 0）
        //rest为0时，均为0
        for (int r = 1; r <= aim; r++) {
            dp[N][r] = Integer.MAX_VALUE;
        }
        //按面值从下往上填，O（面值种类*aim）
        for (int index = N - 1; index >= 0; index--) {
            //从左向右分组填，每组的起始点为（aim+1和当前面值）的最小值
            for (int mod = 0; mod < Math.min((aim + 1), costs[index]); mod++) {
                //对于每组维护一个窗口最小值结构
                LinkedList<Integer> qmin = new LinkedList<>();
                //每组的起始点之前不再有下左的选择，因为减完一定rest小于0，故直接取下面的值
                dp[index][mod] = dp[index + 1][mod];
                //当前mod处的值（下侧值）也加入最小值队列，它可能作为该组之后数据的最小值
                qmin.add(mod);
                //接下来开始从每组的第二个更新最小值结构，并填入对应位置的数据,步长为当前面值
                for (int rest = mod + costs[index]; rest <= aim; rest += costs[index]) {
                    //判断末尾数据是否需要踢出,为了防止溢出，如果原有值是无效值（int最大值）则在加上张数（会溢出）之前踢出
                    //需要加上的张数为 之前张数+（当前下标（rest）-之前下标）/面值
                    while (!qmin.isEmpty() &&
                            (dp[index + 1][qmin.peekLast()] == Integer.MAX_VALUE
                                    || dp[index + 1][qmin.peekLast()] + (rest - qmin.peekLast()) / costs[index] >= dp[index + 1][rest])
                    ) {
                        qmin.pollLast();
                    }
                    //加入当前值
                    qmin.addLast(rest);
                    //踢出过期数据，过期数据的下标为 当前下标 - 当前面值（该组步长）* （张数+1）（到不了的地方）
                    int kickOut = rest - costs[index] * (numbers[index] + 1);
                    if (qmin.peekFirst() == kickOut) {
                        qmin.pollFirst();
                    }
                    //此时可以得到该点处的最小值，注意要加上该加的张数,如果就是正下方的值，则作差为0
                    dp[index][rest] = dp[index + 1][qmin.peekFirst()] + (rest - qmin.peekFirst()) / costs[index];
                }
            }
        }
        return dp[0][aim];
    }
}
