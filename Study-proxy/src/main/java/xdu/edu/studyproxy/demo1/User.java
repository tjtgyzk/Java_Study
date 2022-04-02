package xdu.edu.studyproxy.demo1;

public class User implements Rent {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "的电费已缴纳");
    }
}
