package com.lmk.bootln2.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:user")
    @RequestMapping("list")
    public String userList(Model model){
        model.addAttribute("value","获取用户信息");
        return "user";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("add")
    public String userAdd(Model model){
        model.addAttribute("value","添加一个用户");
        return "user";
    }
    @RequestMapping("delete")
    @RequiresPermissions("user:delete")
    public String userDelete(Model model){
        model.addAttribute("value","删除一个用户");
        return "user";
    }
}
