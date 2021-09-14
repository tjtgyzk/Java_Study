package com.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        //集合
        ArrayList<Student> studentArrayList = new ArrayList<>();
        //界面
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            //判断
            switch (choice) {
                case "1":
                    addStudent(studentArrayList);
                    break;
                case "2":
                    deleteStudent(studentArrayList);
                    break;
                case "3":
                    changeStudent(studentArrayList);
                    break;
                case "4":
                    showStudent(studentArrayList);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }

    }

    //添加学生
    public static void addStudent(ArrayList<Student> studentArrayList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生性别：");
        String xingBie = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生学号：");
        String sid = sc.nextLine();
        while(isUsed(studentArrayList,sid)) {
            System.out.println("该学号已被占用，请重新输入");
            sid = sc.nextLine();
        }
        Student student = new Student(name, age, sid, xingBie);
        studentArrayList.add(student);
        System.out.println("添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> studentArrayList) {
        if (studentArrayList.size() == 0) {
            System.out.println("目前没有学生记录在册，请添加后重试");
        } else {
            int index = -1;
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要删除学生的学号：");
            String sid = sc.nextLine();
            for (int i = 0; i < studentArrayList.size(); i++) {
                Student student = studentArrayList.get(i);
                if (student.getSid().equals(sid)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("未找到该学生，请重试");
            } else {
                studentArrayList.remove(index);
                System.out.println("删除成功");
            }
        }
    }

    //修改学生
    public static void changeStudent(ArrayList<Student> studentArrayList) {
        if(studentArrayList.size()==0)
        {
            System.out.println("目前没有学生记录在册，请添加后重试");
        }else
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入要修改学生的学号：");
            String sid = sc.nextLine();
            int index = -1;
            for (int i = 0; i<studentArrayList.size(); i++){
                Student student = studentArrayList.get(i);
                if(student.getSid().equals(sid)){
                    index = i;
                    break;
                }
            }
            if(index == -1)
            {
                System.out.println("未查找到该学生，请重试");
            }else
            {
                System.out.println("请输入新的姓名：");
                String name = sc.nextLine();
                System.out.println("请输入新的性别：");
                String xingBie = sc.nextLine();
                System.out.println("请输入新的年龄：");
                String age = sc.nextLine();
                System.out.println("请输入新的学号：");
                String sid1 = sc.nextLine();
                while((isUsed(studentArrayList,sid1))&&(!sid1.equals(sid)))
                {
                    System.out.println("该学号已被占用，请重新输入");
                    sid1 = sc.nextLine();
                }
                Student student = new Student(name, age, sid1, xingBie);
                studentArrayList.set(index,student);
                System.out.println("修改成功");
            }
        }
    }

    //查看所有学生
    public static void showStudent(ArrayList<Student> studentArrayList) {
        if (studentArrayList.size() == 0) {
            System.out.println("目前没有学生记录在册，请添加后重试");
        } else {
            System.out.println("学号\t\t姓名\t\t性别\t\t年龄");
            for (int i = 0; i < studentArrayList.size(); i++) {
                Student student = studentArrayList.get(i);
                System.out.println(student.getSid() + "\t\t" + student.getName() + "\t"
                        + student.getXingBie() + "\t\t" + student.getAge() + "岁");
            }
        }
    }
    //学号是否被占用
    public static boolean isUsed(ArrayList<Student> studentArrayList,String sid) {
        boolean flag = false;
        for (int i = 0; i<studentArrayList.size(); i++){
            Student student = studentArrayList.get(i);
            if(student.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
