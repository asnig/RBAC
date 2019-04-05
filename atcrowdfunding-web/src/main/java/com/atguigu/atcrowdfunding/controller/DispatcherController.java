package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.AjaxResult;
import com.aiguigu.atcrowdfunding.bean.Permission;
import com.aiguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.PermissionService;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author 10727
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转到主页
     *
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 执行登录功能
     *
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model) {
        //获取表单数据
        User dbUser = userService.query4Login(user);
        if (dbUser != null) {
            return "main";
        } else {
            String errorMsg = "用户名或密码错误，请重新输入";
            model.addAttribute("errorMsg", errorMsg);
            return "redirect:login";
        }
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session) {
        //获取表单数据
        User dbUser = userService.query4Login(user);
        AjaxResult result = new AjaxResult();
        if (dbUser != null) {
            result.setSuccess(true);
            List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
            Set<String> uriSet = new HashSet<>();
            Permission root = null;
            Map<Integer, Permission> permissionMap = new HashMap<>();
            for (Permission ps : permissions) {
                permissionMap.put(ps.getId(), ps);
                if (ps.getUrl() != null && "".equals(ps.getUrl())) {
                    uriSet.add(session.getServletContext().getContextPath() + ps.getUrl());
                }
            }

            for (Permission ps : permissions) {
                if (0 == ps.getPid()) {
                    root = ps;
                } else {
                    Permission parent = permissionMap.get(ps.getPid());
                    parent.getChildren().add(ps);
                }
            }
            session.setAttribute("rootPermission", root);
            session.setAttribute("loginUser", dbUser);
            session.setAttribute("authUriSet", uriSet);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
