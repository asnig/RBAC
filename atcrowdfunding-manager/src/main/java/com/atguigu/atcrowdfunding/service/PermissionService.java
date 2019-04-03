package com.atguigu.atcrowdfunding.service;

import com.aiguigu.atcrowdfunding.bean.Permission;

import java.util.List;

public interface PermissionService {
    Permission queryRootPermission();

    List<Permission> queryChildPermissions(Integer id);

    List<Permission> queryAll();
}
