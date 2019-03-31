package com.atguigu.atcrowdfunding.service;

import com.aiguigu.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);

    List<User> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);
}