package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/index")
    public String index() {
        return "permission/index";
    }

    @RequestMapping(value = "/loadData")
    @ResponseBody
    public Object loadData() {
        List<Permission> permissions = new ArrayList<>();

        List<Permission> allPermissions = permissionService.queryAll();
        Map<Integer, Permission> map = new HashMap<>();
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
