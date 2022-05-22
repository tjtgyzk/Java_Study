package LeetCode.SwardOffer.I;

public class Offer43 {
    public int countDigitOne(int n) {
        //举例,一个数字21532,我们来计算百位出现1的个数,位数k=3
        //首先,计算高一位的数字n/10^(k+1) = n1 = 21,这代表从00000到21000中在百位一共出现过n1*100个1
        //接下来计算当前千位也就是21000开始,在百位出现过多少个1
        //令num = n%10^(k+1) = 532 >= 199,可知百位从100-199出现过100个1
        //假如num < 100,则百位出现过0个1
        //假如num>=100 && num<199, 则百位出现过 num - 100 + 1 个 1
        //故一共出现过n2 = min(100,max(num-100+1,0))个1
        //n1+n2即为百位出现过的1的个数
        //我们从ki = 1,10,100,1000...开始遍历,如果n >= ki,则代表该位可能存在1,对应找到个位,十位,百位,千位..的1的个数,累加到一起即为最终结果
        //考虑到ki可能会溢出,使用long
        long ki = 1;
        int ans = 0;
        while (n >= ki) {
            int n1 = (int) (n / (10 * ki) * ki);
            int n2 = 0;
            int num = (int) (n % (10 * ki));
            n2 = (int) Math.min(ki, (int) Math.max(num - ki + 1, 0));
            ans += n1 + n2;
            ki *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Offer43().countDigitOne(13);
    }
}
