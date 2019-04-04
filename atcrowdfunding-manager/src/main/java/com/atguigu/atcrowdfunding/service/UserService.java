package com.atguigu.atcrowdfunding.service;

import com.aiguigu.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author 10727
 */
public interface UserService {
    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    List<User> queryAll();

    /**
     * 根据用户名和密码查询用户
     *
     * @param user user
     * @return user
     */
    User query4Login(User user);

    /**
     * 分页查询用户
     *
     * @param map 分页必备的条件
     * @return 用户集合
     */
    List<User> pageQueryData(Map<String, Object> map);

    /**
     * 查询满足条件的用户数量
     *
     * @param map 条件
     * @return int
     */
    int pageQueryCount(Map<String, Object> map);

    /**
     * 添加用户
     *
     * @param user 需要添加的用户
     */
    void insertUser(User user);

    /**
     * 根据id查询用户
     *
     * @param id id
     * @return user
     */
    User queryById(Integer id);

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id id
     */
    void deleteUserById(Integer id);

    /**
     * 批量删除用户
     *
     * @param map 条件
     */
    void deleteUsers(Map<String, Object> map);

    /**
     * 批量添加角色
     *
     * @param map 条件
     */
    void insertUserRoles(Map<String, Object> map);

    /**
     * 批量删除角色
     *
     * @param map 条件
     */
    void deleteUserRoles(Map<String, Object> map);

    /**
     * 查询用户的所有角色id
     *
     * @param id 用户id
     * @return 用户的角色id
     */
    List<Integer> queryRoleidsById(Integer id);
}
