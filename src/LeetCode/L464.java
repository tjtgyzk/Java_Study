package LeetCode;

import java.util.HashMap;

public class L464 {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //maxChoosableInteger<=20,故可以用int的每一位代表1到maxChoosableInteger的某个数是否被选择过
        //如果maxChoosableInteger大于等于desiredTotal,则先手第一步可以直接获胜
        //如果累加起来都小于desiredTotal,则无论如何不可能获胜
        //记忆化搜索
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return process(maxChoosableInteger, 0, 0, desiredTotal);
    }

    public boolean process(int maxChoosableInteger, int chosedNum, int curSum, int desiredTotal) {
        if (map.containsKey(chosedNum)) {
            return map.get(chosedNum);
        }
        boolean flag = false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((chosedNum & (1 << i)) == 0) {
                if (curSum + i >= desiredTotal) {
                    flag = true;
                    break;
                }
                if (!process(maxChoosableInteger, chosedNum | (1 << i), curSum + i, desiredTotal)) {
                    flag = true;
                    break;
                }
            }
        }
        map.put(chosedNum, flag);
        return flag;
    }
}
