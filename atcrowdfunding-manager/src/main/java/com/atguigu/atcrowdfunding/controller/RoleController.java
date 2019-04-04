package com.atguigu.atcrowdfunding.controller;

import com.aiguigu.atcrowdfunding.bean.AjaxResult;
import com.aiguigu.atcrowdfunding.bean.Page;
import com.aiguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10727
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/deleteRoles")
    public Object deleteRoles(Integer[] roleid) {
        AjaxResult result = new AjaxResult();
        try {
            Map<String, Object> map = new HashMap<>(50);
            map.put("roleids", roleid);
            roleService.deleteRoles(map);

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
            roleService.deleteRole(id);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }


    @ResponseBody
    @RequestMapping("/update")
    public Object update(Role role) {
        AjaxResult result = new AjaxResult();
        try {
            roleService.updateRole(role);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Role role = roleService.queryById(id);
        model.addAttribute("role", role);
        return "role/edit";
    }

    @ResponseBody
    @RequestMapping("/insertRole")
    public Object insertRole(String rolename) {
        AjaxResult result = new AjaxResult();
        try {
            if (rolename == null || rolename.isEmpty()) {
                return result;
            }

            Role role = new Role();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            role.setCreatetime(sdf.format(new Date()));
            role.setRolename(rolename);
            roleService.insertRole(role);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @RequestMapping("/add")
    public String add() {
        return "role/add";
    }

    @RequestMapping("/index")
    public String index() {
        return "role/index";
    }

    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(Integer pageNo, Integer pageSize, String queryText) {
        AjaxResult result = new AjaxResult();

        try {
            Map<String, Object> map = new HashMap<>(50);
            map.put("start", (pageNo - 1) * pageSize);
            map.put("pageSize", pageSize);
            map.put("queryText", queryText);
            List<Role> roles = roleService.pageQueryData(map);
            int totalRecord = roleService.pageQueryCount(map);
            int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
            Page<Role> rolePage = new Page<>();
            rolePage.setDatas(roles);
            rolePage.setPageNo(pageNo);
            rolePage.setTotalRecord(totalRecord);
            rolePage.setTotalPage(totalPage);
            result.setData(rolePage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}
