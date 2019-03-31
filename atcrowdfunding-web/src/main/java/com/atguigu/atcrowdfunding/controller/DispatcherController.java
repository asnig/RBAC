package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.AJAXResult;
import com.aiguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

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
        AJAXResult result = new AJAXResult();
        if (dbUser != null) {
            result.setSuccess(true);
            session.setAttribute("loginUser", dbUser);
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