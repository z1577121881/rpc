package quickstart;

/**
 * Created by An on 2016/12/23.
 */
public class FooServiceImpl implements FooService {

    public String hello(String name) {
        System.out.println(name+" invoke rpc service");
        return "hello "+name;
    }
}
