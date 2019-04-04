package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.AjaxResult;
import com.aiguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10727
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(Permission ps) {
        AjaxResult result = new AjaxResult();
        try {
            permissionService.insertPermission(ps);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update(Permission permission) {
        AjaxResult result = new AjaxResult();
        try {
            permissionService.updatePermission(permission);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(Integer id) {
        AjaxResult result = new AjaxResult();
        try {
            permissionService.deletePermission(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Permission permission = permissionService.queryById(id);
        model.addAttribute("permission", permission);
        return "permission/edit";
    }

    @RequestMapping("/add")
    public String add() {
        return "permission/add";
    }

    @RequestMapping("/index")
    public String index() {
        return "permission/index";
    }

    @RequestMapping(value = "/loadData")
    @ResponseBody
    public Object loadData() {
        List<Permission> permissions = new ArrayList<>();

        List<Permission> allPermissions = permissionService.queryAll();
        Map<Integer, Permission> map = new HashMap<>(50);
        for (Permission ps : allPermissions) {
            map.put(ps.getId(), ps);
        }

        for (Permission ps : allPermissions) {
            if (ps.getPid() == 0) {
                permissions.add(ps);
            } else {
                Permission parent = map.get(ps.getPid());
                parent.getChildren().add(ps);
            }
        }
        return permissions;

    }

    /**
     * 通过递归的方式查询子节点
     * 效率低
     *
     * @param parent
     */
    private void queryChildPermissions(Permission parent) {
        List<Permission> childPermissions = permissionService.queryChildPermissions(parent.getId());

        for (Permission childPermission : childPermissions) {
            queryChildPermissions(childPermission);
        }

        parent.setChildren(childPermissions);
    }
}
