//package com.lmk.bootln2.controller;
//
//import com.lmk.bootln2.model.UserOnline;
//import com.lmk.bootln2.serivce.SessionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/online")
//public class SessionController {
//    @Autowired
//    SessionService sessionService;
//
//    @RequestMapping("index")
//    public String online() {
//        return "online";
//    }
//
//    @ResponseBody
//    @RequestMapping("list")
//    public List<UserOnline> list() {
//        return sessionService.list();
//    }
//
//    @ResponseBody
//    @RequestMapping("forceLogout")
//    public String forceLogout(String id) {
//        try {
//            sessionService.forceLogout(id);
//            return "ok";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "踢出用户失败";
//        }
//    }
//}