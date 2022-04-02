import edu.xdu.service.UserService;
import edu.xdu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //获取ApplicationContext：拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //需要什么就get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
