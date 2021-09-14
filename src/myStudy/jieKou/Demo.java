package myStudy.jieKou;

public class Demo {
    public static void main(String[] args) {
        Jumping j = new Cat();
        j.Jump();
        System.out.println("---------");
        Animal a = new Cat();
        a.setAge(2);
        a.setName("凉皮");
        System.out.println(a.getName()+","+a.getAge());
        a.eat();
        a.Jump();
        ((Cat)a).Jump();
        a.Jump();

    }
}
