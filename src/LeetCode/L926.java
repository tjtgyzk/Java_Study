package LeetCode;

public class L926 {
    public int minFlipsMonoIncr(String s) {
        if (s.length() == 1) {
            return 0;
        }
        //用两个dp表分别记录前一位是0和1时的最小翻转次数,空间优化成2个变量
        //每一位选择好==确定前一位是0还是1
        int zero = 0, one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                //如果这一位不翻转,继续为0,则前一位必须是0,zero不变
                //如果这一位翻转为1,则前一位为0时,one = zero+1,前一位是1时,one = one+1,取小值
                one = Math.min(zero, one) + 1;
            } else {
                //如果这一位不翻转,继续为1,则前一位为0时,one = zero,前一位为1时,one = one,取最小值
                //如果这一位翻转为0,则前一位必须为0,zero = zero+1;
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(zero, one);
    }
}
