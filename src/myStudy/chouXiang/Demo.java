package myStudy.chouXiang;

public class Demo {
    public static void main(String[] args) {
        Animal a1 = new Cat("凉皮",2);
        System.out.println(a1.getName()+","+ a1.getAge());
        a1.eat();
    }
}
