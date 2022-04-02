package xdu.edu.studyproxy.demo1;

public class Test {
    public static void main(String[] args) {
        Rent me = new User("我");
        Rent userProxy = new UserProxy(me);
        userProxy.giveMoney();
    }
}
