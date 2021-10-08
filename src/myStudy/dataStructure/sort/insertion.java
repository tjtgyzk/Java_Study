package myStudy.dataStructure.sort;

import java.util.Arrays;

public class insertion {
    /*
    public static void InsertionSort(int[] arr) {//把n个待排序元素看成有序表和无序表，每次从无序表中取出第一个元素插入到有序表的适当位置
        for (int i = 1; i < arr.length; i++) {//随着循环的进行，无序列表的长度在缩短，从第i位开始到结束为无序列表
            int value = arr[i];//取得无序列表的第一个
            int index = 0;//指示插入的位置
            for (int j = i - 1; j >= 0; j--) {//从有序列表的第一个一直遍历到头
                index = j;
                if (value <= arr[j]) {
                    arr[j + 1] = arr[j];//如果待排序的当前值小于有序列表的当前值，将有序列表的当前值后移一位
                    index--;
                } else {//如果大于当前值，则当前位置的后一个位置为目标位置,退出循环
                    break;
                }
            }
            arr[index + 1] = value;
            System.out.println(Arrays.toString(arr));
        }
    }*/
    public static void InserationSortZ(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//i为无序列表的头元素
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {//j从i左边第一个数开始，当j左边还有数且左边的数大于右边的数时进行循环，内容为交换
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
