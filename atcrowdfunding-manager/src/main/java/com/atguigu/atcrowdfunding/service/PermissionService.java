package com.atguigu.atcrowdfunding.service;

import com.aiguigu.atcrowdfunding.bean.Permission;
import com.aiguigu.atcrowdfunding.bean.User;

import java.util.List;

/**
 * @author 10727
 */
public interface PermissionService {
    /**
     * 查询根节点
     *
     * @return 根节点
     */
    Permission queryRootPermission();

    /**
     * 查询指定节点的所有子节点
     *
     * @param id 指定节点的id
     * @return 子节点集合
     */
    List<Permission> queryChildPermissions(Integer id);

    /**
     * 查询所有许可
     *
     * @return 许可集合
     */
    List<Permission> queryAll();

    /**
     * 插入节点
     *
     * @param ps 要插入的节点
     */
    void insertPermission(Permission ps);

    /**
     * 根据id查询Permission
     *
     * @param id 要查询的id
     * @return 查询结果
     */
    Permission queryById(Integer id);

    /**
     * 修改许可
     *
     * @param permission 要修改的permission
     */
    void updatePermission(Permission permission);

    /**
     * 删除许可
     *
     * @param id 需要删除节点的id
     */
    void deletePermission(Integer id);

    /**
     * 查询角色拥有的许可
     *
     * @param roleid 角色id
     * @return 角色拥有的许可
     */
    List<Integer> queryPermissionidsByRoleid(Integer roleid);


    /**
     * 查询用户拥有的许可
     *
     * @param dbUser dbUser
     * @return 许可
     */
    List<Permission> queryPermissionsByUser(User dbUser);
}
