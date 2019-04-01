package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.AJAXResult;
import com.aiguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(Integer id) {
        AJAXResult result = new AJAXResult();
        try {

            userService.deleteUserById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }


    @ResponseBody
    @RequestMapping("/update")
    public Object update(User user) {
        AJAXResult result = new AJAXResult();

        try {

            userService.updateUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {

        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "/user/edit";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(User user) {
        AJAXResult result = new AJAXResult();

        try {
            user.setUserpswd("123456");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setCreatetime(sdf.format(new Date()));
            userService.insertUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(String queryText, Integer pageNo, Integer pageSize) {
        AJAXResult result = new AJAXResult();

        try {
            //分页查询
            Map<String, Object> map = new HashMap<>();
            map.put("start", (pageNo - 1) * pageSize);
            map.put("size", pageSize);
            map.put("queryText", queryText);

            List<User> users = userService.pageQueryData(map);
            int totalRecord = userService.pageQueryCount(map);
            int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
            Page<User> userPage = new Page<>();
            userPage.setDatas(users);
            userPage.setPageNo(pageNo);
            userPage.setTotalRecord(totalRecord);
            userPage.setTotalPage(totalPage);
            result.setData(userPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/index1")
    public String index1(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                         @RequestParam(required = false, defaultValue = "4") Integer pageSize, Model model) {

        //分页查询
        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageNo - 1) * pageSize);
        map.put("size", pageSize);
        List<User> users = userService.pageQueryData(map);
        int totalRecord = userService.pageQueryCount(map);
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        model.addAttribute("users", users);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageNo", pageNo);
        return "user/index";
    }
}
