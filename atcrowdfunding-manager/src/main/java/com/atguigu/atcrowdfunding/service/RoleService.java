package com.atguigu.atcrowdfunding.service;


import com.aiguigu.atcrowdfunding.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    void insertRole(Role role);

    Role queryById(Integer id);

    void updateRole(Role role);

    void deleteRole(Integer id);

    void deleteRoles(Map<String, Object> map);

    List<Role> queryAll();
}
