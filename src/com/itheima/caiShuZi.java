package com.itheima;
import java.util.Scanner;
import java.util.Random;
public class caiShuZi {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(101);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("请输入要猜的数字：");
            int guess = sc.nextInt();
            if(guess > num)
            {
                System.out.println("大了");
            }else if(guess < num)
            {
                System.out.println("小了");
            }else{
                System.out.println("对了");
                break;
            }
        }
    }
}
