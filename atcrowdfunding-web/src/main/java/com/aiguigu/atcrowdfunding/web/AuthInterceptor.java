package com.aiguigu.atcrowdfunding.web;

import com.aiguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 10727
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        String path = request.getSession().getServletContext().getContextPath();
        Set<String> uriSet = new HashSet<>();
        List<Permission> permissions = permissionService.queryAll();
        for (Permission permission : permissions) {
            if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
                uriSet.add(path + permission.getUrl());
            }
        }
        if (uriSet.contains(uri)) {
            Set<String> authUriSet = (Set<String>)request.getSession().getAttribute("authUriSet");
            if (authUriSet.contains(uri)) {
                return true;
            } else {
                response.sendRedirect(path + "/error");
                return false;
            }
        } else {
            return true;
        }
    }
}
