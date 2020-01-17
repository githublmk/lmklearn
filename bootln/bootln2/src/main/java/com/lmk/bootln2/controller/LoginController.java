package com.lmk.bootln2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/403")
    public String forbid(){
        return "403";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/")
    public String login1(){
        return "login";
    }
    @RequestMapping("/tologin")
    public String toLogin(String username, String password, Model model){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (Exception e){
            model.addAttribute("value",e.getMessage());
            return "login";
        }
        return "index";



    }
}
