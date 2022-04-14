import edu.xdu.service.UserService;
import edu.xdu.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;

import static java.lang.Character.getType;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final byte b1 = 1;
        final byte b2 = 2;
        byte b3 = (b1 + b2);
        System.out.println(getType(b1));

    }
}
