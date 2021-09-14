package com.itheima;

import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("请输入数组大小");
        int length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("请输入数组元素");
        for (int i = 0; i<length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("输入的数组为");
        PrintArray(arr);
        ReverseArray(arr);
        System.out.println("反转后的数组为");
        PrintArray(arr);
    }
    public static void PrintArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i<arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void ReverseArray (int[] arr){
        for (int begin = 0, end = arr.length-1; begin<=end; begin++,end--) {
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
        }
    }

}
