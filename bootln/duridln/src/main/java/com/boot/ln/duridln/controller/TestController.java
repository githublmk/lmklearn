package com.boot.ln.duridln.controller;

import com.boot.ln.duridln.aspect.Log;
import com.boot.ln.duridln.mode.Test;
import com.boot.ln.duridln.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;


@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @Log("query")
    @RequestMapping("/query")
    public HashMap<String, Object> query(String id){
        Test  test =null;
        if(id!=null){
            test = new Test();
            test.setId(new Integer(id));
        }
        HashMap<String,Object> map =new HashMap<>();
        List<Test> query = testService.query(test);
        map.put("dataList",query);
        return map;
    }

    @Log("query")
    @RequestMapping("/queryById")
    public HashMap<String, Object> queryTestById(String id){

        HashMap<String,Object> map =new HashMap<>();
        Test query = testService.queryTestById(id);
        map.put("dataList",query);
        return map;
    }
    @Log("add")
    @RequestMapping("/add")
    public HashMap<String,Object> add(@RequestParam(name = "name") String name, @RequestParam(name = "note")String note){
        HashMap<String,Object> map =new HashMap<>();
        Test test = new Test();
        test.setName(name);
        test.setNote(note);
        testService.add(test);
        List<Test> query = testService.query(test);
        map.put("dataList",query);
        return map;
    }
}
