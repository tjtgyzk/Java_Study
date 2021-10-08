package myStudy.dataStructure.sort;

import java.util.Arrays;

public class shell {

    public static void ShellSort1(int[] arr) {
        int gap = arr.length / 2;//初始步长
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {//从步长的下一位开始，遍历每一组
                for (int j = i; j - gap >= 0; j -= gap) {//从每一组的第i个数据开始遍历这一组，直到该组的倒数第二个数据
                    if (arr[j] < arr[j - gap]) {//如果后一个元素更小，与前一个交换（类似冒泡）
                        int temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            gap /= 2;
        }
    }

    public static void ShellSort2(int[] arr) {
        int gap = arr.length / 2;//初始步长
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {//从步长的下一位开始，遍历其所在的组
                int value = arr[i];//保存待插入的数据
                int index = i;//保存待插入位置的索引
                for (int j = i; j - gap >= 0; j -= gap) {//从每一组的第i个数据开始遍历这一组，直到该组的倒数第二个数据,该循环的目的在于给i位置的数据所在的组找一个插入的位置

                    if (value < arr[j - gap]) {//如果后一个数据更小，将前一个数据后移，索引为前一个数据处
                        arr[j] = arr[j - gap];
                        index -= gap;
                    }
                }
                arr[index] = value;
            }
            System.out.println(Arrays.toString(arr));
            gap /= 2;
        }

    }
}
