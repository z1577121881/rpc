package com.whatdy.autowire;

import com.whatdy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Componment 设置的是组件扫描注解,为的就是让springmvc扫描
 */
@Component
public class User {

    public String name = "this is name";

    public User() {
    }
    public User(String name) {
        this.name = name;
    }


}
