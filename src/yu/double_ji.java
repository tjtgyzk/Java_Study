package yu;

public class double_ji {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 3, 4, 1};//3和4
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];//eor = a^b
        }
        int rightOne = eor & (-eor);//找到了最右侧1
        int eor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            //p位置上为1的数异或一遍
            if ((arr[i] & rightOne) != 0) {//如果第3个位置是1
                eor2 ^= arr[i];//eor2 = 其中一个数  a或者b
            }
        }
        eor ^= eor2;//找到另一个数
        System.out.println(eor + " " + eor2);
    }
}
