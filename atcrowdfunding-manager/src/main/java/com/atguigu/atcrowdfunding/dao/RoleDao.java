package com.atguigu.atcrowdfunding.dao;

import com.aiguigu.atcrowdfunding.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    void insertRole(Role role);

    @Select("select * from t_role where id = #{id}")
    Role queryById(Integer id);

    void updateRole(Role role);

    @Delete("delete from t_role where id = #{id}")
    void deleteRole(Integer id);

    void deleteRoles(Map<String, Object> map);
}
