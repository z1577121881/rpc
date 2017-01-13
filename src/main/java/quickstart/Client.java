package quickstart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动客户端
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:conf/motan_client.xml");
        FooService service = (FooService) ctx.getBean("remoteService");
        String str = service.hello("motan");
        System.out.println(str);

    }
}
