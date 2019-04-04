package com.atguigu.atcrowdfunding.dao;

import com.aiguigu.atcrowdfunding.bean.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 10727
 */
public interface PermissionDao {
    /**
     * 查询根节点
     *
     * @return 根节点
     */
    @Select("select * from t_permission where pid is null")
    Permission queryRootPermission();

    /**
     * 查询指定节点的所有子节点
     *
     * @param id 指定节点的id
     * @return 子节点集合
     */
    @Select("select * from t_permission where pid = #{id}")
    List<Permission> queryChildPermissions(Integer id);

    /**
     * 查询所有许可
     *
     * @return 许可集合
     */
    @Select("select * from t_permission")
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
    @Select("select * from t_permission where id = #{id}")
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
    @Delete("delete from t_permission where id = #{id}")
    void deletePermission(Integer id);
}
