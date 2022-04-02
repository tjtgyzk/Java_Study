package xdu.edu.studyproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test2 {
    public static void main(String[] args) {
        //实例化要被代理的对象
        User me = new User("我");
        //创建一个handler
        InvocationHandler userHandler = new UserHandler(me);
        //创建一个代理对象来代理me,这里利用Proxy类的一个静态方法newProxyInstance
        /**
         * newProxyInstance的三个参数
         * loder：用哪个类加载器去加载代理对象（由于双亲委派模型，这里使用User的或者Rent应该是一样的）
         * interfaces：动态代理类需要实现的接口，这里应该是可以强转为Rent的原因
         * handler：即为实现了InvocationHandler接口的类的实例，会调用该实例的invoke方法
         */
        Rent meProxy = (Rent) Proxy.newProxyInstance(me.getClass().getClassLoader(), me.getClass().getInterfaces(), userHandler);
        //使用生成的代理实例来完成交电费的操作
        meProxy.giveMoney();
    }
}
