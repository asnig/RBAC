package com.atguigu.atcrowdfunding.service.impl;

import com.aiguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.UserDao;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User query4Login(User user) {
        return userDao.query4Login(user);
    }

    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteUsers(Map<String, Object> map) {
        userDao.deleteUsers(map);
    }

}
