package com.whatdy.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

/**
 * @author zyl 2016年12月14日13:22:57
 */
public class DBTools {

    public static SqlSessionFactory sessionFactory;
    static{
        sessionFactory = (DefaultSqlSessionFactory) BeanManager.getBean("sqlSessionFactory");
    }
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }

}
