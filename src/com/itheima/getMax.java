package com.itheima;
import java.util.Scanner;
public class getMax {
    public static void main(String[] args) {
        int x = 0 ,y = 0;
        Scanner sc = new Scanner(System.in);//写入数据时，只需要new一个Scanner对象
      //Scanner sc2 = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        int max = getMax(x,y);
        System.out.println(max);
    }
    public static int getMax(int a,int b){
        int max = a>b?a:b;
        return max;
    }
}
