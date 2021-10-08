package myStudy.dataStructure.Zuo;

/*
5.一个数组中有一种数出现K次，其他数都出现M次，M>1,K<M,找到出现了K次的数,如果这个数不为k次，返回-1
1）. 将每个int数字展开成为32位二进制
2）. 建立一个32位数组(空间复杂度O(1))，将这些数全部以二进制形式加在数组的对应位置上
3）. 如果在某一位上只存在出现了M次的数，则该位置上出现的总次数%M一定为0，不为0的即为出现K次的数据的二进制形式中不为0的位
4）. 将这些不为0的位找到，组合，即为出现了K次的数
*/
public class Demo02_KM {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 5, 5, 5, 0};
        System.out.println(onlyKTimes(arr, 1, 3));
    }

    public static int onlyKTimes(int[] arr, int K, int M) {//M>1,K<M
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {//32位数字
                t[i] += (num >> i) & 1;//对应的第i位数字即为原数字右移i位之后&1
            }
        }
        int res = 0;//注意，此处设置0是为了后面的或运算，如果该求的数就是0，则后续需要判断
        for (int i = 0; i < 32; i++) {
            if (t[i] % M == 0) {
                continue;
            }
            if (t[i] % M == K) {
                res |= (1 << i);
            } else {
                return -1;
            }
        }
        //补丁：如果这个数就是0，则上述循环一直continue，跳过判断是否为k次的选择，故加上对于0的判断
        if (res == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != K) {
                return -1;
            }
        }
        return res;
    }

}
