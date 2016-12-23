package com.whatdy.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangYL on 2016/7/16.
 */
public class BeanManager {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");

    public static Object getBean(String bean){
        return context.getBean(bean);
    }
}
