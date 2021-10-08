package myStudy.dataStructure.sort;

import java.util.Arrays;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        //验证算法的正确性
        int[] arr1 = {5, 2, 3, 4, 1};
        System.out.println("冒泡排序");
        bubble.BubbleSort(arr1);

        int[] arr2 = {5,2,3,4,1};
        System.out.println("选择排序");
        select.SelectSort(arr2);

        int[] arr3 = {5,2,3,4,1};
        System.out.println("插入排序");
        insertion.InserationSortZ(arr3);

        int[] arr4 = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("希尔排序（交换法）");
        shell.ShellSort1(arr4);

        int[] arr5 = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("希尔排序（移位法）");
        shell.ShellSort2(arr5);
/*
        //计算算法耗时

        //构造随机数组
        int[] arr = new int[80000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        //
        //构造时间起始点
        long startTime = System.currentTimeMillis();
        //
        //排序算法部分
        select.SelectSort(arr);
        //
        //构造时间终止点
        long endTime = System.currentTimeMillis();
        //
        //计算时间差
        System.out.println("该排序算法耗时" + (endTime - startTime) + "ms");
        //
*/
    }
}
