package com.Student;

public class Student {
    //成员变量
    private String name;
    private String age;
    private String sid;
    private String xingBie;
    //构造方法
    public Student(){
    }

    public Student(String name, String age, String sid, String xingBie) {
        this.name = name;
        this.age = age;
        this.sid = sid;
        this.xingBie = xingBie;
    }

    //方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getXingBie() {
        return xingBie;
    }

    public void setXingBie(String xingBie) {
        this.xingBie = xingBie;
    }
}

