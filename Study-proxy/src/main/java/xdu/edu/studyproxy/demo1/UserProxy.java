package xdu.edu.studyproxy.demo1;

public class UserProxy implements Rent {
    private User user;

    public UserProxy(Rent user) {
        this.user = (User) user;
    }

    @Override
    public void giveMoney() {
        System.out.println("感谢使用本平台~");
        user.giveMoney();
    }
}
