package com.boot.ln.duridln.controller;

import com.boot.ln.duridln.mapper.TestMapperDao;
import com.boot.ln.duridln.mode.Test;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestMapperController {

    @Autowired
    private TestMapperDao testMapperDao;

    @RequestMapping("/mapper/query")
    @ResponseBody
    public Map<String,Object> selectall(){
        List<Test> tests = testMapperDao.selectAll();
        HashMap<String,Object> map =new HashMap<>();
        map.put("data",tests);
        return map;
    }
    @RequestMapping("/mapper/query/page/{num}")
    @ResponseBody
    public Map<String,Object> query(@PathVariable(name = "num")int num){

        PageHelper.startPage(num,2);
        List<Test> tests = testMapperDao.selectAll();
        PageInfo<Test> pageInfo = new PageInfo<>(tests);
        HashMap<String,Object> map =new HashMap<>();
        map.put("data",pageInfo);
        return map;
    }
}
