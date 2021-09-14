package com.itheima;
import java.util.Scanner;
public class getMaxInArray {
    public static void main(String[] args) {
        //建立输入对象
        Scanner sc = new Scanner(System.in);
        //获取数组大小
        System.out.println("请输入数组大小");
        int length = sc.nextInt();
        //建立对应大小数组
        int[] arr = new int[length];
        //获取数组元素
        System.out.println("请输入数组元素");
        for(int i = 0; i<arr.length; i++)
        {
            arr[i] = sc.nextInt();
        }
        //获取最大值
        int max = getMaxInArray(arr);
        //输出结果
        System.out.println("数组中最大值为"+ max);
    }
    public static int getMaxInArray(int[] arr){
        int max = arr[0];
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

}
