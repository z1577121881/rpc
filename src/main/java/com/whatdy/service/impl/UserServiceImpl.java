package com.whatdy.service.impl;

import com.whatdy.mapper.UserMapper;
import com.whatdy.model.User;
import com.whatdy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service  业务逻辑层
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDAO;

    public int insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public User selectUserById(int id) {
        return userDAO.selectUserById(id);
    }

    public List<User> selectAllUser() {
        return userDAO.selectAllUser();
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public int deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    public List<User> pageUser(Map<String, Object> map) {
        return userDAO.pageUser(map);
    }
    public int countUser(Map<String, Object> map) {
        return userDAO.countUser(map);
    }

}