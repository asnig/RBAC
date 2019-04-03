package com.atguigu.atcrowdfunding.dao;

import com.aiguigu.atcrowdfunding.bean.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from t_permission where pid is null")
    Permission queryRootPermission();

    @Select("select * from t_permission where pid = #{id}")
    List<Permission> queryChildPermissions(Integer id);

    @Select("select * from t_permission")
    List<Permission> queryAll();
}
