package com.atguigu.atcrowdfunding.service.impl;

import com.aiguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.dao.PermissionDao;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10727
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Permission queryRootPermission() {
        return permissionDao.queryRootPermission();
    }

    @Override
    public List<Permission> queryChildPermissions(Integer id) {
        return permissionDao.queryChildPermissions(id);
    }

    @Override
    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    @Override
    public void insertPermission(Permission ps) {
        permissionDao.insertPermission(ps);
    }

    @Override
    public Permission queryById(Integer id) {
        return permissionDao.queryById(id);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }

    @Override
    public void deletePermission(Integer id) {
        permissionDao.deletePermission(id);
    }
}
