package LeetCode.SwardOffer.II;

public class OfferII_92 {
    public int minFlipsMonoIncr(String s) {
        //zero和one分别保存前一位是0或1时,最少翻转次数
        //每次都能确定上一位是0还是1
        int zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                //当前c==0,前一位如果是0,则不需要转换当前位,当前的zero等于上一次zero,不用变化
                //当然前一位是0,也可以选择转换当前位为1,则当前的one = 上一步的zero+1
                //前一位如果是1,则需要转换当前位为1,当前的one = 上一步的one+1,
                //保存这两个one中的最小值
                one = Math.min(one, zero) + 1;
            } else {
                //当前c==1,不转换当前位,前一位如果是0,则one = zero,前一位如果是1,则one = one,取这两个中的最小
                //转换当前位为0,前一个如果是0,则zero = zero+1,前一位如果是1,不可以将当前位转化为0,
                one = Math.min(one, zero);
                zero++;
            }
        }
        return Math.min(zero, one);
    }

}
