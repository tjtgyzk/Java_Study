package LeetCode.String.Statistics;

public class L657 {
    public boolean judgeCircle(String moves) {
        //两个栈,分别存左右和上下,比如"LUDR",先压L到左右栈,在压U到上下栈,D和U能匹配,弹出U,R和L能匹配,弹出L
        //用四个变量可以模拟,两个也可以,左加右减上加下减即可
        int L = 0, R = 0;
        int U = 0, D = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'L' || c == 'R') {
                if (c == 'L') {
                    L++;
                } else {
                    R++;
                }
            } else {
                if (c == 'U') {
                    U++;
                } else {
                    D++;
                }
            }
        }
        return (L - R == 0) && (U - D == 0);
    }
}
