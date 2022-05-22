package LeetCode;

public class L868 {
    public static int binaryGap(int n) {
        //n & (-n) 可以求出该数字最右侧的1 rightOne1
        //将rightOne1 与 n 异或, 可以消除最右侧的1
        //在将此时的n & (-n) 获取此时最右侧的1
        //每次将第二次的 1 右移 1位 ,若相等,则返回当前距离,若不相等,则距离加1
        //在n!=0时,说明存在下一个1,进行循环
        //找到最大的1
        //如果n==1或者n为2的整数次幂,则只存在一个1,直接返回0
        if (n == 1 || (n & (n - 1)) == 0) {
            return 0;
        }
        int length = 0;

        while (n != 0) {
            int curLength = 0;
            int lastRightOne = n & (-n);
            n ^= lastRightOne;
            int curRightOne = n & (-n);
            if (curRightOne == 0) {
                //说明不存在下一个1了,此时n==0了
                break;
            }
            while (lastRightOne != curRightOne) {
                curLength++;
                curRightOne >>= 1;
            }
            length = Math.max(length, curLength);
        }


        return length;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
