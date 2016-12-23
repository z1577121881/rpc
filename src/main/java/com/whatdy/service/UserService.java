package com.whatdy.service;

import com.whatdy.model.User;
import com.whatdy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface UserService {

    public int insertUser(User user);

    public User selectUserById(int id);

    public List<User> selectAllUser();

    public int updateUser(User user);

    public int deleteUser(int id);

    public List<User> pageUser(Map<String,Object> map);

    public int countUser(Map<String,Object> map);




}