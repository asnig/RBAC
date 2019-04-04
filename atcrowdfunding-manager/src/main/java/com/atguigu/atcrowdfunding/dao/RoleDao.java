package com.atguigu.atcrowdfunding.dao;

import com.aiguigu.atcrowdfunding.bean.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author 10727
 */
public interface RoleDao {
    /**
     * 按条件查询角色信息
     *
     * @param map 条件
     * @return 角色信息
     */
    List<Role> pageQueryData(Map<String, Object> map);

    /**
     * 按条件查询数量
     *
     * @param map 条件
     * @return 数量
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     * 插入角色
     *
     * @param role 需要插入的角色
     */
    void insertRole(Role role);

    /**
     * 根据id查询角色
     *
     * @param id
     * @return
     */
    @Select("select * from t_role where id = #{id}")
    Role queryById(Integer id);

    /**
     * 修改角色
     *
     * @param role 需要修改的角色
     */
    void updateRole(Role role);

    /**
     * 删除指定id的角色
     *
     * @param id
     */
    @Delete("delete from t_role where id = #{id}")
    void deleteRole(Integer id);

    /**
     * 批量删除角色
     *
     * @param map 存放了所有要删除角色的id
     */
    void deleteRoles(Map<String, Object> map);

    /**
     * 查询所有角色
     *
     * @return 角色集合
     */
    @Select("select * from t_role")
    List<Role> queryAll();
}
