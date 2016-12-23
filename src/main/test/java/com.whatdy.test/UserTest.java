package com.whatdy.test;

import com.whatdy.mapper.UserMapper;
import com.whatdy.model.User;
import com.whatdy.service.UserService;
import com.whatdy.service.impl.UserServiceImpl;
import com.whatdy.utils.DBTools;
import com.whatdy.utils.Digest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需要注意的是没有使用SqlSession对象查询的数据都是没有进行缓存的数据.
 *
 */
public class UserTest {

    private UserService userService;

    @Before
    public void before() {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:conf/applicationContext.xml",
                        "classpath:conf/spring-mybatis.xml"});
        userService = (UserService) context.getBean("userServiceImpl");
    }
    /**
     * SqlSession案例
     * 通过 SqlSession查询数据,并且将查询的数据存储进二级缓存中
     */
    public void accessSessionSelect(){
        SqlSession sqlSession = DBTools.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAllUser();
        System.out.println(users);
    }
    //----------------全部通过service进行CURD-----------------------
    public void addUser() {
        User user = new User();
        user.setUsername("1577121881@qq.com");
        user.setPassword(Digest.encodeAes("123456"));
        System.out.println(userService.insertUser(user));
    }

    public void selectUserById() {
        User u = userService.selectUserById(5);
        System.out.println(u.toString());
    }

    @Test
    public void selectAllUser() {
        List<User> users = userService.selectAllUser();
        System.out.println(users);
    }

    public void updateUser() {
        User user = new User();
        user.setId(5);
        user.setUsername("45454554@qq.com");
        System.out.println(userService.updateUser(user));
    }

    public void deleteUser() {
        System.out.println(userService.deleteUser(4));
    }


    public void pageUser() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "1577121881@qq.com");
        params.put("index", 0);//从第几页开始。mysql是从0开始的
        params.put("pageSize", 5);//每页显示的数据条数
        try {
            List<User> u = userService.pageUser(params);
            for (User userBean : u) {
                System.out.println("--------" + userBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void countUser() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "45454554");
        int count;
        try {
            count = userService.countUser(params);
            System.out.println("符合条件的数据条数"+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}