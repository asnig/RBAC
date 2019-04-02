package com.atguigu.atcrowdfunding.service.impl;

import com.aiguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.dao.RoleDao;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> pageQueryData(Map<String, Object> map) {
        return roleDao.pageQueryData(map);
    }

    @Override
    public int pageQueryCount(Map<String, Object> map) {
        return roleDao.pageQueryCount(map);
    }

    @Override
    public void insertRole(Role role) {
        roleDao.insertRole(role);
    }

    @Override
    public Role queryById(Integer id) {
        return roleDao.queryById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.deleteRole(id);
    }

    @Override
    public void deleteRoles(Map<String, Object> map) {
        roleDao.deleteRoles(map);
    }
}
