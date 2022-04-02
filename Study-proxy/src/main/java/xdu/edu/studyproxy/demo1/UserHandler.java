package xdu.edu.studyproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserHandler implements InvocationHandler {
    //此处target为我们想代理的类
    private Object target;

    public UserHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args   代表方法需要的参数列表
     * @return 返回值
     * @throws Throwable 在此后执行每一个代理对象的方法时，执行的均为invoke方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.beforeRun();
        method.invoke(target, args);
        Log.afterRun();
        return null;
    }
}
