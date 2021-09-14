package myStudy.jieKou;

public class Cat extends Animal implements Jumping{
    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat() {
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void Jump() {
        System.out.println("猫跳高");
    }
}
