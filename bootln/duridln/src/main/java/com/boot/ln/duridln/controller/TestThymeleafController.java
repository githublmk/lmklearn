package com.boot.ln.duridln.controller;

import com.boot.ln.duridln.mode.SysLog;
import com.boot.ln.duridln.mode.Test;
import com.boot.ln.duridln.service.TestService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestThymeleafController {
    @Autowired
    private TestService testService;
    @RequestMapping("/query1")
    public String query1(Model model,String id){
        Test  test =null;
        if(id!=null){
            test = new Test();
            test.setId(new Integer(id));
        }
        List<Test> query = testService.query(test);
        model.addAttribute("datalist",query);
        return "test";
    }
}
